package org.pnml.tools.epnk.tutorials.app.simulator.application;

import java.util.ArrayList;
import java.util.Collection;

import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.applications.ui.ApplicationUIManager;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.Page;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.RefPlace;
import org.pnml.tools.epnk.pnmlcoremodel.RefTransition;

import org.pnml.tools.epnk.tutorials.app.technical.Arc;
import org.pnml.tools.epnk.tutorials.app.technical.Place;
import org.pnml.tools.epnk.tutorials.app.technical.Transition;
import org.pnml.tools.epnk.tutorials.app.technical.helpers.ArcType;
import org.pnml.tools.epnk.tutorials.app.technical.helpers.TechnicalNetTypeFunctions;

import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.Marking;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsFactory;

import org.pnml.tools.epnk.tutorials.app.simulator.marking.NetMarking;

/**
 * The simulator application for Petri nets of type technical net.
 * 
 * @author ekki@dtu.dk
 *
 */
public class TechnicalSimulator extends ApplicationWithUIManager {
	
	FlatAccess flatAccess;
	private NetChangeListener adapter;
	
	public TechnicalSimulator(PetriNet petrinet) {
		super(petrinet);
		getNetAnnotations().setName("A simple technical simulator");
		ApplicationUIManager manager = this.getPresentationManager();
		manager.addActionHandler(new EnabledTransitionHandler(this));
		manager.addActionHandler(new InvolvedArcHandler(this));
		manager.addPresentationHandler(new TechnicalAnnotationsPresentationHandler());
		
		adapter = new NetChangeListener(this);
	}

	public FlatAccess getFlatAccess() {
		if (flatAccess == null) {
			flatAccess = FlatAccess.getFlatAccess(this.getPetrinet());
			if (adapter != null) {
				flatAccess.addInvalidationListener(adapter);
			}
		}
		return flatAccess;
	}

	@Override
	protected void initializeContents() {
		NetMarking initialMarking = computeInitialMarking();
		NetAnnotation initialAnnotation = computeAnnotation(initialMarking);
		
		this.getNetAnnotations().getNetAnnotations().add(initialAnnotation);
		this.getNetAnnotations().setCurrent(initialAnnotation);
	}

	private NetMarking computeInitialMarking() {
		NetMarking marking = new NetMarking();;
		for (org.pnml.tools.epnk.pnmlcoremodel.Place place: this.getFlatAccess().getPlaces()) {
			if (place instanceof Place) {
				int number = TechnicalNetTypeFunctions.getMarking(place);
				if (number > 0) {
					marking.setMarking((Place) place, number);
				}
			}
		}
		return marking;
	}
	
	private NetMarking computeMarking() {
		NetMarking marking = new NetMarking();
		for (ObjectAnnotation annotation: this.getNetAnnotations().getCurrent().getObjectAnnotations()) {
			if (annotation instanceof Marking) {
				Marking markingAnnotation = (Marking) annotation;
				Object object = markingAnnotation.getObject();
				int value = markingAnnotation.getValue();
				if (object instanceof Place &&  value > 0) {
					Place place = (Place) object;
					marking.setMarking(place, value);
				}
			}
		}
		return marking;
	}
	
	private NetAnnotation computeAnnotation(NetMarking marking) {
		FlatAccess flatAccess = this.getFlatAccess();
		
		NetAnnotation annotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		annotation.setNet(getPetrinet());
		
		for (Object object: flatAccess.getTransitions()) {
			if (object instanceof Transition) {
				Transition transition = (Transition) object;
				if (isWeaklyEnabled(marking, transition)) {
					EnabledTransition enabledTransition = TechsimannotationsFactory.eINSTANCE.createEnabledTransition();
					enabledTransition.setObject(transition);
					annotation.getObjectAnnotations().add(enabledTransition);
					Collection<Arc> preventingArcs = this.preventingArcs(marking, transition);
					if (preventingArcs.isEmpty()) {
						enabledTransition.setEnabled(true);
					} else {
						enabledTransition.setEnabled(false);
						for (Arc arc : preventingArcs) {
							InvolvedArc involvedArc = TechsimannotationsFactory.eINSTANCE.createInvolvedArc();
							involvedArc.setObject(arc);
							involvedArc.setTarget(enabledTransition);
							involvedArc.setActive(true);
							annotation.getObjectAnnotations().add(involvedArc);
						}
					}
					for (RefTransition refTransition: flatAccess.getRefTransitions(transition)) {
						EnabledTransition enabledTransition2 = TechsimannotationsFactory.eINSTANCE.createEnabledTransition();
						enabledTransition2.setObject(refTransition);
						enabledTransition2.setResolve(enabledTransition);
						enabledTransition2.setEnabled(enabledTransition.isEnabled());
						annotation.getObjectAnnotations().add(enabledTransition2);
					}
				}
			}
		}
		
		for (Place place: marking.getSupport()) {
			int m = marking.getMarking(place);
			if (m > 0) {
				Marking mAnnotation = TechsimannotationsFactory.eINSTANCE.createMarking();
				mAnnotation.setObject(place);
				mAnnotation.setValue(m);
				annotation.getObjectAnnotations().add(mAnnotation);
				for (RefPlace refPlace: flatAccess.getRefPlaces(place)) {
					Marking mAnnotation2 = TechsimannotationsFactory.eINSTANCE.createMarking();
					mAnnotation2.setObject(refPlace);
					mAnnotation2.setValue(m);
					annotation.getObjectAnnotations().add(mAnnotation2);
				}
			}
		}
		return annotation;
	}
	
	boolean fireTransition(Transition transition, Collection<Arc> inactiveInArcs, Collection<Arc> inactiveOutArcs) {
		NetMarking marking1 = this.computeMarking();
		Collection<Arc> preventors = this.preventingArcs(marking1, transition);
		// remove all inactive preventors (in order to allow checking whether their are
		// active preventors left (which still prevent the firing of the transition)
		// This check is actually redundant; it is just used how to pass information
		// on selected arcs from the action handler to the fireTransition method
		preventors.removeAll(inactiveInArcs);
		preventors.removeAll(inactiveOutArcs);
		if (this.isWeaklyEnabled(marking1, transition) && preventors.isEmpty()) {
			NetMarking marking2 = this.fireTransition(marking1, transition);
			NetAnnotation netAnnotation = this.computeAnnotation(marking2);
			netAnnotation.setNet(this.getPetrinet());

			this.deleteNetAnnotationAfterCurrent();
			this.addNetAnnotationAsCurrent(netAnnotation);
			return true;
		}
		return false;
	}

	private NetMarking fireTransition(NetMarking marking1, Transition transition ) {
		FlatAccess flatAccess= this.getFlatAccess();
		
		NetMarking marking2 = new NetMarking(marking1);
		
		// consume tokens from preset
		NetMarking consumes = consumes(transition);
		marking2.subtract(consumes);
				
		// reset places on page connected to reset arc
		for (Object a: flatAccess.getIn(transition)) {
			if (a instanceof Arc && TechnicalNetTypeFunctions.getArcType((Arc) a) == ArcType.RESET) {
				Arc arc = (Arc) a;
				Node source = arc.getSource();
				if (source instanceof Page) {
					Page page = (Page) source;
					for (Object object: page.getObject()) {
						if (object instanceof PlaceNode) {
							Object resolved = flatAccess.resolve((PlaceNode) object);
							if (resolved instanceof Place) {
								marking2.setMarking((Place) resolved, 0);
							}
						}
					}
				}
			}
		}
		
		// produce tokens on postset
		NetMarking produces = produces(transition);
		marking2.add(produces);
		
		return marking2;
	}

	private boolean isWeaklyEnabled(NetMarking marking, Transition transition) {
		NetMarking consumes = consumes(transition);
		return marking.isGreaterOrEqual(consumes);
	}
	
	private Collection<Arc> preventingArcs(NetMarking marking, Transition transition) {
		FlatAccess flatAccess= this.getFlatAccess();
		
		Collection<Arc> preventors = new ArrayList<Arc>();
		for (org.pnml.tools.epnk.pnmlcoremodel.Arc arc: flatAccess.getIn(transition)) {
			ArcType arcType = TechnicalNetTypeFunctions.getArcType(arc);
			if (arc instanceof Arc &&
					( arcType == ArcType.INHIBITOR || arcType == ArcType.READ)) {
				Node source = arc.getSource();
				if (source instanceof PlaceNode) {
					source = flatAccess.resolve((PlaceNode) source);
					if (source instanceof Place) {
						if (arcType == ArcType.INHIBITOR && 
								marking.getMarking((Place) source) > 0) {
							preventors.add((Arc) arc);
						} else if (arcType == ArcType.READ &&
								marking.getMarking((Place) source) == 0) {
							preventors.add((Arc) arc);
						}
					}
				}
			}
		}
		return preventors;
	}
	
	private NetMarking consumes(Transition transition) {
		FlatAccess flatAccess = this.getFlatAccess();
		
		NetMarking consumes = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Arc arc: flatAccess.getIn(transition)) {
			if (arc instanceof Arc && TechnicalNetTypeFunctions.getArcType(arc) == ArcType.NORMAL ) {
				Node source = arc.getSource();
				if (source instanceof PlaceNode) {
					source = flatAccess.resolve((PlaceNode) source);
					if (source instanceof Place) {
						consumes.incrementMarkingBy((Place) source, 1);
					}
				}
			}
		}
		return consumes;
	}
	
	private NetMarking produces(Transition transition) {
		FlatAccess flatAccess = this.getFlatAccess();
		
		NetMarking produces = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Arc arc: flatAccess.getOut(transition)) {
			if (arc instanceof Arc && TechnicalNetTypeFunctions.getArcType(arc) == ArcType.NORMAL ) {
				Node target = arc.getTarget();
				if (target instanceof PlaceNode) {
					target = flatAccess.resolve((PlaceNode) target);
					if (target instanceof Place) {
						produces.incrementMarkingBy((Place) target, 1);
					}
				}
			}
		}
		return produces;
	}

	/* (non-Javadoc)
	 * @see org.pnml.tools.epnk.applications.Application#isSavable()
	 */
	@Override
	public boolean isSavable() {
		// allow saving of the state of the application
		return true;
	}


	/* (non-Javadoc)
	 * @see org.pnml.tools.epnk.applications.Application#shutDown()
	 */
	@Override
	protected void shutDown() {
		super.shutDown();
		
		if (flatAccess != null && adapter != null) {
			flatAccess.removeInvalidationListener(adapter);
			flatAccess = null;
		}
	}

}