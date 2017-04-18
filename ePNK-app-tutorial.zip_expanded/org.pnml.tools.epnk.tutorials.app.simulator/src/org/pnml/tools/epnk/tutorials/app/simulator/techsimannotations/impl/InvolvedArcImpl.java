/**
 */
package org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.pnml.tools.epnk.annotations.netannotations.impl.ObjectAnnotationImpl;

import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.EnabledTransition;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.InvolvedArc;
import org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Involved Arc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.InvolvedArcImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.InvolvedArcImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.impl.InvolvedArcImpl#isActive <em>Active</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InvolvedArcImpl extends ObjectAnnotationImpl implements InvolvedArc {
	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvolvedArcImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TechsimannotationsPackage.Literals.INVOLVED_ARC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransition getTarget() {
		if (eContainerFeatureID() != TechsimannotationsPackage.INVOLVED_ARC__TARGET) return null;
		return (EnabledTransition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(EnabledTransition newTarget, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTarget, TechsimannotationsPackage.INVOLVED_ARC__TARGET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(EnabledTransition newTarget) {
		if (newTarget != eInternalContainer() || (eContainerFeatureID() != TechsimannotationsPackage.INVOLVED_ARC__TARGET && newTarget != null)) {
			if (EcoreUtil.isAncestor(this, newTarget))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, TechsimannotationsPackage.ENABLED_TRANSITION__IN, EnabledTransition.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TechsimannotationsPackage.INVOLVED_ARC__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnabledTransition getSource() {
		if (eContainerFeatureID() != TechsimannotationsPackage.INVOLVED_ARC__SOURCE) return null;
		return (EnabledTransition)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(EnabledTransition newSource, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSource, TechsimannotationsPackage.INVOLVED_ARC__SOURCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(EnabledTransition newSource) {
		if (newSource != eInternalContainer() || (eContainerFeatureID() != TechsimannotationsPackage.INVOLVED_ARC__SOURCE && newSource != null)) {
			if (EcoreUtil.isAncestor(this, newSource))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, TechsimannotationsPackage.ENABLED_TRANSITION__OUT, EnabledTransition.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TechsimannotationsPackage.INVOLVED_ARC__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TechsimannotationsPackage.INVOLVED_ARC__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TechsimannotationsPackage.INVOLVED_ARC__TARGET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTarget((EnabledTransition)otherEnd, msgs);
			case TechsimannotationsPackage.INVOLVED_ARC__SOURCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSource((EnabledTransition)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TechsimannotationsPackage.INVOLVED_ARC__TARGET:
				return basicSetTarget(null, msgs);
			case TechsimannotationsPackage.INVOLVED_ARC__SOURCE:
				return basicSetSource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case TechsimannotationsPackage.INVOLVED_ARC__TARGET:
				return eInternalContainer().eInverseRemove(this, TechsimannotationsPackage.ENABLED_TRANSITION__IN, EnabledTransition.class, msgs);
			case TechsimannotationsPackage.INVOLVED_ARC__SOURCE:
				return eInternalContainer().eInverseRemove(this, TechsimannotationsPackage.ENABLED_TRANSITION__OUT, EnabledTransition.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TechsimannotationsPackage.INVOLVED_ARC__TARGET:
				return getTarget();
			case TechsimannotationsPackage.INVOLVED_ARC__SOURCE:
				return getSource();
			case TechsimannotationsPackage.INVOLVED_ARC__ACTIVE:
				return isActive();
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
			case TechsimannotationsPackage.INVOLVED_ARC__TARGET:
				setTarget((EnabledTransition)newValue);
				return;
			case TechsimannotationsPackage.INVOLVED_ARC__SOURCE:
				setSource((EnabledTransition)newValue);
				return;
			case TechsimannotationsPackage.INVOLVED_ARC__ACTIVE:
				setActive((Boolean)newValue);
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
			case TechsimannotationsPackage.INVOLVED_ARC__TARGET:
				setTarget((EnabledTransition)null);
				return;
			case TechsimannotationsPackage.INVOLVED_ARC__SOURCE:
				setSource((EnabledTransition)null);
				return;
			case TechsimannotationsPackage.INVOLVED_ARC__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
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
			case TechsimannotationsPackage.INVOLVED_ARC__TARGET:
				return getTarget() != null;
			case TechsimannotationsPackage.INVOLVED_ARC__SOURCE:
				return getSource() != null;
			case TechsimannotationsPackage.INVOLVED_ARC__ACTIVE:
				return active != ACTIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //InvolvedArcImpl
