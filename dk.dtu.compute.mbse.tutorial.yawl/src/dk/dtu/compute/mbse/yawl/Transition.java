/**
 */
package dk.dtu.compute.mbse.yawl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Transition#getSplittransition <em>Splittransition</em>}</li>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Transition#getJointransition <em>Jointransition</em>}</li>
 * </ul>
 *
 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends org.pnml.tools.epnk.pnmlcoremodel.Transition {
	/**
	 * Returns the value of the '<em><b>Splittransition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Splittransition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Splittransition</em>' containment reference.
	 * @see #setSplittransition(SplitTransition)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition_Splittransition()
	 * @model containment="true"
	 * @generated
	 */
	SplitTransition getSplittransition();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Transition#getSplittransition <em>Splittransition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Splittransition</em>' containment reference.
	 * @see #getSplittransition()
	 * @generated
	 */
	void setSplittransition(SplitTransition value);

	/**
	 * Returns the value of the '<em><b>Jointransition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jointransition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jointransition</em>' containment reference.
	 * @see #setJointransition(JoinTransition)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getTransition_Jointransition()
	 * @model containment="true"
	 * @generated
	 */
	JoinTransition getJointransition();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Transition#getJointransition <em>Jointransition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jointransition</em>' containment reference.
	 * @see #getJointransition()
	 * @generated
	 */
	void setJointransition(JoinTransition value);

} // Transition
