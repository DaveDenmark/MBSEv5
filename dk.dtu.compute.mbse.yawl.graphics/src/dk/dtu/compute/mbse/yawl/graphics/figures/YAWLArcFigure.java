package dk.dtu.compute.mbse.yawl.graphics.figures;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.swt.SWT;

import dk.dtu.compute.mbse.yawl.AType;
import dk.dtu.compute.mbse.yawl.Arc;
import dk.dtu.compute.mbse.yawl.ArcType;
import dk.dtu.compute.mbse.yawl.PType;
import dk.dtu.compute.mbse.yawl.Place;
import dk.dtu.compute.mbse.yawl.PlaceType;
import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.helpfunctions.*;

import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.ArrowHeadDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.CircleDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.decorations.DoubleArrowHeadDecoration;
import org.pnml.tools.epnk.gmf.extensions.graphics.figures.ArcFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Node;

/**

 * @author Dave@dtu.dk
 * 
 */

public class YAWLArcFigure extends ArcFigure {

	private AType aType;
	public YAWLArcFigure(Arc arc) {
		super(arc);
		aType =YAWLFunctions.getType(arc);
		setGraphics();
	}
 
	@Override
	public void update() {
		AType oldArcType = aType;
		aType = YAWLFunctions.getType((Arc) arc);
		if (aType != oldArcType) {
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
		if (aType == AType.NORMAL){
			this.setTargetDecoration(new ArrowHeadDecoration());
			this.setSourceDecoration(null);
			this.setLineStyle(SWT.LINE_SOLID);
		} else if (aType == AType.RESET){
			this.setTargetDecoration(new DoubleArrowHeadDecoration());
			this.setSourceDecoration(null);
			this.setLineStyle(SWT.LINE_DASH);
		}
	}

}
