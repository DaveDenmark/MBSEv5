package dk.dtu.compute.mbse.tutorial.yawl.simulator.application;

import org.pnml.tools.epnk.applications.ApplicationFactory;
import org.pnml.tools.epnk.applications.ApplicationWithUIManager;
import org.pnml.tools.epnk.pnmlcoremodel.PetriNet;

import dk.dtu.compute.mbse.yawl.YAWLNet;

/**
 * The application factory which is plugged in for registering the YAWL
 * simulator with the ePNK.
 * 
 * @author David Josef Kristensen - s143312 
 * @author Henrik Iller Wærsted - s154280
 * @author Lars Vandsted Myrup Jensen - s153201 
 * @author Rasmus Hannibal Barlach Moulvad - s153256
 * @author Rasmus Vulpius Gregersen - S144219
 *
 */
public class YAWLSimulatorFactory extends ApplicationFactory {

	public YAWLSimulatorFactory() {
		super();
	}

	@Override
	public String getName() {
		return "Group 6 YAWL Simulator";
	}

	@Override
	public String getDescription() {
		return "Our adaptation of the technical simulator to a YAWL simulator";
	}

	@Override
	public boolean isApplicable(PetriNet net) {
		return net.getType() instanceof YAWLNet;
	}

	@Override
	public ApplicationWithUIManager startApplication(PetriNet net) {
		return new YAWLSimulator(net);
	}

}
