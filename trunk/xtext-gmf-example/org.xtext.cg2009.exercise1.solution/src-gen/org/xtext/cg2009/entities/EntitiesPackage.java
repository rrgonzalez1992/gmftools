/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.cg2009.entities;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.xtext.cg2009.entities.EntitiesFactory
 * @model kind="package"
 * @generated
 */
public interface EntitiesPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "entities";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.xtext.org/cg2009/Entities";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "entities";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  EntitiesPackage eINSTANCE = org.xtext.cg2009.entities.impl.EntitiesPackageImpl.init();

  /**
   * The meta object id for the '{@link org.xtext.cg2009.entities.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.cg2009.entities.impl.ModelImpl
   * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Entities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ENTITIES = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.cg2009.entities.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.cg2009.entities.impl.EntityImpl
   * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = 0;

  /**
   * The feature id for the '<em><b>Super Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__SUPER_TYPE = 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__PROPERTIES = 2;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.xtext.cg2009.entities.impl.PropertyImpl <em>Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.cg2009.entities.impl.PropertyImpl
   * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getProperty()
   * @generated
   */
  int PROPERTY = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY__NAME = 0;

  /**
   * The number of structural features of the '<em>Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.xtext.cg2009.entities.impl.SimplePropertyImpl <em>Simple Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.cg2009.entities.impl.SimplePropertyImpl
   * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getSimpleProperty()
   * @generated
   */
  int SIMPLE_PROPERTY = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PROPERTY__NAME = PROPERTY__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PROPERTY__TYPE = PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.xtext.cg2009.entities.impl.ReferencePropertyImpl <em>Reference Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.xtext.cg2009.entities.impl.ReferencePropertyImpl
   * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getReferenceProperty()
   * @generated
   */
  int REFERENCE_PROPERTY = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_PROPERTY__NAME = PROPERTY__NAME;

  /**
   * The feature id for the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_PROPERTY__MANY = PROPERTY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_PROPERTY__TYPE = PROPERTY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reference Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.xtext.cg2009.entities.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.xtext.cg2009.entities.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.cg2009.entities.Model#getEntities <em>Entities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entities</em>'.
   * @see org.xtext.cg2009.entities.Model#getEntities()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Entities();

  /**
   * Returns the meta object for class '{@link org.xtext.cg2009.entities.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see org.xtext.cg2009.entities.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.cg2009.entities.Entity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.cg2009.entities.Entity#getName()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Name();

  /**
   * Returns the meta object for the reference '{@link org.xtext.cg2009.entities.Entity#getSuperType <em>Super Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Super Type</em>'.
   * @see org.xtext.cg2009.entities.Entity#getSuperType()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_SuperType();

  /**
   * Returns the meta object for the containment reference list '{@link org.xtext.cg2009.entities.Entity#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.xtext.cg2009.entities.Entity#getProperties()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Properties();

  /**
   * Returns the meta object for class '{@link org.xtext.cg2009.entities.Property <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property</em>'.
   * @see org.xtext.cg2009.entities.Property
   * @generated
   */
  EClass getProperty();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.cg2009.entities.Property#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.xtext.cg2009.entities.Property#getName()
   * @see #getProperty()
   * @generated
   */
  EAttribute getProperty_Name();

  /**
   * Returns the meta object for class '{@link org.xtext.cg2009.entities.SimpleProperty <em>Simple Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Property</em>'.
   * @see org.xtext.cg2009.entities.SimpleProperty
   * @generated
   */
  EClass getSimpleProperty();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.cg2009.entities.SimpleProperty#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.xtext.cg2009.entities.SimpleProperty#getType()
   * @see #getSimpleProperty()
   * @generated
   */
  EAttribute getSimpleProperty_Type();

  /**
   * Returns the meta object for class '{@link org.xtext.cg2009.entities.ReferenceProperty <em>Reference Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Property</em>'.
   * @see org.xtext.cg2009.entities.ReferenceProperty
   * @generated
   */
  EClass getReferenceProperty();

  /**
   * Returns the meta object for the attribute '{@link org.xtext.cg2009.entities.ReferenceProperty#isMany <em>Many</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Many</em>'.
   * @see org.xtext.cg2009.entities.ReferenceProperty#isMany()
   * @see #getReferenceProperty()
   * @generated
   */
  EAttribute getReferenceProperty_Many();

  /**
   * Returns the meta object for the reference '{@link org.xtext.cg2009.entities.ReferenceProperty#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.xtext.cg2009.entities.ReferenceProperty#getType()
   * @see #getReferenceProperty()
   * @generated
   */
  EReference getReferenceProperty_Type();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  EntitiesFactory getEntitiesFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.xtext.cg2009.entities.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.cg2009.entities.impl.ModelImpl
     * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ENTITIES = eINSTANCE.getModel_Entities();

    /**
     * The meta object literal for the '{@link org.xtext.cg2009.entities.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.cg2009.entities.impl.EntityImpl
     * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

    /**
     * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__SUPER_TYPE = eINSTANCE.getEntity_SuperType();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__PROPERTIES = eINSTANCE.getEntity_Properties();

    /**
     * The meta object literal for the '{@link org.xtext.cg2009.entities.impl.PropertyImpl <em>Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.cg2009.entities.impl.PropertyImpl
     * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getProperty()
     * @generated
     */
    EClass PROPERTY = eINSTANCE.getProperty();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

    /**
     * The meta object literal for the '{@link org.xtext.cg2009.entities.impl.SimplePropertyImpl <em>Simple Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.cg2009.entities.impl.SimplePropertyImpl
     * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getSimpleProperty()
     * @generated
     */
    EClass SIMPLE_PROPERTY = eINSTANCE.getSimpleProperty();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_PROPERTY__TYPE = eINSTANCE.getSimpleProperty_Type();

    /**
     * The meta object literal for the '{@link org.xtext.cg2009.entities.impl.ReferencePropertyImpl <em>Reference Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.xtext.cg2009.entities.impl.ReferencePropertyImpl
     * @see org.xtext.cg2009.entities.impl.EntitiesPackageImpl#getReferenceProperty()
     * @generated
     */
    EClass REFERENCE_PROPERTY = eINSTANCE.getReferenceProperty();

    /**
     * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REFERENCE_PROPERTY__MANY = eINSTANCE.getReferenceProperty_Many();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_PROPERTY__TYPE = eINSTANCE.getReferenceProperty_Type();

  }

} //EntitiesPackage
