/**
 */
package org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage
 * @generated
 */
public interface TechsimannotationsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TechsimannotationsFactory eINSTANCE = org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.TechsimannotationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Marking</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Marking</em>'.
	 * @generated
	 */
	Marking createMarking();

	/**
	 * Returns a new object of class '<em>Enabled Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enabled Transition</em>'.
	 * @generated
	 */
	EnabledTransition createEnabledTransition();

	/**
	 * Returns a new object of class '<em>Involved Arc</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Involved Arc</em>'.
	 * @generated
	 */
	InvolvedArc createInvolvedArc();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TechsimannotationsPackage getTechsimannotationsPackage();

} //TechsimannotationsFactory
