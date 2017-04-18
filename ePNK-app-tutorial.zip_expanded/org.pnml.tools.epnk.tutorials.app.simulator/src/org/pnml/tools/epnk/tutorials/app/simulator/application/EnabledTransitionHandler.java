package org.pnml.tools.epnk.tutorials.app.simulator.application;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotations;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;
import org.pnml.tools.epnk.helpers.NetFunctions;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc;
import org.pnml.tools.epnk.tutorials.app.technical.Arc;
import org.pnml.tools.epnk.tutorials.app.technical.Transition;

/**
 * Action handler dealing with mouse clicks on EnableTransition annotations.
 * It will fire the transition, if it is enabled.
 * 
 * @author ekki@dtu.dk
 *
 */
public class EnabledTransitionHandler implements IActionHandler {

	private TechnicalSimulator application;

	public EnabledTransitionHandler(TechnicalSimulator application) {
		super();
		this.application = application;	
	}

	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		// FlatAccess flatAccess = application.getFlatAccess();
		
		NetAnnotations netAnnotations = application.getNetAnnotations();
		NetAnnotation current = netAnnotations.getCurrent();
		if (current.getObjectAnnotations().contains(annotation)) {
			Object object = annotation.getObject();
			if (object instanceof TransitionNode) {
				// object = flatAccess.resolve((TransitionNode) object);
				object = NetFunctions.resolve((TransitionNode) object);
			}
			if (object instanceof Transition && annotation instanceof EnabledTransition) {
				Transition transition = (Transition) object;
				EnabledTransition enabledTransition = (EnabledTransition) annotation;
				
				if (enabledTransition.isEnabled()) {
					// compute the in-arcs marked as inactive by the user
					Collection<Arc> inactiveInArcs = new HashSet<Arc>();
					for (InvolvedArc a: enabledTransition.getIn()) {
						Object o = a.getObject();
						if (o instanceof Arc && !a.isActive()) {
							inactiveInArcs.add((Arc) o);
						}
					}

					// compute the out-arcs marked as inactive by the user
					Collection<Arc> inactiveOutArcs = new HashSet<Arc>();
					for (InvolvedArc a: enabledTransition.getOut()) {
						Object o = a.getObject();
						if (o instanceof Arc && !a.isActive()) {
							inactiveOutArcs.add((Arc) o);
						}
					}
					
					// fire the transition. Note that the inactive in and out arcs are not
					// really necessary here; they are used to demonstrate how some additional
					// information could be passed to the fire method if needed.
					return application.fireTransition(transition, inactiveInArcs, inactiveOutArcs);
				}
			}
		}
		return false;
	}

	@Override
	public boolean mousePressed(MouseEvent arg0, ObjectAnnotation annotation) {
		return false; 
	}

	@Override
	public boolean mouseReleased(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}

}
