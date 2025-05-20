/**
 * Sucursales_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.mybanca.www.Sucursales;

public class Sucursales_ServiceLocator extends org.apache.axis.client.Service implements org.mybanca.www.Sucursales.Sucursales_Service {

    public Sucursales_ServiceLocator() {
    }


    public Sucursales_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Sucursales_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SucursalesSOAP
    private java.lang.String SucursalesSOAP_address = "http://localhost:8085/BancaSucursal/services/SucursalesSOAP";

    public java.lang.String getSucursalesSOAPAddress() {
        return SucursalesSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SucursalesSOAPWSDDServiceName = "SucursalesSOAP";

    public java.lang.String getSucursalesSOAPWSDDServiceName() {
        return SucursalesSOAPWSDDServiceName;
    }

    public void setSucursalesSOAPWSDDServiceName(java.lang.String name) {
        SucursalesSOAPWSDDServiceName = name;
    }

    public org.mybanca.www.Sucursales.Sucursales_PortType getSucursalesSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SucursalesSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSucursalesSOAP(endpoint);
    }

    public org.mybanca.www.Sucursales.Sucursales_PortType getSucursalesSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.mybanca.www.Sucursales.SucursalesSOAPStub _stub = new org.mybanca.www.Sucursales.SucursalesSOAPStub(portAddress, this);
            _stub.setPortName(getSucursalesSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSucursalesSOAPEndpointAddress(java.lang.String address) {
        SucursalesSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.mybanca.www.Sucursales.Sucursales_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.mybanca.www.Sucursales.SucursalesSOAPStub _stub = new org.mybanca.www.Sucursales.SucursalesSOAPStub(new java.net.URL(SucursalesSOAP_address), this);
                _stub.setPortName(getSucursalesSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SucursalesSOAP".equals(inputPortName)) {
            return getSucursalesSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "Sucursales");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.mybanca.org/Sucursales/", "SucursalesSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SucursalesSOAP".equals(portName)) {
            setSucursalesSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
