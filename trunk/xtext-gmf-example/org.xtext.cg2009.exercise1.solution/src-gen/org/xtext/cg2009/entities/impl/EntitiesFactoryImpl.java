/**
 * <copyright>
 * </copyright>
 *
 */
package org.xtext.cg2009.entities.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.xtext.cg2009.entities.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EntitiesFactoryImpl extends EFactoryImpl implements EntitiesFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static EntitiesFactory init()
  {
    try
    {
      EntitiesFactory theEntitiesFactory = (EntitiesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.xtext.org/cg2009/Entities"); 
      if (theEntitiesFactory != null)
      {
        return theEntitiesFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new EntitiesFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntitiesFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case EntitiesPackage.MODEL: return createModel();
      case EntitiesPackage.ENTITY: return createEntity();
      case EntitiesPackage.PROPERTY: return createProperty();
      case EntitiesPackage.SIMPLE_PROPERTY: return createSimpleProperty();
      case EntitiesPackage.REFERENCE_PROPERTY: return createReferenceProperty();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity createEntity()
  {
    EntityImpl entity = new EntityImpl();
    return entity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Property createProperty()
  {
    PropertyImpl property = new PropertyImpl();
    return property;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SimpleProperty createSimpleProperty()
  {
    SimplePropertyImpl simpleProperty = new SimplePropertyImpl();
    return simpleProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReferenceProperty createReferenceProperty()
  {
    ReferencePropertyImpl referenceProperty = new ReferencePropertyImpl();
    return referenceProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EntitiesPackage getEntitiesPackage()
  {
    return (EntitiesPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static EntitiesPackage getPackage()
  {
    return EntitiesPackage.eINSTANCE;
  }

} //EntitiesFactoryImpl
