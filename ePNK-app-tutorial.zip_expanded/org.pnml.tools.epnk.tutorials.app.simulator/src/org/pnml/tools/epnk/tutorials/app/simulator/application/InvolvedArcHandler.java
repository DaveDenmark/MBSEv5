package org.pnml.tools.epnk.tutorials.app.simulator.application;

import org.eclipse.draw2d.MouseEvent;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;

import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc;

/**
 * Action handler dealing with clicks on InvolvedArc annotations. It
 * will toggle the active status of the arc and update the enabledness
 * status of the attached transition.
 * 
 * @author ekki@dtu.dk
 *
 */
public class InvolvedArcHandler implements IActionHandler {

	private TechnicalSimulator application;
	
	public InvolvedArcHandler(TechnicalSimulator application) {
		super();		
		this.application = application;
	}

	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}

	@Override
	public boolean mousePressed(MouseEvent arg0, ObjectAnnotation annotation) {
		if (annotation instanceof InvolvedArc) {
			InvolvedArc involvedArc = (InvolvedArc) annotation;
			// change status of the involved arc
			involvedArc.setActive(!involvedArc.isActive());
			
			EnabledTransition transition = involvedArc.getTarget();
			if (transition != null) {
				// check whether the change of active status of the
				// arc changes the enabledness of the transition
				boolean active = transition.isEnabled();
				boolean result = true;
				for (InvolvedArc other: transition.getIn()) {
					if (other.isActive()) {
						result = false;
						break;
					}
				}
				if (active != result) {
					// if the enabledness of the transition changed, update
					// the status for the transition and the Ref transitions
					transition.setEnabled(result);
					for (EnabledTransition refTrans: transition.getRefs()) {
						refTrans.setEnabled(result);
					}
				}
				
				int size = application.getNetAnnotations().getNetAnnotations().size();
				application.deleteNetAnnotationAfterCurrent();
				if (size == application.getNetAnnotations().getNetAnnotations().size()) {
					// application.deleteNetAnnotationAfterCurrent() automatically issues
					// an update if some annotation are deleted; if not, we need to update
					// explicitly
					application.update();
				}
				return true;
			}
		}
		return false; 
	}

	@Override
	public boolean mouseReleased(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}

}