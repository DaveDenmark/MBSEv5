package dk.dtu.compute.mbse.petrinet.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetElementTypes;
import dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetModelingAssistantProvider;

/**
 * @generated
 */
public class PetrinetModelingAssistantProviderOfPetrinetEditPart extends PetrinetModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(PetrinetElementTypes.Place_2001);
		types.add(PetrinetElementTypes.Transition_2002);
		return types;
	}

}
