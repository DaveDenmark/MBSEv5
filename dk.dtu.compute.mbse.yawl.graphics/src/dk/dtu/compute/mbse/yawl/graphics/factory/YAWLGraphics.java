package dk.dtu.compute.mbse.yawl.graphics.factory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.pnml.tools.epnk.gmf.extensions.graphics.GraphicalExtension;
import org.pnml.tools.epnk.gmf.extensions.graphics.IArcFigure;
import org.pnml.tools.epnk.gmf.extensions.graphics.IUpdateableFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Place;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import dk.dtu.compute.mbse.yawl.*;
import dk.dtu.compute.mbse.yawl.graphics.figures.YAWLArcFigure;
import dk.dtu.compute.mbse.yawl.graphics.figures.YAWLPlaceFigure;
import dk.dtu.compute.mbse.yawl.graphics.figures.YAWLTransitionFigure;

/**
 * The graphical extension the the Technical Net extension. This is
 * the class plugged in to the ePNK  (see plugin.xml).
 * 
 * @author Dave@dtu.dk
 *
 */
public class YAWLGraphics extends GraphicalExtension {

	
	public YAWLGraphics() {
		super();
	}

	@Override
	public List<EClass> getExtendedNetTypes() {
		ArrayList<EClass> results = new ArrayList<EClass>();
		results.add(YawlPackage.eINSTANCE.getYAWLNet());
		return results;
	}

	@Override
	public List<EClass> getExtendedNetObjects(EClass netType) {
		ArrayList<EClass> results = new ArrayList<EClass>();
		if (netType.equals(YawlPackage.eINSTANCE.getYAWLNet())) {
			results.add(YawlPackage.eINSTANCE.getArc());
			results.add(YawlPackage.eINSTANCE.getPlace());
			results.add(YawlPackage.eINSTANCE.getTransition());
			// No graphical extension for places
			// results.add((TechnicalPackage.eINSTANCE.getPlace());
			//results.add(TechnicalPackage.eINSTANCE.getTransition());
		}
		return results;
	}

	@Override
	public IArcFigure createArcFigure(Arc arc) {
		if (arc instanceof dk.dtu.compute.mbse.yawl.Arc) {
			return new YAWLArcFigure((dk.dtu.compute.mbse.yawl.Arc) arc);
		}
		return null;
	}

	   
	@Override
	public IUpdateableFigure createPlaceFigure(Place place) {
		if (place instanceof dk.dtu.compute.mbse.yawl.Place) {
			return new YAWLPlaceFigure((dk.dtu.compute.mbse.yawl.Place) place);
		}
		return null;
	}
	

	@Override
	public IUpdateableFigure createTransitionFigure(Transition transition) {
		if (transition instanceof dk.dtu.compute.mbse.yawl.Transition) {
			return new YAWLTransitionFigure(transition);
		}
		return null;
	}
}
