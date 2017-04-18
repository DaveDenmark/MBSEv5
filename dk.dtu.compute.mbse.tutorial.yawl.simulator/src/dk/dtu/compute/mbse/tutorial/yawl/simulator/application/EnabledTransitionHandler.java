package dk.dtu.compute.mbse.tutorial.yawl.simulator.application;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.NetAnnotations;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;
import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.compute.mbse.tutorial.yawl.simulator.marking.NetMarking;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.EnabledTransition;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.SelectArc;
import dk.dtu.compute.mbse.yawl.Arc;
import dk.dtu.compute.mbse.yawl.Transition;

/**
 * Action handler dealing with mouse clicks on EnableTransition annotations.
 * It will fire the transition, if it is enabled.
 * 
 * @author David Josef Kristensen - s143312 
 * @author Henrik Iller Wærsted - s154280
 * @author Lars Vandsted Myrup Jensen - s153201 
 * @author Rasmus Hannibal Barlach Moulvad - s153256
 * @author Rasmus Vulpius Gregersen - S144219
 *
 */

public class EnabledTransitionHandler implements IActionHandler {

	private YAWLSimulator application;

	public EnabledTransitionHandler(YAWLSimulator application) {
		super();
		this.application = application;	
	}

	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		NetAnnotations netAnnotations = application.getNetAnnotations();
		NetAnnotation current = netAnnotations.getCurrent();
		
		FlatAccess flatNet = application.getFlatAccess();
		if (current.getObjectAnnotations().contains(annotation)) {
			Object object = annotation.getObject();
			if (object instanceof TransitionNode) {
				object = flatNet.resolve((TransitionNode) object);
			}
			if (object instanceof Transition && annotation instanceof EnabledTransition) {
				Transition transition = (Transition) object;
				NetMarking marking1 = application.computeMarking();
				if (application.enabled(flatNet, marking1, transition)) {
					NetMarking marking2 = application.fireTransition(
							flatNet, 
							marking1, 
							selectedInArc((EnabledTransition) annotation), 
							transition, 
							selectedOutArcs((EnabledTransition) annotation));
					NetAnnotation netAnnotation = application.computeAnnotation(marking2);
					netAnnotation.setNet(application.getPetrinet());
					
					application.deleteNetAnnotationAfterCurrent();
					application.addNetAnnotationAsCurrent(netAnnotation);
					return true;
				}
				
			}
		}
		return false;
	}
	private Collection<Arc> selectedOutArcs(EnabledTransition enabledTransitions) {
		EnabledTransition resolved = enabledTransitions.getResolved();
		if (resolved == null) {
			resolved = enabledTransitions;
		}
		Collection<Arc> result = new ArrayList<Arc>();
		for (SelectArc selectArc : resolved.getOutArcs()) {
			if (selectArc.isSelected()) {
				Object arc = selectArc.getObject();
				if (arc instanceof Arc) {
					result.add((Arc) arc);
				}
			}
		}
		return result;
	}

	private Arc selectedInArc(EnabledTransition enabledTransitions) {
		EnabledTransition resolved = enabledTransitions.getResolved();
		if (resolved == null) {
			resolved = enabledTransitions;
		}
		for (SelectArc selectArc : resolved.getInArcs()) {
			if (selectArc.isSelected()) {
				Object result = selectArc.getObject();
				if (result instanceof Arc) {
					return (Arc) result;
				}
			}
		}
		return null;
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
