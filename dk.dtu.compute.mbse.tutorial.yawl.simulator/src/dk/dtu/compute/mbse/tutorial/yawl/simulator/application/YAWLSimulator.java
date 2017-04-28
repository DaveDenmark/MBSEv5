package dk.dtu.compute.mbse.tutorial.yawl.simulator.application;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetannotationsFactory;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.applications.ui.ApplicationUIManager;
import org.pnml.tools.epnk.helpers.FlatAccess;
import dk.dtu.compute.mbse.yawl.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.RefPlace;
import org.pnml.tools.epnk.pnmlcoremodel.RefTransition;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.compute.mbse.tutorial.yawl.simulator.marking.NetMarking;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.EnabledTransition;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.Marking;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.SelectArc;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.YawlannotationsFactory;
import dk.dtu.compute.mbse.yawl.AType;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.PType;
import dk.dtu.compute.mbse.yawl.Place;
import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.helpfunctions.YAWLFunctions;

/**
 * Group 6 simulator application for YAWL nets. 
 * 
 * @author David Josef Kristensen - s143312 
 * @author Henrik Iller W�rsted - s154280
 * @author Lars Vandsted Myrup Jensen - s153201 
 * @author Rasmus Hannibal Barlach Moulvad - s153256
 * @author Rasmus Vulpius Gregersen - S144219
 */
public class YAWLSimulator extends ApplicationWithUIManager {
	
	private FlatAccess flatAccess;
	private NetChangeListener adapter;
	
	public YAWLSimulator(PetriNet petrinet) {
		super(petrinet);
		flatAccess = FlatAccess.getFlatAccess(this.getPetrinet());
		
		getNetAnnotations().setName("A simple YAWL simulator by group 6");
		ApplicationUIManager manager = this.getPresentationManager();
		manager.addActionHandler(new EnabledTransitionHandler(this));
		manager.addPresentationHandler(new YAWLAnnotationsPresentationHandler());
		manager.addActionHandler(new SelectArcHandler(this));
		// TODO: Action handler for Arcs
		
		adapter = new NetChangeListener(this);
		flatAccess.addInvalidationListener(adapter);
	}

	public FlatAccess getFlatAccess() {
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
		NetMarking marking = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Place place: getFlatAccess().getPlaces()) {
			if (place instanceof Place && YAWLFunctions.getType(place) == PType.START) {
				marking.setMarking((Place) place, 1);
			}
		}

		return marking;
	}
	
	NetMarking computeMarking() {
		NetMarking marking = new NetMarking();
		for (ObjectAnnotation annotation: this.getNetAnnotations().getCurrent().getObjectAnnotations()) {
			if (annotation instanceof Marking) {
				Marking markingAnnotation = (Marking) annotation;
				Object object = markingAnnotation.getObject();
				int value = markingAnnotation.getValue();
				if(object instanceof Place && value > 0) {
					Place place = (Place) object;
					marking.setMarking(place, value);
				}
			}
		}
		return marking;
	}
	
	
	
	
	boolean enabled(FlatAccess flatNet, NetMarking marking, Transition transition) {
		TType joinType = YAWLFunctions.getJoinType(transition);
		
		if (joinType.equals(TType.AND) || joinType.equals(TType.SINGLE)) {
			for (Object in : flatAccess.getIn(transition)) {
				if (in instanceof Arc) {
					Arc arc = (Arc) in;
					if (!YAWLFunctions.isResetArc(arc)) {
						Object source = arc.getSource();
						if (source instanceof PlaceNode) {
							source = flatAccess.resolve((PlaceNode) source);
							if (source instanceof Place) {
								if (marking.getMarking((Place) source) < 1) {
									return false;
								}
							} else {
								return false;
							}
						} else {
							return false;
						}
					}
				}
			}
			return true;
		
		} else if (joinType.equals(TType.OR) || joinType.equals(TType.XOR)) {
			for (Object in : flatAccess.getIn(transition)) {
				if (in instanceof Arc) {
					Arc arc = (Arc) in;
					if (!YAWLFunctions.isResetArc(arc)) {
						Object source = arc.getSource();
						if (source instanceof PlaceNode) {
							source = flatAccess.resolve((PlaceNode) source);
							if (source instanceof Place) {
								if (marking.getMarking((Place) source) > 0) {
									return true;
								}
							}
						}
					}
				}
			}
			return false;
		}
		return false;
	}
	
	NetAnnotation computeAnnotation(NetMarking marking) {
		FlatAccess flatAccess = getFlatAccess();
		NetAnnotation annotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
		annotation.setNet(getPetrinet());
		Map<Object, Marking> place2MarkingAnnotation = new HashMap<Object, Marking>();
		for (Place place : marking.getSupport()) {
			int value = marking.getMarking(place);
			if (value > 0) {
				Marking markingAnnotation = YawlannotationsFactory.eINSTANCE.createMarking();
				markingAnnotation.setValue(value);
				markingAnnotation.setObject(place);
				annotation.getObjectAnnotations().add(markingAnnotation);
				place2MarkingAnnotation.put(place, markingAnnotation);

				// TODO also annotate reference places with the current marking
				// of the place

			}
		}

		Set<Transition> enabled = new HashSet<Transition>();

		for (org.pnml.tools.epnk.pnmlcoremodel.Transition trans : flatAccess.getTransitions()) {
			if (trans instanceof Transition) {
				if (enabled(flatAccess, marking, (Transition) trans)) {
					enabled.add((Transition) trans);

					EnabledTransition transitionAnnotation = YawlannotationsFactory.eINSTANCE
							.createEnabledTransition();
					transitionAnnotation.setObject(trans);
					annotation.getObjectAnnotations().add(transitionAnnotation);

					// TODO also annotate reference places with the current
					// marking of the place

					if (YAWLFunctions.getJoinType(trans).equals(TType.XOR)) {
						boolean first = true;
						for (Object in : flatAccess.getIn(trans)) {
							if (in instanceof Arc) {
								if (!YAWLFunctions.isResetArc((Arc) in)) {
									Marking sourceMarking = place2MarkingAnnotation.get(((Arc) in).getSource());
									if (sourceMarking != null) {
										SelectArc arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArc();
										arcAnnotation.setObject(((Arc) in));
										arcAnnotation.setSourceMarking(sourceMarking);
										arcAnnotation.setTargetTransition(transitionAnnotation);
										if (first) {
											arcAnnotation.setSelected(true);
											first = false;
										} else {
											arcAnnotation.setSelected(false);
										}
										annotation.getObjectAnnotations().add(arcAnnotation);
									}
								}
							}
						}
					}

					// Makes sure outgoing arcs are selected and attached to the
					// corresponding Transition:
					if (YAWLFunctions.getSplitType(trans).equals(TType.XOR)) {
						boolean first = true;
						for (Object out : flatAccess.getOut(trans)) {
							if (out instanceof Arc) {
								SelectArc arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArc();
								arcAnnotation.setObject(((Arc) out));
								arcAnnotation.setSourceTransition(transitionAnnotation);
								if (first) {
									arcAnnotation.setSelected(true);
									first = false;
								} else {
									arcAnnotation.setSelected(false);
								}
								annotation.getObjectAnnotations().add(arcAnnotation);
							}
						}
					}

					// Same as above, but here more arcs can be selected:
					if (YAWLFunctions.getSplitType(trans).equals(TType.OR)) {
						for (Object out : flatAccess.getOut(trans)) {
							if (out instanceof Arc) {
								SelectArc arcAnnotation = YawlannotationsFactory.eINSTANCE.createSelectArc();
								arcAnnotation.setObject(((Arc) out));
								arcAnnotation.setSourceTransition(transitionAnnotation);
								arcAnnotation.setSelected(true);
								annotation.getObjectAnnotations().add(arcAnnotation);
							}
						}
					}

				}
			}
		}
		return annotation;
	}

	
//	private NetAnnotation computeAnnotation(NetMarking marking) {
//		NetAnnotation annotation = NetannotationsFactory.eINSTANCE.createNetAnnotation();
//		annotation.setNet(getPetrinet());
//		
//		for (Object object: getFlatAccess().getTransitions()) {
//			if (object instanceof Transition) {
//				Transition Transition = (Transition) object;
//				if (isEnabled(marking, Transition)) {
//					EnabledTransition enabledTransition = YawlannotationsFactory.eINSTANCE.createEnabledTransition();
//					enabledTransition.setObject(Transition);
//					annotation.getObjectAnnotations().add(enabledTransition);
//					enabledTransition.setEnabled(true);
//					
//					for (RefTransition refTransition: getFlatAccess().getRefTransitions(Transition)) {
//						EnabledTransition enabledTransition2 = YawlannotationsFactory.eINSTANCE.createEnabledTransition();
//						enabledTransition2.setObject(refTransition);
//						enabledTransition2.setResolve(enabledTransition);
//						enabledTransition2.setEnabled(enabledTransition.isEnabled());
//						annotation.getObjectAnnotations().add(enabledTransition2);
//					}
//				}
//			}
//		}
//		
//		for (Place place: marking.getSupport()) {
//			int m = marking.getMarking(place);
//			if (m > 0) {
//				 Marking mAnnotation = YawlannotationsFactory.eINSTANCE.createMarking();
//				 mAnnotation.setObject(place);
//				 mAnnotation.setValue(m);
//				 annotation.getObjectAnnotations().add(mAnnotation);
//				 
//				 for (RefPlace refPlace: getFlatAccess().getRefPlaces(place)) {
//					 Marking mAnnotation2 = YawlannotationsFactory.eINSTANCE.createMarking();
//					 mAnnotation2.setObject(refPlace);
//					 mAnnotation2.setValue(m);
//					 annotation.getObjectAnnotations().add(mAnnotation2);
//				 }
//			}
//		}
//		return annotation;
//	}
//	
//	boolean fireTransition(Transition Transition) {
//		NetMarking marking1 = this.computeMarking();
//
//		if (this.isEnabled(marking1, Transition)) {
//			NetMarking marking2 = this.fireTransition(marking1, Transition);
//			NetAnnotation netAnnotation = this.computeAnnotation(marking2);
//			netAnnotation.setNet(this.getPetrinet());
//
//			this.deleteNetAnnotationAfterCurrent();
//			this.addNetAnnotationAsCurrent(netAnnotation);
//			return true;
//		}
//		return false;
//	}

	NetMarking fireTransition(FlatAccess flatNet, NetMarking marking1, Arc selectedInArc, Transition transition,
			Collection<Arc> selectedOutArcs) {
		NetMarking marking2 = new NetMarking(marking1);

		TType joinType = YAWLFunctions.getJoinType(transition);

		if (joinType.equals(TType.AND) || joinType.equals(TType.SINGLE)) {
			for (Object in : flatNet.getIn(transition)) {
				if (in instanceof Arc) {
					Arc inArc = (Arc) in;
					if (!YAWLFunctions.isResetArc(inArc)) {
						Object source = inArc.getSource();
						if (source instanceof PlaceNode) {
							source = flatNet.resolve((PlaceNode) source);
							if (source instanceof Place) {
								marking2.decrementMarkingBy((Place) source, 1);
							}
						}
					}
				}
			}
		} else if (joinType.equals(TType.OR)) {
			for (Object in : flatNet.getIn(transition)) {
				if (in instanceof Arc) {
					Arc inArc = (Arc) in;
					if (!YAWLFunctions.isResetArc(inArc)) {
						Object source = inArc.getSource();
						if (source instanceof PlaceNode) {
							source = flatNet.resolve((PlaceNode) source);
							if (source instanceof Place) {
								if (marking2.getMarking((Place) source) > 0) {
									marking2.decrementMarkingBy((Place) source, 1);
								}
							}
						}
					}
				}
			}
		} else if (joinType.equals(TType.XOR) && selectedInArc != null
				&& !YAWLFunctions.isResetArc(selectedInArc)) {
			Node target = selectedInArc.getTarget();
			if (target instanceof TransitionNode) {
				org.pnml.tools.epnk.pnmlcoremodel.Transition trans = flatNet.resolve((TransitionNode) target);
				if (transition == trans) {
					Object source = selectedInArc.getSource();
					if (source instanceof PlaceNode) {
						source = flatNet.resolve((PlaceNode) source);
						if (source instanceof Place) {
							if (marking2.getMarking((Place) source) > 0) {
								marking2.decrementMarkingBy((Place) source, 1);
							}
						}
					}
				}
			}
		}

		// Iteration over all reset arcs, which will be set to 0
		for (Object in : flatNet.getIn(transition)) {
			if (in instanceof Arc) {
				Arc inArc = (Arc) in;
				if (YAWLFunctions.isResetArc(inArc)) {
					Object source = inArc.getSource();
					if (source instanceof PlaceNode) {
						source = flatNet.resolve((PlaceNode) source);
						if (source instanceof Place) {
							marking2.setMarking((Place) source, 0);
						}
					}
				}
			}
		}

		// Reduce token for all outgoing arcs on and (and single?):
		TType splitType = YAWLFunctions.getSplitType(transition);
		if (splitType.equals(TType.AND) || splitType.equals(TType.SINGLE)) {
			for (Object out : flatNet.getOut(transition)) {
				if (out instanceof Arc) {
					Arc outArc = (Arc) out;
					Object target = outArc.getTarget();
					if (target instanceof PlaceNode) {
						target = flatNet.resolve((PlaceNode) target);
						if (target instanceof Place) {
							marking2.incrementMarkingBy((Place) target, 1);
						}
					}
				}
			}
			// produce token on all target places:
		} else if (splitType.equals(TType.OR)
				|| splitType.equals(TType.XOR) && selectedOutArcs != null) {
			for (Arc outArc : selectedOutArcs) {
				Node source = outArc.getSource();
				if (source instanceof TransitionNode) {
					source = flatNet.resolve((TransitionNode) source);
				}
				if (transition == source) {
					Object target = outArc.getTarget();
					if (target instanceof PlaceNode) {
						target = flatNet.resolve((PlaceNode) target);
						if (target instanceof Place) {
							marking2.incrementMarkingBy((Place) target, 1);
						}
					}
				}
			}
		}
		return marking2;
	}
	
	
	private NetMarking fireTransition(NetMarking marking1, Transition Transition) {
		NetMarking marking2 = new NetMarking(marking1);
		
		// consume tokens from preset
		NetMarking consumes = consumes(Transition);
		marking2.subtract(consumes);
				
		// reset places on page connected to reset arc
        // TODO
		
		// produce tokens on postset
		NetMarking produces = produces(Transition);
		marking2.add(produces);
		
		return marking2;
	}

	private boolean isEnabled(NetMarking marking, Transition Transition) {
		NetMarking consumes = consumes(Transition);
		return marking.isGreaterOrEqual(consumes);
	}
	
	private NetMarking consumes(Transition Transition) {
		NetMarking consumes = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Arc arc: getFlatAccess().getIn(Transition)) {
			if (arc instanceof Arc && YAWLFunctions.getType(arc) == AType.NORMAL ) {
				Node source = arc.getSource();
				if (source instanceof PlaceNode) {
					source = getFlatAccess().resolve((PlaceNode) source);
					if (source instanceof Place) {
						consumes.incrementMarkingBy((Place) source, 1);
					}
				}
			}
		}
		return consumes;
	}
	
	private NetMarking produces(Transition transition) {
		NetMarking produces = new NetMarking();
		for (org.pnml.tools.epnk.pnmlcoremodel.Arc arc: getFlatAccess().getOut(transition)) {
			if (arc instanceof Arc && YAWLFunctions.getType(arc) == AType.NORMAL) {
				Node target = arc.getTarget();
				if (target instanceof PlaceNode) {
					target = getFlatAccess().resolve((PlaceNode) target);
					if (target instanceof Place) {
						produces.incrementMarkingBy((Place) target, 1);
					}
				}
			}
		}
		return produces;
	}

	/* (non-Javadoc)
	 * @see org.pnml.tools.epnk.applications.Application#shutDown()
	 */
	@Override
	protected void shutDown() {
		super.shutDown();
		
		if (flatAccess != null && adapter != null) {
			flatAccess.removeInvalidationListener(adapter);
			adapter = null;
		}
	}

}