/**
 */
package org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TechsimannotationsFactoryImpl extends EFactoryImpl implements TechsimannotationsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TechsimannotationsFactory init() {
		try {
			TechsimannotationsFactory theTechsimannotationsFactory = (TechsimannotationsFactory)EPackage.Registry.INSTANCE.getEFactory(TechsimannotationsPackage.eNS_URI);
			if (theTechsimannotationsFactory != null) {
				return theTechsimannotationsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TechsimannotationsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechsimannotationsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TechsimannotationsPackage.MARKING: return createMarking();
			case TechsimannotationsPackage.ENABLED_TRANSITION: return createEnabledTransition();
			case TechsimannotationsPackage.INVOLVED_ARC: return createInvolvedArc();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Marking createMarking() {
		MarkingImpl marking = new MarkingImpl();
		return marking;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransition createEnabledTransition() {
		EnabledTransitionImpl enabledTransition = new EnabledTransitionImpl();
		return enabledTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvolvedArc createInvolvedArc() {
		InvolvedArcImpl involvedArc = new InvolvedArcImpl();
		return involvedArc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TechsimannotationsPackage getTechsimannotationsPackage() {
		return (TechsimannotationsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TechsimannotationsPackage getPackage() {
		return TechsimannotationsPackage.eINSTANCE;
	}

} //TechsimannotationsFactoryImpl
