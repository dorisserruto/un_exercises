/**
 * SucursalesSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.mybanca.www.Sucursales;

import org.mybanca.www.Server.*;

public class SucursalesSOAPImpl implements org.mybanca.www.Sucursales.Sucursales_PortType{
    
	Banco bancoEjemplo = new Banco("Banco del Ejemplo");
	
	
	public boolean crearCliente(java.lang.String codCliente, java.lang.String nombreCliente, java.lang.String apellidoPCliente, java.lang.String apellidoMCliente, java.lang.String codSucursal) throws java.rmi.RemoteException {
		
		boolean resultadoCreacion = false;
		ClienteBancario nuevoCliente = new ClienteBancario(codCliente,nombreCliente, apellidoPCliente, apellidoMCliente);
    	
		resultadoCreacion = bancoEjemplo.anhadirCliente(nuevoCliente);
		
		if (resultadoCreacion == true)
		{
			return true; 
		}
    	return false;
    }

    public java.lang.String consultarCliente(java.lang.String codCliente) throws java.rmi.RemoteException {
        
    	String resNroCliente = null;
    	String resNombreCliente = null;
    	String resAPaternoCliente = null;
    	String resAMaternoCliente = null;
    	
    	String cadenaRespuesta = null;
    	
    	ClienteBancario resultadoCliente= new ClienteBancario();
    	
    	resultadoCliente = bancoEjemplo.obtenerCliente(codCliente);
    	
    	if (resultadoCliente != null)
    	{
    		resNroCliente = resultadoCliente.getNroCliente();
    		resNombreCliente = resultadoCliente.getNombre();
    		resAPaternoCliente = resultadoCliente.getApellidop();
    		resAMaternoCliente = resultadoCliente.getApellidom();
    		
    		cadenaRespuesta = "Nro. de Cliente: "+ resNroCliente + "- El nombre del cliente es: "+resAPaternoCliente+" "+resAMaternoCliente+","+ resNombreCliente;
    	}
    
    	//System.out.println("El codigo de cliente recibido es: "+ codCliente);
    	return cadenaRespuesta;
    }

}
