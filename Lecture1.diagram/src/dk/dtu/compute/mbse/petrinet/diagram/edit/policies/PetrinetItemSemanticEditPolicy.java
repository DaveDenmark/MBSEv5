package dk.dtu.compute.mbse.petrinet.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import dk.dtu.compute.mbse.petrinet.diagram.edit.commands.PlaceCreateCommand;
import dk.dtu.compute.mbse.petrinet.diagram.edit.commands.TransitionCreateCommand;
import dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetElementTypes;

/**
 * @generated
 */
public class PetrinetItemSemanticEditPolicy extends PetrinetBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public PetrinetItemSemanticEditPolicy() {
		super(PetrinetElementTypes.Petrinet_1000);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PetrinetElementTypes.Place_2001 == req.getElementType()) {
			return getGEFWrapper(new PlaceCreateCommand(req));
		}
		if (PetrinetElementTypes.Transition_2002 == req.getElementType()) {
			return getGEFWrapper(new TransitionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	* @generated
	*/
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	* @generated
	*/
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		* @generated
		*/
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
