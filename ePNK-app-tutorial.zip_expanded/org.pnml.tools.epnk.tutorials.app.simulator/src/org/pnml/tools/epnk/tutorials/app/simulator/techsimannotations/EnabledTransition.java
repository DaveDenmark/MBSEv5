/**
 */
package org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations;

import org.eclipse.emf.common.util.EList;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enabled Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getIn <em>In</em>}</li>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getOut <em>Out</em>}</li>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getResolve <em>Resolve</em>}</li>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getRefs <em>Refs</em>}</li>
 * </ul>
 *
 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getEnabledTransition()
 * @model
 * @generated
 */
public interface EnabledTransition extends ObjectAnnotation {
	/**
	 * Returns the value of the '<em><b>In</b></em>' containment reference list.
	 * The list contents are of type {@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc}.
	 * It is bidirectional and its opposite is '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In</em>' containment reference list.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getEnabledTransition_In()
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getTarget
	 * @model opposite="target" containment="true"
	 * @generated
	 */
	EList<InvolvedArc> getIn();

	/**
	 * Returns the value of the '<em><b>Out</b></em>' containment reference list.
	 * The list contents are of type {@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc}.
	 * It is bidirectional and its opposite is '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out</em>' containment reference list.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getEnabledTransition_Out()
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<InvolvedArc> getOut();

	/**
	 * Returns the value of the '<em><b>Resolve</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resolve</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolve</em>' reference.
	 * @see #setResolve(EnabledTransition)
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getEnabledTransition_Resolve()
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getRefs
	 * @model opposite="refs"
	 * @generated
	 */
	EnabledTransition getResolve();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getResolve <em>Resolve</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resolve</em>' reference.
	 * @see #getResolve()
	 * @generated
	 */
	void setResolve(EnabledTransition value);

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getEnabledTransition_Enabled()
	 * @model required="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

	/**
	 * Returns the value of the '<em><b>Refs</b></em>' reference list.
	 * The list contents are of type {@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition}.
	 * It is bidirectional and its opposite is '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getResolve <em>Resolve</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refs</em>' reference list.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getEnabledTransition_Refs()
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getResolve
	 * @model opposite="resolve"
	 * @generated
	 */
	EList<EnabledTransition> getRefs();

} // EnabledTransition
