package dk.dtu.compute.mbse.petrinet.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import dk.dtu.compute.mbse.petrinet.PetrinetPackage;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.ArcEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.PetrinetEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.PlaceEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.TokenEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.TransitionEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.part.PetrinetDiagramEditorPlugin;

/**
 * @generated
 */
public class PetrinetElementTypes {

	/**
	* @generated
	*/
	private PetrinetElementTypes() {
	}

	/**
	* @generated
	*/
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			PetrinetDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	* @generated
	*/
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	* @generated
	*/
	public static final IElementType Petrinet_1000 = getElementType("Lecture1.diagram.Petrinet_1000"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Place_2001 = getElementType("Lecture1.diagram.Place_2001"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Transition_2002 = getElementType("Lecture1.diagram.Transition_2002"); //$NON-NLS-1$
	/**
	* @generated
	*/
	public static final IElementType Token_3001 = getElementType("Lecture1.diagram.Token_3001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static final IElementType Arc_4001 = getElementType("Lecture1.diagram.Arc_4001"); //$NON-NLS-1$

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	* @generated
	*/
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	* @generated
	*/
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	* @generated
	*/
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	* Returns 'type' of the ecore object associated with the hint.
	* 
	* @generated
	*/
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Petrinet_1000, PetrinetPackage.eINSTANCE.getPetrinet());

			elements.put(Place_2001, PetrinetPackage.eINSTANCE.getPlace());

			elements.put(Transition_2002, PetrinetPackage.eINSTANCE.getTransition());

			elements.put(Token_3001, PetrinetPackage.eINSTANCE.getToken());

			elements.put(Arc_4001, PetrinetPackage.eINSTANCE.getArc());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	* @generated
	*/
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	* @generated
	*/
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Petrinet_1000);
			KNOWN_ELEMENT_TYPES.add(Place_2001);
			KNOWN_ELEMENT_TYPES.add(Transition_2002);
			KNOWN_ELEMENT_TYPES.add(Token_3001);
			KNOWN_ELEMENT_TYPES.add(Arc_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	* @generated
	*/
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case PetrinetEditPart.VISUAL_ID:
			return Petrinet_1000;
		case PlaceEditPart.VISUAL_ID:
			return Place_2001;
		case TransitionEditPart.VISUAL_ID:
			return Transition_2002;
		case TokenEditPart.VISUAL_ID:
			return Token_3001;
		case ArcEditPart.VISUAL_ID:
			return Arc_4001;
		}
		return null;
	}

	/**
	* @generated
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetElementTypes.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetElementTypes.getElement(elementTypeAdapter);
		}
	};

}
