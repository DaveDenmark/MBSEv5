/**
 */
package org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations;

import org.pnml.tools.epnk.annotations.netannotations.ObjectAnnotation;
import org.pnml.tools.epnk.annotations.netannotations.TextualAnnotation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Marking</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.Marking#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getMarking()
 * @model
 * @generated
 */
public interface Marking extends ObjectAnnotation, TextualAnnotation {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.TechsimannotationsPackage#getMarking_Value()
	 * @model
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link org.pnml.tools.epnk.tutorials.app.simulator.techsimannotations.Marking#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

} // Marking
