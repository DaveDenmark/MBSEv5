package org.pnml.tools.epnk.tutorials.app.graphics.figures;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.SWT;

import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.ArrowHeadDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.CircleDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.DoubleArrowHeadDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.ArcFigure;

import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Node;

import org.pnml.tools.epnk.tutorials.app.technical.helpers.ArcType;
import org.pnml.tools.epnk.tutorials.app.technical.helpers.TechnicalNetTypeFunctions;

/**
 * The figure defining implementing the graphical appearance of arcs in the
 * Technical Net Type.
 * 
 * @author ekki@dtu.dk
 * 
 */
public class TechnicalNetTypeArcFigure extends ArcFigure {

	private ArcType arcType;
	
	public TechnicalNetTypeArcFigure(Arc arc) {
		super(arc);
		arcType = TechnicalNetTypeFunctions.getArcType(arc);
		setGraphics();
	}

	@Override
	public void update() {
		ArcType oldArcType = arcType;
		arcType = TechnicalNetTypeFunctions.getArcType(arc);
		if (arcType != oldArcType) {
			setGraphics();
			// Notify attached target node of the change (which will initiate the update of the
			// corresponding graphical representation if needed).
			Node target = arc.getTarget();
			if (target instanceof InternalEObject) {
				target.eNotify(new ENotificationImpl((InternalEObject) target, Notification.NO_FEATURE_ID, null, null, null));
			}
		}
	}

	private void setGraphics() {
		if (arcType == ArcType.READ){
			this.setTargetDecoration(null);
			this.setSourceDecoration(null);
			this.setLineStyle(SWT.LINE_SOLID);
		} else if (arcType == ArcType.INHIBITOR){
			this.setTargetDecoration(new CircleDecoration());
			this.setSourceDecoration(null);
			this.setLineStyle(SWT.LINE_SOLID);
		} else if (arcType == ArcType.RESET) {
			this.setTargetDecoration(new DoubleArrowHeadDecoration());
			this.setSourceDecoration(null);
			this.setLineStyle(SWT.LINE_DASH);
		} else {
			// everything else is interpreted as NORMAL arc
			this.setTargetDecoration(new ArrowHeadDecoration());
			this.setSourceDecoration(null);
			this.setLineStyle(SWT.LINE_SOLID);
		}
	}

}
