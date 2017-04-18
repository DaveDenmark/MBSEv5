/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.pnml.tools.epnk.tutorials.app.technical;

import org.pnml.tools.epnk.pnmlcoremodel.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc Type Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.technical.ArcTypeAttribute#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage#getArcTypeAttribute()
 * @model
 * @generated
 */
public interface ArcTypeAttribute extends Attribute {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * The literals are from the enumeration {@link org.pnml.tools.epnk.tutorials.app.technical.ArcType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see org.pnml.tools.epnk.tutorials.app.technical.ArcType
	 * @see #setText(ArcType)
	 * @see org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage#getArcTypeAttribute_Text()
	 * @model
	 * @generated
	 */
	ArcType getText();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.technical.ArcTypeAttribute#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see org.pnml.tools.epnk.tutorials.app.technical.ArcType
	 * @see #getText()
	 * @generated
	 */
	void setText(ArcType value);

} // ArcTypeAttribute
