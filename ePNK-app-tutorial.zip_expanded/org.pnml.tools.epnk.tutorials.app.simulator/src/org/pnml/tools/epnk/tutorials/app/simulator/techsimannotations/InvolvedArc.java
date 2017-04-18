/**
 */
package org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Involved Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getTarget <em>Target</em>}</li>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getSource <em>Source</em>}</li>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#isActive <em>Active</em>}</li>
 * </ul>
 *
 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getInvolvedArc()
 * @model
 * @generated
 */
public interface InvolvedArc extends ObjectAnnotation {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' container reference.
	 * @see #setTarget(EnabledTransition)
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getInvolvedArc_Target()
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getIn
	 * @model opposite="in" transient="false"
	 * @generated
	 */
	EnabledTransition getTarget();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getTarget <em>Target</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' container reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(EnabledTransition value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(EnabledTransition)
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getInvolvedArc_Source()
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getOut
	 * @model opposite="out" transient="false"
	 * @generated
	 */
	EnabledTransition getSource();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(EnabledTransition value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getInvolvedArc_Active()
	 * @model required="true"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

} // InvolvedArc
