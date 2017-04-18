package dk.dtu.compute.mbse.petrinet.diagram.navigator;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import dk.dtu.compute.mbse.petrinet.Petrinet;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.ArcEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.PetrinetEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.PlaceEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.PlaceNameEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.TokenEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.TransitionEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.edit.parts.TransitionNameEditPart;
import dk.dtu.compute.mbse.petrinet.diagram.part.PetrinetDiagramEditorPlugin;
import dk.dtu.compute.mbse.petrinet.diagram.part.PetrinetVisualIDRegistry;
import dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetElementTypes;
import dk.dtu.compute.mbse.petrinet.diagram.providers.PetrinetParserProvider;

/**
 * @generated
 */
public class PetrinetNavigatorLabelProvider extends LabelProvider
		implements ICommonLabelProvider, ITreePathLabelProvider {

	/**
	* @generated
	*/
	static {
		PetrinetDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?UnknownElement", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
		PetrinetDiagramEditorPlugin.getInstance().getImageRegistry().put("Navigator?ImageNotFound", //$NON-NLS-1$
				ImageDescriptor.getMissingImageDescriptor());
	}

	/**
	* @generated
	*/
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof PetrinetNavigatorItem && !isOwnView(((PetrinetNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	* @generated
	*/
	public Image getImage(Object element) {
		if (element instanceof PetrinetNavigatorGroup) {
			PetrinetNavigatorGroup group = (PetrinetNavigatorGroup) element;
			return PetrinetDiagramEditorPlugin.getInstance().getBundledImage(group.getIcon());
		}

		if (element instanceof PetrinetNavigatorItem) {
			PetrinetNavigatorItem navigatorItem = (PetrinetNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	* @generated
	*/
	public Image getImage(View view) {
		switch (PetrinetVisualIDRegistry.getVisualID(view)) {
		case PetrinetEditPart.VISUAL_ID:
			return getImage("Navigator?Diagram?http://mbse.compute.dtu.dk/petrinet?Petrinet", //$NON-NLS-1$
					PetrinetElementTypes.Petrinet_1000);
		case PlaceEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://mbse.compute.dtu.dk/petrinet?Place", //$NON-NLS-1$
					PetrinetElementTypes.Place_2001);
		case TransitionEditPart.VISUAL_ID:
			return getImage("Navigator?TopLevelNode?http://mbse.compute.dtu.dk/petrinet?Transition", //$NON-NLS-1$
					PetrinetElementTypes.Transition_2002);
		case TokenEditPart.VISUAL_ID:
			return getImage("Navigator?Node?http://mbse.compute.dtu.dk/petrinet?Token", //$NON-NLS-1$
					PetrinetElementTypes.Token_3001);
		case ArcEditPart.VISUAL_ID:
			return getImage("Navigator?Link?http://mbse.compute.dtu.dk/petrinet?Arc", PetrinetElementTypes.Arc_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = PetrinetDiagramEditorPlugin.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null && PetrinetElementTypes.isKnownElementType(elementType)) {
			image = PetrinetElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	* @generated
	*/
	public String getText(Object element) {
		if (element instanceof PetrinetNavigatorGroup) {
			PetrinetNavigatorGroup group = (PetrinetNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof PetrinetNavigatorItem) {
			PetrinetNavigatorItem navigatorItem = (PetrinetNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	* @generated
	*/
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (PetrinetVisualIDRegistry.getVisualID(view)) {
		case PetrinetEditPart.VISUAL_ID:
			return getPetrinet_1000Text(view);
		case PlaceEditPart.VISUAL_ID:
			return getPlace_2001Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_2002Text(view);
		case TokenEditPart.VISUAL_ID:
			return getToken_3001Text(view);
		case ArcEditPart.VISUAL_ID:
			return getArc_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	* @generated
	*/
	private String getPetrinet_1000Text(View view) {
		Petrinet domainModelElement = (Petrinet) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			PetrinetDiagramEditorPlugin.getInstance().logError("No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getPlace_2001Text(View view) {
		IParser parser = PetrinetParserProvider.getParser(PetrinetElementTypes.Place_2001,
				view.getElement() != null ? view.getElement() : view,
				PetrinetVisualIDRegistry.getType(PlaceNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetrinetDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getTransition_2002Text(View view) {
		IParser parser = PetrinetParserProvider.getParser(PetrinetElementTypes.Transition_2002,
				view.getElement() != null ? view.getElement() : view,
				PetrinetVisualIDRegistry.getType(TransitionNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			PetrinetDiagramEditorPlugin.getInstance().logError("Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	* @generated
	*/
	private String getToken_3001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getArc_4001Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	* @generated
	*/
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	* @generated
	*/
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	* @generated
	*/
	public void restoreState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public void saveState(IMemento aMemento) {
	}

	/**
	* @generated
	*/
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	* @generated
	*/
	private boolean isOwnView(View view) {
		return PetrinetEditPart.MODEL_ID.equals(PetrinetVisualIDRegistry.getModelID(view));
	}

}
