/**
 */
package dk.dtu.compute.mbse.petrinet;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.petrinet.Arc#getSource <em>Source</em>}</li>
 *   <li>{@link dk.dtu.compute.mbse.petrinet.Arc#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see dk.dtu.compute.mbse.petrinet.PetrinetPackage#getArc()
 * @model
 * @generated
 */
public interface Arc extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link dk.dtu.compute.mbse.petrinet.Node#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Node)
	 * @see dk.dtu.compute.mbse.petrinet.PetrinetPackage#getArc_Source()
	 * @see dk.dtu.compute.mbse.petrinet.Node#getOut
	 * @model opposite="out" required="true"
	 * @generated
	 */
	Node getSource();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.petrinet.Arc#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Node value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link dk.dtu.compute.mbse.petrinet.Node#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Node)
	 * @see dk.dtu.compute.mbse.petrinet.PetrinetPackage#getArc_Target()
	 * @see dk.dtu.compute.mbse.petrinet.Node#getIn
	 * @model opposite="in" required="true"
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.petrinet.Arc#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

} // Arc
