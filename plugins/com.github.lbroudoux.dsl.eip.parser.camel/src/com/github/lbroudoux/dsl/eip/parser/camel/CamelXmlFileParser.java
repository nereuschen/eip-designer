/*
 * Licensed to Laurent Broudoux (the "Author") under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Author licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.github.lbroudoux.dsl.eip.parser.camel;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.emf.common.util.EList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.github.lbroudoux.dsl.eip.Channel;
import com.github.lbroudoux.dsl.eip.CompositeProcessor;
import com.github.lbroudoux.dsl.eip.EIPModel;
import com.github.lbroudoux.dsl.eip.EipFactory;
import com.github.lbroudoux.dsl.eip.Endpoint;
import com.github.lbroudoux.dsl.eip.Resequencer;
import com.github.lbroudoux.dsl.eip.Route;

/**
 * Parser for Apache Camel Xml route file. Just build a new instance and call
 * <code>parseAndFillModel()</code> with already initialized model and it should go !
 * @author laurent
 */
public class CamelXmlFileParser {

   private final File routeFile;
   
   public CamelXmlFileParser(File routeFile) {
      this.routeFile = routeFile;
   }
   
   /**
    * Parse the routeFile given while building the instance and fill the model.
    * @param model The EIP Model to fill with parsed elements from routeFile.
    * @throws InvalidArgumentException if given file is not a valid Spring integration file
    */
   public void parseAndFillModel(EIPModel model) throws Exception {
      // Parse and get root element.
      Document document = parseRouteFile();
      Element root = document.getDocumentElement();
      
      NodeList routes = root.getElementsByTagName("route");
      for (int i=0; i<routes.getLength(); i++) {
         Node routeNode = routes.item(i);
         Element routeElement = (Element)routeNode;
         
         Route route = EipFactory.eINSTANCE.createRoute();
         if (routeElement.hasAttribute("id")) {
            route.setName(routeElement.getAttribute("id"));
         }
         model.getOwnedRoutes().add(route);
         
         // Then extract and recursively add endpoints and channels to model.
         Node child = routeNode.getFirstChild();
         parseAndFillEndpoint(child, null, route.getOwnedEndpoints(), route.getOwnedChannels());
      }
   }
   
   /** Parse given Node and fill and fill the given endpoint and channel collections. */
   private void parseAndFillEndpoint(Node endpointNode, Channel incomingChannel, EList<Endpoint> endpoints, EList<Channel> channels) {
      if (endpointNode != null) {
         
         if (endpointNode.getNodeType() == Node.ELEMENT_NODE) {
            Element endpointElement = (Element) endpointNode;
            Endpoint endpoint = null;
            boolean inspectChildren = false;
            
            // Determine the correct implementation of Endpoint.
            if ("from".equals(endpointElement.getLocalName())) {
               endpoint = EipFactory.eINSTANCE.createGateway();
            } else if ("transform".equals(endpointElement.getLocalName())) {
               endpoint = EipFactory.eINSTANCE.createTransformer();
            } else if ("choice".equals(endpointElement.getLocalName())) {
               endpoint = EipFactory.eINSTANCE.createRouter();
               inspectChildren = true;
            } else if ("filter".equals(endpointElement.getLocalName())) {
               endpoint = EipFactory.eINSTANCE.createFilter();
               inspectChildren = true;
            } else if ("pipeline".equals(endpointElement.getLocalName())) {
               endpoint = EipFactory.eINSTANCE.createCompositeProcessor();
               inspectChildren = true;
            } else if ("split".equals(endpointElement.getLocalName())) {
               endpoint = EipFactory.eINSTANCE.createSplitter();
               inspectChildren = true;
            } else if ("when".equals(endpointElement.getLocalName())) {
               inspectChildren = true;
            } else if ("otherwise".equals(endpointElement.getLocalName())) {
               inspectChildren = true;
            } else if ("resequence".equals(endpointElement.getLocalName())) {
               endpoint = EipFactory.eINSTANCE.createResequencer();
               inspectChildren = true;
            } else if ("stream-config".equals(endpointElement.getLocalName())) {
               // Parent should be a Resequencer.
               Endpoint lastEndpoint = endpoints.get(endpoints.size() - 1);
               if (lastEndpoint instanceof Resequencer) {
                  ((Resequencer) lastEndpoint).setStreamSequences(true);
               }
            } else if ("to".equals(endpointElement.getLocalName())) {
               // We may have a lot of stuffs here ! Check uri in order to guess...
               String uri = endpointElement.getAttribute("uri");
               if (uri.startsWith("xslt:")) {
                  endpoint = EipFactory.eINSTANCE.createTransformer();
               } else if (uri.startsWith("switchyard:")) {
                  endpoint = EipFactory.eINSTANCE.createServiceActivator();
               }
            } else {
               System.err.println("Got an unsupported: " + endpointElement.getLocalName());
            }
            
            // Complete Endpoint with common attributes if any and store it.
            if (endpoint != null) {
               String id = endpointElement.getAttribute("id");
               String endpointName = id;
               String outgoingChannelName = null;
               
               // Id may have "<endpoint_name>|<outgoing_channel_name>" format.
               if (id != null && id.contains("|")) {
                  endpointName = id.substring(0, id.indexOf('|'));
                  outgoingChannelName = id.substring(id.indexOf('|') + 1);
               }
               endpoint.setName(endpointName);
               endpoints.add(endpoint);
               
               // Associate with incoming channel if any.
               if (incomingChannel != null) {
                  incomingChannel.setToEndpoint(endpoint);
               }
               
               // We have created an endpoint so we need an outgoingChannel that
               // will become incoming one for next endpoint to create !
               incomingChannel = EipFactory.eINSTANCE.createChannel();
               if (outgoingChannelName != null) {
                  incomingChannel.setName(outgoingChannelName);
               }
               incomingChannel.setFromEndpoint(endpoint);
               channels.add(incomingChannel);
            }
            
            // If node may contain endpoint nodes, go deeper...
            if (inspectChildren) {
               Node firstChild = endpointNode.getFirstChild();
               
               // In the CompositeProcessor case, we need to switch context for storing 
               // children endpoints directly into endpoint owned ones.
               if (endpoint instanceof CompositeProcessor) {
                  parseAndFillEndpoint(firstChild, incomingChannel, ((CompositeProcessor)endpoint).getOwnedEndpoints(), channels);
               } else {
                  parseAndFillEndpoint(firstChild, incomingChannel, endpoints, channels);
               }
            }
         }
         // Pass to the next node if any...
         if (endpointNode.getNextSibling() != null) {
            parseAndFillEndpoint(endpointNode.getNextSibling(), incomingChannel, endpoints, channels);
         }
      }
   }
   
   /** Parse the Apache Camel route file and return DOM Document. */
   private Document parseRouteFile() throws Exception {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setNamespaceAware(true);
      DocumentBuilder builder = factory.newDocumentBuilder();
      return builder.parse(routeFile);
   }
}
