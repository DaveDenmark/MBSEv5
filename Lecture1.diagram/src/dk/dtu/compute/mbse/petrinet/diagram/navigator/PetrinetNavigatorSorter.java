package dk.dtu.compute.mbse.petrinet.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import dk.dtu.compute.mbse.petrinet.diagram.part.PetrinetVisualIDRegistry;

/**
 * @generated
 */
public class PetrinetNavigatorSorter extends ViewerSorter {

	/**
	* @generated
	*/
	private static final int GROUP_CATEGORY = 4003;

	/**
	* @generated
	*/
	public int category(Object element) {
		if (element instanceof PetrinetNavigatorItem) {
			PetrinetNavigatorItem item = (PetrinetNavigatorItem) element;
			return PetrinetVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
