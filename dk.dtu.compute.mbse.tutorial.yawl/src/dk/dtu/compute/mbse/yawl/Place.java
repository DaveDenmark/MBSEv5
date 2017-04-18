/**
 */
package dk.dtu.compute.mbse.yawl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Place</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dk.dtu.compute.mbse.yawl.Place#getPlacetype <em>Placetype</em>}</li>
 * </ul>
 *
 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getPlace()
 * @model
 * @generated
 */
public interface Place extends org.pnml.tools.epnk.pnmlcoremodel.Place {
	/**
	 * Returns the value of the '<em><b>Placetype</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Placetype</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Placetype</em>' containment reference.
	 * @see #setPlacetype(PlaceType)
	 * @see dk.dtu.compute.mbse.yawl.YawlPackage#getPlace_Placetype()
	 * @model containment="true"
	 * @generated
	 */
	PlaceType getPlacetype();

	/**
	 * Sets the value of the '{@link dk.dtu.compute.mbse.yawl.Place#getPlacetype <em>Placetype</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Placetype</em>' containment reference.
	 * @see #getPlacetype()
	 * @generated
	 */
	void setPlacetype(PlaceType value);

} // Place
