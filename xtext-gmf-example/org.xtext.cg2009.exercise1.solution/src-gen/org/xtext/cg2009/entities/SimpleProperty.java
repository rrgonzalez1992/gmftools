/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.cg2009.entities;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xtext.cg2009.entities.SimpleProperty#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xtext.cg2009.entities.EntitiesPackage#getSimpleProperty()
 * @model
 * @generated
 */
public interface SimpleProperty extends Property
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see org.xtext.cg2009.entities.EntitiesPackage#getSimpleProperty_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link org.xtext.cg2009.entities.SimpleProperty#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

} // SimpleProperty
