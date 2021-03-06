/**
 * Generated with Acceleo
 */
package com.github.lbroudoux.dsl.eip.parts.forms;

// Start of user code for imports
import com.github.lbroudoux.dsl.eip.parts.EipViewsRepository;
import com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart;

import com.github.lbroudoux.dsl.eip.providers.EipMessages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EcoreAdapterFactory;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;

import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EMFComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;

import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;

import org.eclipse.emf.eef.runtime.ui.widgets.TabElementTreeSelectionDialog;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

// End of user code

/**
 * @author yanngv29
 * 
 */
public class ResequencerPropertiesEditionPartForm extends SectionPropertiesEditingPart implements IFormPropertiesEditionPart, ResequencerPropertiesEditionPart {

	protected Text name;
	protected EObjectFlatComboViewer toChannel;
	protected ReferencesTable fromChannels;
	protected List<ViewerFilter> fromChannelsBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> fromChannelsFilters = new ArrayList<ViewerFilter>();
	protected EMFComboViewer part;
	protected Text strategy;
	protected Text expression;
	protected Button streamSequences;



	/**
	 * For {@link ISection} use only.
	 */
	public ResequencerPropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ResequencerPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence resequencerStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = resequencerStep.addStep(EipViewsRepository.Resequencer.Properties.class);
		propertiesStep.addStep(EipViewsRepository.Resequencer.Properties.name);
		propertiesStep.addStep(EipViewsRepository.Resequencer.Properties.toChannel);
		propertiesStep.addStep(EipViewsRepository.Resequencer.Properties.fromChannels);
		propertiesStep.addStep(EipViewsRepository.Resequencer.Properties.part);
		propertiesStep.addStep(EipViewsRepository.Resequencer.Properties.strategy);
		propertiesStep.addStep(EipViewsRepository.Resequencer.Properties.expression);
		propertiesStep.addStep(EipViewsRepository.Resequencer.Properties.streamSequences);
		
		
		composer = new PartComposer(resequencerStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == EipViewsRepository.Resequencer.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == EipViewsRepository.Resequencer.Properties.name) {
					return createNameText(widgetFactory, parent);
				}
				if (key == EipViewsRepository.Resequencer.Properties.toChannel) {
					return createToChannelFlatComboViewer(parent, widgetFactory);
				}
				if (key == EipViewsRepository.Resequencer.Properties.fromChannels) {
					return createFromChannelsReferencesTable(widgetFactory, parent);
				}
				if (key == EipViewsRepository.Resequencer.Properties.part) {
					return createPartEMFComboViewer(widgetFactory, parent);
				}
				if (key == EipViewsRepository.Resequencer.Properties.strategy) {
					return createStrategyText(widgetFactory, parent);
				}
				if (key == EipViewsRepository.Resequencer.Properties.expression) {
					return createExpressionText(widgetFactory, parent);
				}
				if (key == EipViewsRepository.Resequencer.Properties.streamSequences) {
					return createStreamSequencesCheckbox(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(EipMessages.ResequencerPropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createNameText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EipViewsRepository.Resequencer.Properties.name, EipMessages.ResequencerPropertiesEditionPart_NameLabel);
		name = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		name.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData nameData = new GridData(GridData.FILL_HORIZONTAL);
		name.setLayoutData(nameData);
		name.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ResequencerPropertiesEditionPartForm.this,
							EipViewsRepository.Resequencer.Properties.name,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ResequencerPropertiesEditionPartForm.this,
									EipViewsRepository.Resequencer.Properties.name,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, name.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ResequencerPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		name.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.name, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, name.getText()));
				}
			}
		});
		EditingUtils.setID(name, EipViewsRepository.Resequencer.Properties.name);
		EditingUtils.setEEFtype(name, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EipViewsRepository.Resequencer.Properties.name, EipViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createNameText

		// End of user code
		return parent;
	}

	/**
	 * @param parent the parent composite
	 * @param widgetFactory factory to use to instanciante widget of the form
	 * 
	 */
	protected Composite createToChannelFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
		createDescription(parent, EipViewsRepository.Resequencer.Properties.toChannel, EipMessages.ResequencerPropertiesEditionPart_ToChannelLabel);
		toChannel = new EObjectFlatComboViewer(parent, !propertiesEditionComponent.isRequired(EipViewsRepository.Resequencer.Properties.toChannel, EipViewsRepository.FORM_KIND));
		widgetFactory.adapt(toChannel);
		toChannel.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		GridData toChannelData = new GridData(GridData.FILL_HORIZONTAL);
		toChannel.setLayoutData(toChannelData);
		toChannel.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.toChannel, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getToChannel()));
			}

		});
		toChannel.setID(EipViewsRepository.Resequencer.Properties.toChannel);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EipViewsRepository.Resequencer.Properties.toChannel, EipViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createToChannelFlatComboViewer

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected Composite createFromChannelsReferencesTable(FormToolkit widgetFactory, Composite parent) {
		this.fromChannels = new ReferencesTable(getDescription(EipViewsRepository.Resequencer.Properties.fromChannels, EipMessages.ResequencerPropertiesEditionPart_FromChannelsLabel), new ReferencesTableListener	() {
			public void handleAdd() { addFromChannels(); }
			public void handleEdit(EObject element) { editFromChannels(element); }
			public void handleMove(EObject element, int oldIndex, int newIndex) { moveFromChannels(element, oldIndex, newIndex); }
			public void handleRemove(EObject element) { removeFromFromChannels(element); }
			public void navigateTo(EObject element) { }
		});
		this.fromChannels.setHelpText(propertiesEditionComponent.getHelpContent(EipViewsRepository.Resequencer.Properties.fromChannels, EipViewsRepository.FORM_KIND));
		this.fromChannels.createControls(parent, widgetFactory);
		this.fromChannels.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.fromChannels, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData fromChannelsData = new GridData(GridData.FILL_HORIZONTAL);
		fromChannelsData.horizontalSpan = 3;
		this.fromChannels.setLayoutData(fromChannelsData);
		this.fromChannels.disableMove();
		fromChannels.setID(EipViewsRepository.Resequencer.Properties.fromChannels);
		fromChannels.setEEFType("eef::AdvancedReferencesTable"); //$NON-NLS-1$
		// Start of user code for createFromChannelsReferencesTable

		// End of user code
		return parent;
	}

	/**
	 * 
	 */
	protected void addFromChannels() {
		TabElementTreeSelectionDialog dialog = new TabElementTreeSelectionDialog(fromChannels.getInput(), fromChannelsFilters, fromChannelsBusinessFilters,
		"fromChannels", propertiesEditionComponent.getEditingContext().getAdapterFactory(), current.eResource()) {
			@Override
			public void process(IStructuredSelection selection) {
				for (Iterator<?> iter = selection.iterator(); iter.hasNext();) {
					EObject elem = (EObject) iter.next();
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.fromChannels,
						PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, elem));
				}
				fromChannels.refresh();
			}
		};
		dialog.open();
	}

	/**
	 * 
	 */
	protected void moveFromChannels(EObject element, int oldIndex, int newIndex) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.fromChannels, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
		fromChannels.refresh();
	}

	/**
	 * 
	 */
	protected void removeFromFromChannels(EObject element) {
		propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.fromChannels, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
		fromChannels.refresh();
	}

	/**
	 * 
	 */
	protected void editFromChannels(EObject element) {
		EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(propertiesEditionComponent.getEditingContext(), propertiesEditionComponent, element, adapterFactory);
		PropertiesEditingProvider provider = (PropertiesEditingProvider)adapterFactory.adapt(element, PropertiesEditingProvider.class);
		if (provider != null) {
			PropertiesEditingPolicy policy = provider.getPolicy(context);
			if (policy != null) {
				policy.execute();
				fromChannels.refresh();
			}
		}
	}

	
	protected Composite createPartEMFComboViewer(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EipViewsRepository.Resequencer.Properties.part, EipMessages.ResequencerPropertiesEditionPart_PartLabel);
		part = new EMFComboViewer(parent);
		part.setContentProvider(new ArrayContentProvider());
		part.setLabelProvider(new AdapterFactoryLabelProvider(EEFRuntimePlugin.getDefault().getAdapterFactory()));
		GridData partData = new GridData(GridData.FILL_HORIZONTAL);
		part.getCombo().setLayoutData(partData);
		part.addSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 * 
			 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
			 * 	
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.part, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getPart()));
			}

		});
		part.setID(EipViewsRepository.Resequencer.Properties.part);
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EipViewsRepository.Resequencer.Properties.part, EipViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createPartEMFComboViewer

		// End of user code
		return parent;
	}

	
	protected Composite createStrategyText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EipViewsRepository.Resequencer.Properties.strategy, EipMessages.ResequencerPropertiesEditionPart_StrategyLabel);
		strategy = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		strategy.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData strategyData = new GridData(GridData.FILL_HORIZONTAL);
		strategy.setLayoutData(strategyData);
		strategy.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ResequencerPropertiesEditionPartForm.this,
							EipViewsRepository.Resequencer.Properties.strategy,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, strategy.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ResequencerPropertiesEditionPartForm.this,
									EipViewsRepository.Resequencer.Properties.strategy,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, strategy.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ResequencerPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		strategy.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.strategy, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, strategy.getText()));
				}
			}
		});
		EditingUtils.setID(strategy, EipViewsRepository.Resequencer.Properties.strategy);
		EditingUtils.setEEFtype(strategy, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EipViewsRepository.Resequencer.Properties.strategy, EipViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStrategyText

		// End of user code
		return parent;
	}

	
	protected Composite createExpressionText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, EipViewsRepository.Resequencer.Properties.expression, EipMessages.ResequencerPropertiesEditionPart_ExpressionLabel);
		expression = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		expression.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData expressionData = new GridData(GridData.FILL_HORIZONTAL);
		expression.setLayoutData(expressionData);
		expression.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ResequencerPropertiesEditionPartForm.this,
							EipViewsRepository.Resequencer.Properties.expression,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, expression.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ResequencerPropertiesEditionPartForm.this,
									EipViewsRepository.Resequencer.Properties.expression,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, expression.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ResequencerPropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		expression.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.expression, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, expression.getText()));
				}
			}
		});
		EditingUtils.setID(expression, EipViewsRepository.Resequencer.Properties.expression);
		EditingUtils.setEEFtype(expression, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EipViewsRepository.Resequencer.Properties.expression, EipViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createExpressionText

		// End of user code
		return parent;
	}

	
	protected Composite createStreamSequencesCheckbox(FormToolkit widgetFactory, Composite parent) {
		streamSequences = widgetFactory.createButton(parent, getDescription(EipViewsRepository.Resequencer.Properties.streamSequences, EipMessages.ResequencerPropertiesEditionPart_StreamSequencesLabel), SWT.CHECK);
		streamSequences.addSelectionListener(new SelectionAdapter() {

			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 * 	
			 */
			public void widgetSelected(SelectionEvent e) {
				if (propertiesEditionComponent != null)
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ResequencerPropertiesEditionPartForm.this, EipViewsRepository.Resequencer.Properties.streamSequences, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, new Boolean(streamSequences.getSelection())));
			}

		});
		GridData streamSequencesData = new GridData(GridData.FILL_HORIZONTAL);
		streamSequencesData.horizontalSpan = 2;
		streamSequences.setLayoutData(streamSequencesData);
		EditingUtils.setID(streamSequences, EipViewsRepository.Resequencer.Properties.streamSequences);
		EditingUtils.setEEFtype(streamSequences, "eef::Checkbox"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(EipViewsRepository.Resequencer.Properties.streamSequences, EipViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createStreamSequencesCheckbox

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#getName()
	 * 
	 */
	public String getName() {
		return name.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#setName(String newValue)
	 * 
	 */
	public void setName(String newValue) {
		if (newValue != null) {
			name.setText(newValue);
		} else {
			name.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.name);
		if (eefElementEditorReadOnlyState && name.isEnabled()) {
			name.setEnabled(false);
			name.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !name.isEnabled()) {
			name.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#getToChannel()
	 * 
	 */
	public EObject getToChannel() {
		if (toChannel.getSelection() instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) toChannel.getSelection()).getFirstElement();
			if (firstElement instanceof EObject)
				return (EObject) firstElement;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#initToChannel(EObjectFlatComboSettings)
	 */
	public void initToChannel(EObjectFlatComboSettings settings) {
		toChannel.setInput(settings);
		if (current != null) {
			toChannel.setSelection(new StructuredSelection(settings.getValue()));
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.toChannel);
		if (eefElementEditorReadOnlyState && toChannel.isEnabled()) {
			toChannel.setEnabled(false);
			toChannel.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !toChannel.isEnabled()) {
			toChannel.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#setToChannel(EObject newValue)
	 * 
	 */
	public void setToChannel(EObject newValue) {
		if (newValue != null) {
			toChannel.setSelection(new StructuredSelection(newValue));
		} else {
			toChannel.setSelection(new StructuredSelection()); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.toChannel);
		if (eefElementEditorReadOnlyState && toChannel.isEnabled()) {
			toChannel.setEnabled(false);
			toChannel.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !toChannel.isEnabled()) {
			toChannel.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#setToChannelButtonMode(ButtonsModeEnum newValue)
	 */
	public void setToChannelButtonMode(ButtonsModeEnum newValue) {
		toChannel.setButtonMode(newValue);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#addFilterToChannel(ViewerFilter filter)
	 * 
	 */
	public void addFilterToToChannel(ViewerFilter filter) {
		toChannel.addFilter(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#addBusinessFilterToChannel(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToToChannel(ViewerFilter filter) {
		toChannel.addBusinessRuleFilter(filter);
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#initFromChannels(org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings)
	 */
	public void initFromChannels(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		fromChannels.setContentProvider(contentProvider);
		fromChannels.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.fromChannels);
		if (eefElementEditorReadOnlyState && fromChannels.getTable().isEnabled()) {
			fromChannels.setEnabled(false);
			fromChannels.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !fromChannels.getTable().isEnabled()) {
			fromChannels.setEnabled(true);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#updateFromChannels()
	 * 
	 */
	public void updateFromChannels() {
	fromChannels.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#addFilterFromChannels(ViewerFilter filter)
	 * 
	 */
	public void addFilterToFromChannels(ViewerFilter filter) {
		fromChannelsFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#addBusinessFilterFromChannels(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToFromChannels(ViewerFilter filter) {
		fromChannelsBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#isContainedInFromChannelsTable(EObject element)
	 * 
	 */
	public boolean isContainedInFromChannelsTable(EObject element) {
		return ((ReferencesTableSettings)fromChannels.getInput()).contains(element);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#getPart()
	 * 
	 */
	public Enumerator getPart() {
		Enumerator selection = (Enumerator) ((StructuredSelection) part.getSelection()).getFirstElement();
		return selection;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#initPart(Object input, Enumerator current)
	 */
	public void initPart(Object input, Enumerator current) {
		part.setInput(input);
		part.modelUpdating(new StructuredSelection(current));
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.part);
		if (eefElementEditorReadOnlyState && part.isEnabled()) {
			part.setEnabled(false);
			part.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !part.isEnabled()) {
			part.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#setPart(Enumerator newValue)
	 * 
	 */
	public void setPart(Enumerator newValue) {
		part.modelUpdating(new StructuredSelection(newValue));
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.part);
		if (eefElementEditorReadOnlyState && part.isEnabled()) {
			part.setEnabled(false);
			part.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !part.isEnabled()) {
			part.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#getStrategy()
	 * 
	 */
	public String getStrategy() {
		return strategy.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#setStrategy(String newValue)
	 * 
	 */
	public void setStrategy(String newValue) {
		if (newValue != null) {
			strategy.setText(newValue);
		} else {
			strategy.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.strategy);
		if (eefElementEditorReadOnlyState && strategy.isEnabled()) {
			strategy.setEnabled(false);
			strategy.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !strategy.isEnabled()) {
			strategy.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#getExpression()
	 * 
	 */
	public String getExpression() {
		return expression.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#setExpression(String newValue)
	 * 
	 */
	public void setExpression(String newValue) {
		if (newValue != null) {
			expression.setText(newValue);
		} else {
			expression.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.expression);
		if (eefElementEditorReadOnlyState && expression.isEnabled()) {
			expression.setEnabled(false);
			expression.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !expression.isEnabled()) {
			expression.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#getStreamSequences()
	 * 
	 */
	public Boolean getStreamSequences() {
		return Boolean.valueOf(streamSequences.getSelection());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see com.github.lbroudoux.dsl.eip.parts.ResequencerPropertiesEditionPart#setStreamSequences(Boolean newValue)
	 * 
	 */
	public void setStreamSequences(Boolean newValue) {
		if (newValue != null) {
			streamSequences.setSelection(newValue.booleanValue());
		} else {
			streamSequences.setSelection(false);
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(EipViewsRepository.Resequencer.Properties.streamSequences);
		if (eefElementEditorReadOnlyState && streamSequences.isEnabled()) {
			streamSequences.setEnabled(false);
			streamSequences.setToolTipText(EipMessages.Resequencer_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !streamSequences.isEnabled()) {
			streamSequences.setEnabled(true);
		}	
		
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return EipMessages.Resequencer_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
