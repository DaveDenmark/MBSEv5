/**
 */
package dk.dtu.compute.mbse.yawl.impl;

import dk.dtu.compute.mbse.yawl.JoinTransition;
import dk.dtu.compute.mbse.yawl.SplitTransition;
import dk.dtu.compute.mbse.yawl.Transition;
import dk.dtu.compute.mbse.yawl.YawlPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.yawl.impl.TransitionImpl#getSplittransition <em>Splittransition</em>}</li>
 *   <li>{@link dk.dtu.compute.mbse.yawl.impl.TransitionImpl#getJointransition <em>Jointransition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends org.pnml.tools.epnk.pnmlcoremodel.impl.TransitionImpl implements Transition {
	/**
	 * The cached value of the '{@link #getSplittransition() <em>Splittransition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSplittransition()
	 * @generated
	 * @ordered
	 */
	protected SplitTransition splittransition;

	/**
	 * The cached value of the '{@link #getJointransition() <em>Jointransition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJointransition()
	 * @generated
	 * @ordered
	 */
	protected JoinTransition jointransition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return YawlPackage.Literals.TRANSITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SplitTransition getSplittransition() {
		return splittransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSplittransition(SplitTransition newSplittransition, NotificationChain msgs) {
		SplitTransition oldSplittransition = splittransition;
		splittransition = newSplittransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__SPLITTRANSITION, oldSplittransition, newSplittransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSplittransition(SplitTransition newSplittransition) {
		if (newSplittransition != splittransition) {
			NotificationChain msgs = null;
			if (splittransition != null)
				msgs = ((InternalEObject)splittransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__SPLITTRANSITION, null, msgs);
			if (newSplittransition != null)
				msgs = ((InternalEObject)newSplittransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__SPLITTRANSITION, null, msgs);
			msgs = basicSetSplittransition(newSplittransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__SPLITTRANSITION, newSplittransition, newSplittransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinTransition getJointransition() {
		return jointransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJointransition(JoinTransition newJointransition, NotificationChain msgs) {
		JoinTransition oldJointransition = jointransition;
		jointransition = newJointransition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__JOINTRANSITION, oldJointransition, newJointransition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJointransition(JoinTransition newJointransition) {
		if (newJointransition != jointransition) {
			NotificationChain msgs = null;
			if (jointransition != null)
				msgs = ((InternalEObject)jointransition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__JOINTRANSITION, null, msgs);
			if (newJointransition != null)
				msgs = ((InternalEObject)newJointransition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - YawlPackage.TRANSITION__JOINTRANSITION, null, msgs);
			msgs = basicSetJointransition(newJointransition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YawlPackage.TRANSITION__JOINTRANSITION, newJointransition, newJointransition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLITTRANSITION:
				return basicSetSplittransition(null, msgs);
			case YawlPackage.TRANSITION__JOINTRANSITION:
				return basicSetJointransition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLITTRANSITION:
				return getSplittransition();
			case YawlPackage.TRANSITION__JOINTRANSITION:
				return getJointransition();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLITTRANSITION:
				setSplittransition((SplitTransition)newValue);
				return;
			case YawlPackage.TRANSITION__JOINTRANSITION:
				setJointransition((JoinTransition)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLITTRANSITION:
				setSplittransition((SplitTransition)null);
				return;
			case YawlPackage.TRANSITION__JOINTRANSITION:
				setJointransition((JoinTransition)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case YawlPackage.TRANSITION__SPLITTRANSITION:
				return splittransition != null;
			case YawlPackage.TRANSITION__JOINTRANSITION:
				return jointransition != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionImpl
