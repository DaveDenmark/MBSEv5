/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.pnml.tools.epnk.tutorials.app.technical;

import org.pnml.tools.epnk.datatypes.pnmldatatypes.NonNegativeInteger;

import org.pnml.tools.epnk.pnmlcoremodel.Label;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Marking Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.technical.MarkingLabel#getText <em>Text</em>}</li>
 * </ul>
 *
 * @see org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage#getMarkingLabel()
 * @model
 * @generated
 */
public interface MarkingLabel extends Label {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(NonNegativeInteger)
	 * @see org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage#getMarkingLabel_Text()
	 * @model dataType="org.pnml.tools.epnk.datatypes.pnmldatatypes.NonNegativeInteger"
	 * @generated
	 */
	NonNegativeInteger getText();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.technical.MarkingLabel#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(NonNegativeInteger value);

} // MarkingLabel
