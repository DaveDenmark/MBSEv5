/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.pnml.tools.epnk.tutorials.app.technical.impl;

import org.eclipse.emf.ecore.EClass;

import org.pnml.tools.epnk.pnmlcoremodel.impl.PetriNetTypeImpl;

import org.pnml.tools.epnk.tutorials.app.technical.TechnicalNetType;
import org.pnml.tools.epnk.tutorials.app.technical.TechnicalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Net Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TechnicalNetTypeImpl extends PetriNetTypeImpl implements TechnicalNetType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT (made constructor public)
	 * @author ekki@dtu.dk
	 */
	public TechnicalNetTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TechnicalPackage.Literals.TECHNICAL_NET_TYPE;
	}

	/**
	 * The URI of the net type.
	 * 
	 * @generated NOT (needs to return unique URI of this net type)
	 * @author ekki@dtu.dk
	 */
	@Override
	public String toString() {
		return "http://epnk.tools.pnml.org/tutorials/app/technical";
	}

} //TechnicalNetTypeImpl
