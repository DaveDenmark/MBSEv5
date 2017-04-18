package org.pnml.tools.epnk.tutorials.app.simulator.application;

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

import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc;
import org.pnml.tools.epnk.tutorials.app.technical.Arc;

/**
 * Presentation handler for all annotations which have a specific appearance
 * in the simulator. These are the involved arcs and the enabled transitions.
 * Markings will properly be shown by the default presentation handlers.
 * 
 * @author ekki@dtu.dk
 *
 */
public class TechnicalAnnotationsPresentationHandler implements IPresentationHandler {

	@Override
	public IFigure handle(ObjectAnnotation annotation,
			AbstractGraphicalEditPart editPart) {
		if (annotation instanceof EnabledTransition) {
			if (editPart instanceof GraphicalEditPart) {
				GraphicalEditPart graphicalEditPart = (GraphicalEditPart) editPart;
				java.lang.Object modelObject = graphicalEditPart.resolveSemanticElement();
				if (modelObject instanceof TransitionNode) {
					RectangleOverlay overlay = new RectangleOverlay(graphicalEditPart);
					if (((EnabledTransition) annotation).isEnabled()) {
						overlay.setForegroundColor(ColorConstants.red);
						overlay.setBackgroundColor(ColorConstants.red);
					} else {
						overlay.setForegroundColor(ColorConstants.lightGray);
						overlay.setBackgroundColor(ColorConstants.lightGray);
						
					}
					return overlay;
				}
			}
		} else if (annotation instanceof InvolvedArc) {
			InvolvedArc involvedArc = (InvolvedArc) annotation;
			if (editPart instanceof ConnectionNodeEditPart) {
				ConnectionNodeEditPart connectionEditPart = (ConnectionNodeEditPart) editPart;
				java.lang.Object modelObject = connectionEditPart.resolveSemanticElement();
				if (modelObject instanceof Arc) {
					PolylineOverlay overlay = new PolylineOverlay(connectionEditPart);
					if (involvedArc.isActive()) {
						overlay.setForegroundColor(ColorConstants.lightGray);
						overlay.setBackgroundColor(ColorConstants.lightGray);
					} else {
						overlay.setForegroundColor(ColorConstants.red);
						overlay.setBackgroundColor(ColorConstants.red);	
					}
					return overlay;
				}
			}
		}
		// Note that for all the other annotations, the default presentation handlers of
		// ePNK applications serve our purpose just fine. So we do not deal with them here.
		return null;
	}

}