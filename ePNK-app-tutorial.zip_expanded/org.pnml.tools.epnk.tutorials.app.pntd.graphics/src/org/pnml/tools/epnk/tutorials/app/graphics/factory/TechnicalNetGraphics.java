package org.pnml.tools.epnk.tutorials.app.graphics.factory;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import org.pnml.tools.epnk.gmf.extensions.graphics.GraphicalExtension;
import org.pnml.tools.epnk.gmf.extensions.graphics.IArcFigure;
import org.pnml.tools.epnk.gmf.extensions.graphics.IUpdateableFigure;
import org.pnml.tools.epnk.pnmlcoremodel.Arc;
import org.pnml.tools.epnk.pnmlcoremodel.Transition;

import org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage;

import org.pnml.tools.epnk.tutorials.app.graphics.figures.TechnicalNetTypeArcFigure;
import org.pnml.tools.epnk.tutorials.app.graphics.figures.TechnicalNetTypeTransitionFigure;

/**
 * The graphical extension the the Technical Net extension. This is
 * the class plugged in to the ePNK  (see plugin.xml).
 * 
 * @author ekki@dtu.dk
 *
 */
public class TechnicalNetGraphics extends GraphicalExtension {

	
	public TechnicalNetGraphics() {
		super();
	}

	@Override
	public List<EClass> getExtendedNetTypes() {
		ArrayList<EClass> results = new ArrayList<EClass>();
		results.add(TechnicalPackage.eINSTANCE.getTechnicalNetType());
		return results;
	}

	@Override
	public List<EClass> getExtendedNetObjects(EClass netType) {
		ArrayList<EClass> results = new ArrayList<EClass>();
		if (netType.equals(TechnicalPackage.eINSTANCE.getTechnicalNetType())) {
			results.add(TechnicalPackage.eINSTANCE.getArc());
			// No graphical extension for places
			// results.add((TechnicalPackage.eINSTANCE.getPlace());
			results.add(TechnicalPackage.eINSTANCE.getTransition());
		}
		return results;
	}

	@Override
	public IArcFigure createArcFigure(Arc arc) {
		if (arc instanceof org.pnml.tools.epnk.tutorials.app.technical.Arc) {
			return new TechnicalNetTypeArcFigure(arc);
		}
		return null;
	}

	/*
	   No graphical extension for places
	   
	@Override
	public IUpdateableFigure createPlaceFigure(Place place) {
		return null;
	}
	*/

	@Override
	public IUpdateableFigure createTransitionFigure(Transition transition) {
		if (transition instanceof org.pnml.tools.epnk.tutorials.app.technical.Transition) {
			return new TechnicalNetTypeTransitionFigure(transition);
		}
		return null;
	}

}
