package dk.dtu.compute.mbse.petrinet.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import dk.dtu.compute.mbse.petrinet.Arc;
import dk.dtu.compute.mbse.petrinet.Node;
import dk.dtu.compute.mbse.petrinet.PetrinetFactory;
import dk.dtu.compute.mbse.petrinet.PetrinetPackage;
import dk.dtu.compute.mbse.petrinet.Place;
import dk.dtu.compute.mbse.petrinet.Token;
import dk.dtu.compute.mbse.petrinet.Transition;

public class FireTransitionCommand extends CompoundCommand {

	public FireTransitionCommand(EditingDomain domain, Transition transition){
		super("Fire Transition");

		// compute the number of tokens needed for each place
		Map<Place,Integer> needed = new HashMap<Place,Integer>(); 
		for (Arc arc : transition.getIn()) {
			Node node = arc.getSource();
			if (node instanceof Place) {
				Place source = (Place) node;
				needed.put(source, needed.getOrDefault(source, 0) + 1); 
			} 
		}

		// add commands for removing the needed number of tokens form each place
		for (Place place: needed.keySet()){
			for (int i =0; i < needed.get(place) && i < place.getTokens().size(); i++){
				this.append(new RemoveCommand(domain, place, PetrinetPackage.eINSTANCE.getPlace_Tokens(), place.getTokens().get(i)));
				
			}
		}
		
		// add commands for adding a token to each target place of each output arc
		for(Arc arc: transition.getOut()){
			Node node = arc.getTarget();
			if (node instanceof Place){
				Place place = (Place) node;
				Token token = PetrinetFactory.eINSTANCE.createToken();
				this.append(new CreateChildCommand(domain, place, PetrinetPackage.eINSTANCE.getPlace_Tokens(), token, null));
			}
		}
	}
}