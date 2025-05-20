package org.mybanca.www.Sucursales;

public class SucursalesProxy implements org.mybanca.www.Sucursales.Sucursales_PortType {
  private String _endpoint = null;
  private org.mybanca.www.Sucursales.Sucursales_PortType sucursales_PortType = null;
  
  public SucursalesProxy() {
    _initSucursalesProxy();
  }
  
  public SucursalesProxy(String endpoint) {
    _endpoint = endpoint;
    _initSucursalesProxy();
  }
  
  private void _initSucursalesProxy() {
    try {
      sucursales_PortType = (new org.mybanca.www.Sucursales.Sucursales_ServiceLocator()).getSucursalesSOAP();
      if (sucursales_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sucursales_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sucursales_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sucursales_PortType != null)
      ((javax.xml.rpc.Stub)sucursales_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.mybanca.www.Sucursales.Sucursales_PortType getSucursales_PortType() {
    if (sucursales_PortType == null)
      _initSucursalesProxy();
    return sucursales_PortType;
  }
  
  public boolean crearCliente(java.lang.String codCliente, java.lang.String nombreCliente, java.lang.String apellidoPCliente, java.lang.String apellidoMCliente, java.lang.String codSucursal) throws java.rmi.RemoteException{
    if (sucursales_PortType == null)
      _initSucursalesProxy();
    return sucursales_PortType.crearCliente(codCliente, nombreCliente, apellidoPCliente, apellidoMCliente, codSucursal);
  }
  
  public java.lang.String consultarCliente(java.lang.String codCliente) throws java.rmi.RemoteException{
    if (sucursales_PortType == null)
      _initSucursalesProxy();
    return sucursales_PortType.consultarCliente(codCliente);
  }
  
  
}