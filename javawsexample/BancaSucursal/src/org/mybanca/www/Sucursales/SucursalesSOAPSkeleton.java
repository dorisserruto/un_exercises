/**
 * SucursalesSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.mybanca.www.Sucursales;

public class SucursalesSOAPSkeleton implements org.mybanca.www.Sucursales.Sucursales_PortType, org.apache.axis.wsdl.Skeleton {
    private org.mybanca.www.Sucursales.Sucursales_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "codCliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "nombreCliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "apellidoPCliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "apellidoMCliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "codSucursal"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("crearCliente", _params, new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "creacionOK"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "crearCliente"));
        _oper.setSoapAction("http://www.mybanca.org/Sucursales/crearCliente");
        _myOperationsList.add(_oper);
        if (_myOperations.get("crearCliente") == null) {
            _myOperations.put("crearCliente", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("crearCliente")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "codCliente"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("consultarCliente", _params, new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "nombreCliente"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "consultarCliente"));
        _oper.setSoapAction("http://www.mybanca.org/Sucursales/consultarCliente");
        _myOperationsList.add(_oper);
        if (_myOperations.get("consultarCliente") == null) {
            _myOperations.put("consultarCliente", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("consultarCliente")).add(_oper);
    }

    public SucursalesSOAPSkeleton() {
        this.impl = new org.mybanca.www.Sucursales.SucursalesSOAPImpl();
    }

    public SucursalesSOAPSkeleton(org.mybanca.www.Sucursales.Sucursales_PortType impl) {
        this.impl = impl;
    }
    public boolean crearCliente(java.lang.String codCliente, java.lang.String nombreCliente, java.lang.String apellidoPCliente, java.lang.String apellidoMCliente, java.lang.String codSucursal) throws java.rmi.RemoteException
    {
        boolean ret = impl.crearCliente(codCliente, nombreCliente, apellidoPCliente, apellidoMCliente, codSucursal);
        return ret;
    }

    public java.lang.String consultarCliente(java.lang.String codCliente) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.consultarCliente(codCliente);
        return ret;
    }

}
