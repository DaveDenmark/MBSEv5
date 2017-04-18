
package dk.dtu.compute.mbse.petrinet.diagram.part;

import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

import dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetElementTypes;

/**
 * @generated
 */
public class PetrinetPaletteFactory {

	/**
	* @generated
	*/
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createPetrinet1Group());
	}

	/**
	* Creates "petrinet" palette tool group
	* @generated
	*/
	private PaletteContainer createPetrinet1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Petrinet1Group_title);
		paletteContainer.setId("createPetrinet1Group"); //$NON-NLS-1$
		paletteContainer.add(createArc1CreationTool());
		paletteContainer.add(createTransition2CreationTool());
		paletteContainer.add(createPlace3CreationTool());
		paletteContainer.add(createToken4CreationTool());
		return paletteContainer;
	}

	/**
	* @generated
	*/
	private ToolEntry createArc1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Arc1CreationTool_title,
				Messages.Arc1CreationTool_desc, Collections.singletonList(PetrinetElementTypes.Arc_4001));
		entry.setId("createArc1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetrinetElementTypes.getImageDescriptor(PetrinetElementTypes.Arc_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createTransition2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Transition2CreationTool_title,
				Messages.Transition2CreationTool_desc, Collections.singletonList(PetrinetElementTypes.Transition_2002));
		entry.setId("createTransition2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetrinetElementTypes.getImageDescriptor(PetrinetElementTypes.Transition_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createPlace3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Place3CreationTool_title,
				Messages.Place3CreationTool_desc, Collections.singletonList(PetrinetElementTypes.Place_2001));
		entry.setId("createPlace3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetrinetElementTypes.getImageDescriptor(PetrinetElementTypes.Place_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createToken4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Token4CreationTool_title,
				Messages.Token4CreationTool_desc, Collections.singletonList(PetrinetElementTypes.Token_3001));
		entry.setId("createToken4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(PetrinetElementTypes.getImageDescriptor(PetrinetElementTypes.Token_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
