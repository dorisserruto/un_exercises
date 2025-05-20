/**
 * Sucursales_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.mybanca.www.Sucursales;

public interface Sucursales_PortType extends java.rmi.Remote {
    public boolean crearCliente(java.lang.String codCliente, java.lang.String nombreCliente, java.lang.String apellidoPCliente, java.lang.String apellidoMCliente, java.lang.String codSucursal) throws java.rmi.RemoteException;
    public java.lang.String consultarCliente(java.lang.String codCliente) throws java.rmi.RemoteException;
}
