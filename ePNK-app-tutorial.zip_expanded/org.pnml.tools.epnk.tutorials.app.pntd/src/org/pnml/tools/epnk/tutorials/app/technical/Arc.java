/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.pnml.tools.epnk.tutorials.app.technical;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.technical.Arc#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends org.pnml.tools.epnk.pnmlcoremodel.Arc {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(ArcTypeAttribute)
	 * @see org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage#getArc_Type()
	 * @model containment="true"
	 * @generated
	 */
	ArcTypeAttribute getType();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.technical.Arc#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ArcTypeAttribute value);

} // Arc
