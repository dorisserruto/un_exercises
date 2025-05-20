package com.tcs.www;

public class ContratoProxy implements com.tcs.www.Contrato_PortType {
  private String _endpoint = null;
  private com.tcs.www.Contrato_PortType contrato_PortType = null;
  
  public ContratoProxy() {
    _initContratoProxy();
  }
  
  public ContratoProxy(String endpoint) {
    _endpoint = endpoint;
    _initContratoProxy();
  }
  
  private void _initContratoProxy() {
    try {
      contrato_PortType = (new com.tcs.www.Contrato_ServiceLocator()).getContratoSOAP();
      if (contrato_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)contrato_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)contrato_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (contrato_PortType != null)
      ((javax.xml.rpc.Stub)contrato_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.tcs.www.Contrato_PortType getContrato_PortType() {
    if (contrato_PortType == null)
      _initContratoProxy();
    return contrato_PortType;
  }
  
  public java.lang.String newOperation(java.lang.String in) throws java.rmi.RemoteException{
    if (contrato_PortType == null)
      _initContratoProxy();
    return contrato_PortType.newOperation(in);
  }
  
  
}