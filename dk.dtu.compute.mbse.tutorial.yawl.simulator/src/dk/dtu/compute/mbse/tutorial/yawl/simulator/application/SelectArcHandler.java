package dk.dtu.compute.mbse.tutorial.yawl.simulator.application;

import org.eclipse.draw2d.MouseEvent;
import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.applications.ui.IActionHandler;

import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.EnabledTransition;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.Marking;
import dk.dtu.compute.mbse.tutorial.yawl.simulator.yawlannotations.SelectArc;
import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.helpfunctions.YAWLFunctions;

/**
 * Action handler for the YAWL arcs, which includes the actions for the bit operators.
 * 
 * @author David Josef Kristensen - s143312 
 * @author Henrik Iller Wærsted - s154280
 * @author Lars Vandsted Myrup Jensen - s153201 
 * @author Rasmus Hannibal Barlach Moulvad - s153256
 * @author Rasmus Vulpius Gregersen - S144219
 *
 */

public class SelectArcHandler implements IActionHandler {

	private YAWLSimulator application;

	public SelectArcHandler(YAWLSimulator application) {
		super();
		this.application = application;
	}

	@Override
	public boolean mouseDoubleClicked(MouseEvent arg0, ObjectAnnotation annotation) {
		return false;
	}

	@Override
	public boolean mousePressed(MouseEvent arg0, ObjectAnnotation annotation) {
		if (annotation instanceof SelectArc) {
			SelectArc selectArcs = (SelectArc) annotation;
			EnabledTransition targetAction = selectArcs.getTargetTransition();
			EnabledTransition sourceAction = selectArcs.getSourceTransition();
			Marking sourceMarking = selectArcs.getSourceMarking();

			if (targetAction != null) {
				if (!selectArcs.isSelected() && sourceMarking != null && sourceMarking.getValue() > 0) {
					Transition transition = (Transition) targetAction.getTransition();
					if (YAWLFunctions.getJoinType(transition).equals(TType.XOR)) {
						for (SelectArc s_arc : targetAction.getInArcs()) {
							s_arc.setSelected(false);
						}
						selectArcs.setSelected(true);
						application.update();
						return true;
					}
				}
			} else if (sourceAction != null) {
				Transition transition = (Transition) sourceAction.getTransition();
				TType tType = YAWLFunctions.getSplitType(transition);
				if (tType.equals(TType.XOR)) {
					for (SelectArc s_arc : sourceAction.getOutArcs()) {
						s_arc.setSelected(false);
					}
					selectArcs.setSelected(true);
					application.update();
					return true;
				} else if (tType.equals(TType.OR)) {
					selectArcs.setSelected(!selectArcs.isSelected());
					boolean notEmpty = false;
					for (SelectArc s_arc : sourceAction.getOutArcs()) {
						if (s_arc.isSelected()) {
							notEmpty = true;
							break;
						}
					}
					if (!notEmpty) {
						for (SelectArc s_arc : sourceAction.getOutArcs()) {
							if (s_arc != selectArcs) {
								s_arc.setSelected(true);
								break;
							}
						}
					}
					application.update();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean mouseReleased(MouseEvent arg0, ObjectAnnotation annotation) {
		// TODO Auto-generated method stub
		return false;
	}
}