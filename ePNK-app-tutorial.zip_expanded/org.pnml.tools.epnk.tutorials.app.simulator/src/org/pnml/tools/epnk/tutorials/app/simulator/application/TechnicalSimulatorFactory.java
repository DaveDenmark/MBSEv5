package org.pnml.tools.epnk.tutorials.app.simulator.application;

import org.pnml.tools.epnk.applications.ApplicationFactory;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;
import org.pnml.tools.epnk.tutorials.app.technical.TechnicalNetType;

/**
 * TH application factory which is plugged in for registering the technical
 * simulator with the ePNK (see plugin.xml).
 * 
 * @author ekki@dtu.dk
 *
 */
public class TechnicalSimulatorFactory extends ApplicationFactory {

	public TechnicalSimulatorFactory() {
		super();
	}

	@Override
	public String getName() {
		return "Technical Simulator (Tutorial)";
	}

	@Override
	public String getDescription() {
		return "A technical simulator used for the ePNK tutorial for applications";
	}

	@Override
	public boolean isApplicable(PetriNet net) {
		return net.getType() instanceof TechnicalNetType;
	}

	@Override
	public ApplicationWithUIManager startApplication(PetriNet net) {
		return new TechnicalSimulator(net);
	}

}
