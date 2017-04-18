package dk.dtu.compute.mbse.tutorial.yawl.simulator.application;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IPresentationHandler;
import org.pnml.tools.epnk.applications.ui.figures.PolylineOverlay;
import org.pnml.tools.epnk.applications.ui.figures.RectangleOverlay;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.EnabledTransition;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.SelectArc;
import dk.dtu.compute.mbse.yawl.Arc;

/**
 * Presentation handler for the Transitions and Arcs, which marks (colors) them.
 * 
 * @author David Josef Kristensen - s143312 
 * @author Henrik Iller W�rsted - s154280
 * @author Lars Vandsted Myrup Jensen - s153201 
 * @author Rasmus Hannibal Barlach Moulvad - s153256
 * @author Rasmus Vulpius Gregersen - S144219
 *
 */

public class YAWLAnnotationsPresentationHandler implements IPresentationHandler {

	@Override
	public IFigure handle(ObjectAnnotation annotation, AbstractGraphicalEditPart editPart) {
		if (annotation instanceof EnabledTransition) {
			if (editPart instanceof GraphicalEditPart) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
				Object modelObject = graphicalEditPart.resolveSemanticElement();
				if (modelObject instanceof TransitionNode) {
					RectangleOverlay overlay = new RectangleOverlay(graphicalEditPart);
					overlay.setForegroundColor(ColorConstants.blue);
					overlay.setBackgroundColor(ColorConstants.blue);
					return overlay;
				}
			}
		} else if (annotation instanceof SelectArc) {
			SelectArc selectArc = (SelectArc) annotation;
			if (editPart instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connectionEditPart = (ConnectionNodeEditPart) editPart;
				Object modelObject = connectionEditPart.resolveSemanticElement();
				if (modelObject instanceof Arc) {
					PolylineOverlay overlay = new PolylineOverlay(connectionEditPart);
					if (!selectArc.isSelected()) {
						overlay.setForegroundColor(ColorConstants.lightGray);
						overlay.setBackgroundColor(ColorConstants.lightGray);
					} else {
						overlay.setForegroundColor(ColorConstants.blue);
						overlay.setBackgroundColor(ColorConstants.blue);
					}
					return overlay;
				}
			}
		}
		return null;
	}

}