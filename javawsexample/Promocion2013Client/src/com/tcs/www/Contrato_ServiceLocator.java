/**
 * Contrato_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.tcs.www;

public class Contrato_ServiceLocator extends org.apache.axis.client.Service implements com.tcs.www.Contrato_Service {

    public Contrato_ServiceLocator() {
    }


    public Contrato_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Contrato_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContratoSOAP
    private java.lang.String ContratoSOAP_address = "http://localhost:8090/Promocion2013/services/ContratoSOAP";

    public java.lang.String getContratoSOAPAddress() {
        return ContratoSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContratoSOAPWSDDServiceName = "ContratoSOAP";

    public java.lang.String getContratoSOAPWSDDServiceName() {
        return ContratoSOAPWSDDServiceName;
    }

    public void setContratoSOAPWSDDServiceName(java.lang.String name) {
        ContratoSOAPWSDDServiceName = name;
    }

    public com.tcs.www.Contrato_PortType getContratoSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContratoSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContratoSOAP(endpoint);
    }

    public com.tcs.www.Contrato_PortType getContratoSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.tcs.www.ContratoSOAPSoapBindingStub _stub = new com.tcs.www.ContratoSOAPSoapBindingStub(portAddress, this);
            _stub.setPortName(getContratoSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContratoSOAPEndpointAddress(java.lang.String address) {
        ContratoSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.tcs.www.Contrato_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.tcs.www.ContratoSOAPSoapBindingStub _stub = new com.tcs.www.ContratoSOAPSoapBindingStub(new java.net.URL(ContratoSOAP_address), this);
                _stub.setPortName(getContratoSOAPWSDDServiceName());
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
        if ("ContratoSOAP".equals(inputPortName)) {
            return getContratoSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.tcs.com", "Contrato");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.tcs.com", "ContratoSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContratoSOAP".equals(portName)) {
            setContratoSOAPEndpointAddress(address);
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
