/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.pnml.tools.epnk.tutorials.app.technical;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.technical.Place#getMarking <em>Marking</em>}</li>
 * </ul>
 *
 * @see org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends org.pnml.tools.epnk.pnmlcoremodel.Place {
	/**
	 * Returns the value of the '<em><b>Marking</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Marking</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Marking</em>' containment reference.
	 * @see #setMarking(MarkingLabel)
	 * @see org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage#getPlace_Marking()
	 * @model containment="true"
	 * @generated
	 */
	MarkingLabel getMarking();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.technical.Place#getMarking <em>Marking</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Marking</em>' containment reference.
	 * @see #getMarking()
	 * @generated
	 */
	void setMarking(MarkingLabel value);

} // Place
