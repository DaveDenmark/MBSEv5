/**
 */
package org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.pnml.tools.epnk.annotations.netannotations.NetannotationsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsFactory
 * @model kind="package"
 * @generated
 */
public interface TechsimannotationsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "techsimannotations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://epnk.tools.pnml.org/tutorials/app/technialc/simanno";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tsanno";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TechsimannotationsPackage eINSTANCE = org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.TechsimannotationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.MarkingImpl <em>Marking</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.MarkingImpl
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.TechsimannotationsPackageImpl#getMarking()
	 * @generated
	 */
	int MARKING = 0;

	/**
	 * The feature id for the '<em><b>Net Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__NET_ANNOTATIONS = NetannotationsPackage.OBJECT_ANNOTATION__NET_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__OBJECT = NetannotationsPackage.OBJECT_ANNOTATION__OBJECT;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__VALUE = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Marking</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING_FEATURE_COUNT = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.EnabledTransitionImpl <em>Enabled Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.EnabledTransitionImpl
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.TechsimannotationsPackageImpl#getEnabledTransition()
	 * @generated
	 */
	int ENABLED_TRANSITION = 1;

	/**
	 * The feature id for the '<em><b>Net Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITION__NET_ANNOTATIONS = NetannotationsPackage.OBJECT_ANNOTATION__NET_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITION__OBJECT = NetannotationsPackage.OBJECT_ANNOTATION__OBJECT;

	/**
	 * The feature id for the '<em><b>In</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITION__IN = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITION__OUT = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resolve</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITION__RESOLVE = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITION__ENABLED = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITION__REFS = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Enabled Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_TRANSITION_FEATURE_COUNT = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.InvolvedArcImpl <em>Involved Arc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.InvolvedArcImpl
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.TechsimannotationsPackageImpl#getInvolvedArc()
	 * @generated
	 */
	int INVOLVED_ARC = 2;

	/**
	 * The feature id for the '<em><b>Net Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOLVED_ARC__NET_ANNOTATIONS = NetannotationsPackage.OBJECT_ANNOTATION__NET_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOLVED_ARC__OBJECT = NetannotationsPackage.OBJECT_ANNOTATION__OBJECT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOLVED_ARC__TARGET = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOLVED_ARC__SOURCE = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOLVED_ARC__ACTIVE = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Involved Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOLVED_ARC_FEATURE_COUNT = NetannotationsPackage.OBJECT_ANNOTATION_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.Marking <em>Marking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Marking</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.Marking
	 * @generated
	 */
	EClass getMarking();

	/**
	 * Returns the meta object for the attribute '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.Marking#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.Marking#getValue()
	 * @see #getMarking()
	 * @generated
	 */
	EAttribute getMarking_Value();

	/**
	 * Returns the meta object for class '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition <em>Enabled Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enabled Transition</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition
	 * @generated
	 */
	EClass getEnabledTransition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getIn <em>In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>In</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getIn()
	 * @see #getEnabledTransition()
	 * @generated
	 */
	EReference getEnabledTransition_In();

	/**
	 * Returns the meta object for the containment reference list '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getOut <em>Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Out</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getOut()
	 * @see #getEnabledTransition()
	 * @generated
	 */
	EReference getEnabledTransition_Out();

	/**
	 * Returns the meta object for the reference '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getResolve <em>Resolve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resolve</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getResolve()
	 * @see #getEnabledTransition()
	 * @generated
	 */
	EReference getEnabledTransition_Resolve();

	/**
	 * Returns the meta object for the attribute '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#isEnabled()
	 * @see #getEnabledTransition()
	 * @generated
	 */
	EAttribute getEnabledTransition_Enabled();

	/**
	 * Returns the meta object for the reference list '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refs</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition#getRefs()
	 * @see #getEnabledTransition()
	 * @generated
	 */
	EReference getEnabledTransition_Refs();

	/**
	 * Returns the meta object for class '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc <em>Involved Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Involved Arc</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc
	 * @generated
	 */
	EClass getInvolvedArc();

	/**
	 * Returns the meta object for the container reference '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Target</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getTarget()
	 * @see #getInvolvedArc()
	 * @generated
	 */
	EReference getInvolvedArc_Target();

	/**
	 * Returns the meta object for the container reference '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#getSource()
	 * @see #getInvolvedArc()
	 * @generated
	 */
	EReference getInvolvedArc_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc#isActive()
	 * @see #getInvolvedArc()
	 * @generated
	 */
	EAttribute getInvolvedArc_Active();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TechsimannotationsFactory getTechsimannotationsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.MarkingImpl <em>Marking</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.MarkingImpl
		 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.TechsimannotationsPackageImpl#getMarking()
		 * @generated
		 */
		EClass MARKING = eINSTANCE.getMarking();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MARKING__VALUE = eINSTANCE.getMarking_Value();

		/**
		 * The meta object literal for the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.EnabledTransitionImpl <em>Enabled Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.EnabledTransitionImpl
		 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.TechsimannotationsPackageImpl#getEnabledTransition()
		 * @generated
		 */
		EClass ENABLED_TRANSITION = eINSTANCE.getEnabledTransition();

		/**
		 * The meta object literal for the '<em><b>In</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENABLED_TRANSITION__IN = eINSTANCE.getEnabledTransition_In();

		/**
		 * The meta object literal for the '<em><b>Out</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENABLED_TRANSITION__OUT = eINSTANCE.getEnabledTransition_Out();

		/**
		 * The meta object literal for the '<em><b>Resolve</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENABLED_TRANSITION__RESOLVE = eINSTANCE.getEnabledTransition_Resolve();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENABLED_TRANSITION__ENABLED = eINSTANCE.getEnabledTransition_Enabled();

		/**
		 * The meta object literal for the '<em><b>Refs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENABLED_TRANSITION__REFS = eINSTANCE.getEnabledTransition_Refs();

		/**
		 * The meta object literal for the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.InvolvedArcImpl <em>Involved Arc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.InvolvedArcImpl
		 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.TechsimannotationsPackageImpl#getInvolvedArc()
		 * @generated
		 */
		EClass INVOLVED_ARC = eINSTANCE.getInvolvedArc();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOLVED_ARC__TARGET = eINSTANCE.getInvolvedArc_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INVOLVED_ARC__SOURCE = eINSTANCE.getInvolvedArc_Source();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INVOLVED_ARC__ACTIVE = eINSTANCE.getInvolvedArc_Active();

	}

} //TechsimannotationsPackage
