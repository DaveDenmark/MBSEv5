package org.pnml.tools.epnk.tutorials.app.technical.helpers;

import java.util.List;

import org.pnml.tools.epnk.helpers.FlatAccess;
import org.pnml.tools.epnk.helpers.NetFunctions;
import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Node;
import org.pnml.tools.epnk.pnmlcoremodel.Page;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.pnmlcoremodel.Place;
import org.pnml.tools.epnk.pnmlcoremodel.PlaceNode;
import org.pnml.tools.epnk.pnmlcoremodel.TransitionNode;

import org.pnml.tools.epnk.tutorials.app.technical.ArcTypeAttribute;
import org.pnml.tools.epnk.tutorials.app.technical.MarkingLabel;
import org.pnml.tools.epnk.tutorials.app.technical.Transition;

/** 
 * This class provides general functionality for the Technical Petri Net Type as
 * static methods. Its main purpose is to make it easier to maintain this software
 * and to assure a uniform interpretation of default values (this applies in
 * particular to {@link ArcType}s).
 * 
 * @author ekki@dtu.dk
 * @generated NOT
 */
public class TechnicalNetTypeFunctions {
	
	/**
	 * Computes the type of the arc from the arcs setting. This method should provide
	 * a unified "interpretation" of arc types (actually this should be the only 
	 * interpretation).
	 * 
	 * @param arc
	 * @return one of the four possible interpretations of the type of the arc;
	 *         null, if there is no interpretation of the arc type
	 */
	public static ArcType getArcType(Arc arc) {
		if (arc instanceof org.pnml.tools.epnk.tutorials.app.technical.Arc) {
			org.pnml.tools.epnk.tutorials.app.technical.Arc tArc =
					(org.pnml.tools.epnk.tutorials.app.technical.Arc) arc;
			Node source = arc.getSource();
			Node target = arc.getTarget();
			ArcTypeAttribute type = tArc.getType();
			
			if (source instanceof Page && target instanceof TransitionNode) {
				return ArcType.RESET;
			} 
			
			if (type != null) {
				if (source instanceof PlaceNode || source instanceof TransitionNode) {
					switch (type.getText()) {
					case READ: return ArcType.READ;
					case INHBITOR: return ArcType.INHIBITOR;
					default: return ArcType.NORMAL;
					}
				} else {
					return null;
				}
			} else {
				if (source instanceof PlaceNode || source instanceof TransitionNode) {
					return ArcType.NORMAL;
				}
			}
		}
		return null;	
	}
	
	public static int getMarking(Place place) {
		if (place instanceof org.pnml.tools.epnk.tutorials.app.technical.Place) {
			org.pnml.tools.epnk.tutorials.app.technical.Place tPlace =
					(org.pnml.tools.epnk.tutorials.app.technical.Place) place;
			MarkingLabel marking = tPlace.getMarking();
			if (marking != null) {
				return marking.getText().getValue();
			} 
		}
		
		return 0;
	}
	
	public static boolean hasNormalInArcs(Transition transition) {
		PetriNet net = NetFunctions.getPetriNet(transition);
		FlatAccess flatAccess = FlatAccess.getFlatAccess(net);
		if (flatAccess != null) {
			List<Arc> inArcs = flatAccess.getIn(transition);
			for (Arc arc: inArcs) {
				if (getArcType(arc) == ArcType.NORMAL) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean hasNormalOutArcs(Transition transition) {
		PetriNet net = NetFunctions.getPetriNet(transition);
		FlatAccess flatAccess = FlatAccess.getFlatAccess(net);
		if (flatAccess != null) {
			List<Arc> outArcs = flatAccess.getOut(transition);
			for (Arc arc: outArcs) {
				if (getArcType(arc) == ArcType.NORMAL) {
					return true;
				}
			}
		}
		return false;
	}
	
}
