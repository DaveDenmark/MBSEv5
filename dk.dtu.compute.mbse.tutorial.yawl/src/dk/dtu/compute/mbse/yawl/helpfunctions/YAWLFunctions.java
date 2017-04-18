package dk.dtu.compute.mbse.yawl.helpfunctions;

import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.helpers.NetFunctions;

import dk.dtu.compute.mbse.yawl.AType;
import dk.dtu.compute.mbse.yawl.Arc;
import dk.dtu.compute.mbse.yawl.ArcType;
import dk.dtu.compute.mbse.yawl.PType;
import dk.dtu.compute.mbse.yawl.Place;
import dk.dtu.compute.mbse.yawl.PlaceType;
import dk.dtu.compute.mbse.yawl.TType;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.SplitTransition;
import dk.dtu.compute.mbse.yawl.JoinTransition;

/**
 * 
 * YAWL help functions for Arc, Place and Transition types.
 * 
 * @author David Josef Kristensen - s143312 
 * @author Henrik Iller Wærsted - s154280
 * @author Lars Vandsted Myrup Jensen - s153201 
 * @author Rasmus Hannibal Barlach Moulvad - s153256
 * @author Rasmus Vulpius Gregersen - S144219
 * 
 */

public class YAWLFunctions {
	
	public static PType getType(org.pnml.tools.epnk.pnmlcoremodel.Place place) {
		if (place instanceof Place) {
			Place YAWLplace = (Place) place;
			PlaceType type = YAWLplace.getPlacetype();
			if (type != null) {
				if (type.getText().equals(PType.START)) {
					return PType.START;
				} else if (type.getText().equals(PType.FINISH)) {
					return PType.FINISH;
				}
			} else {
				return PType.NORMAL;
			}
		}
		return PType.NORMAL;
	}

	public static AType getType(org.pnml.tools.epnk.pnmlcoremodel.Arc arc) {
		if (arc instanceof Arc) {
			Arc YAWLArc = (Arc) arc;
			ArcType type = (ArcType) YAWLArc.getArctype();
			if (type != null) {
				if (type.getText().equals(AType.RESET)) {
					return AType.RESET;
				}
			} else {
				return AType.NORMAL;
			}
		}
		return AType.NORMAL;
	
		}
	public static boolean isResetArc(org.pnml.tools.epnk.pnmlcoremodel.Arc arc) {
		return getType(arc).equals(AType.RESET);
	
	}

	public static TType getJoinType(org.pnml.tools.epnk.pnmlcoremodel.Transition transition) {
		FlatAccess flat = FlatAccess.getFlatAccess(NetFunctions.getPetriNet(transition));
		if (transition instanceof Transition) {
			Transition YAWLTransition = (Transition) transition;
			int count = 0;
			for (org.pnml.tools.epnk.pnmlcoremodel.Arc a : flat.getIn(YAWLTransition)) {
				if (a instanceof Arc) {
					Arc arc = (Arc) a;
					if (arc.getArctype() == null || arc.getArctype().equals(AType.NORMAL)) {
						count++;
					}
				}
			}
			if (count == 1) {
				return TType.SINGLE;
				
			} else if (count > 1) {
				JoinTransition joinTrans = YAWLTransition.getJointransition();
				if (joinTrans != null) {
					if (joinTrans.getText().equals(TType.OR)) {
						return TType.OR;
					} else if (joinTrans.getText().equals(TType.XOR)) {
						return TType.XOR;
					} else {
						return TType.AND;
					}
				}
				return TType.AND;
			}
		}
		return TType.SINGLE;
	}
	
	public static TType getSplitType(org.pnml.tools.epnk.pnmlcoremodel.Transition transition) {
		FlatAccess flat = FlatAccess.getFlatAccess(NetFunctions.getPetriNet(transition));
		if (transition instanceof Transition) {
			Transition YAWLTransition = (Transition) transition;
			int count = 0;
			for (org.pnml.tools.epnk.pnmlcoremodel.Arc a : flat.getOut(YAWLTransition)) {
				if (a instanceof Arc) {
					Arc arc = (Arc) a;
					if (arc.getArctype() == null || arc.getArctype().equals(AType.NORMAL)) {
						count++;
					}
				}
			}
			if (count == 1) {
				return TType.SINGLE;
			} else if (count > 1) {
				SplitTransition splitTrans = YAWLTransition.getSplittransition();
				if (splitTrans != null) {
					if (splitTrans.getText().equals(TType.OR)) {
						return TType.OR;
					} else if (splitTrans.getText().equals(TType.XOR)) {
						return TType.XOR;
					} else {
						return TType.AND;
					}
				}
				return TType.AND;
			}
		}
		return TType.SINGLE;
	}

}
