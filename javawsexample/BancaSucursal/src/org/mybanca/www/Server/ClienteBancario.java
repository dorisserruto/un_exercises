package org.mybanca.www.Server;

import java.util.HashMap;

public class ClienteBancario {

	private String nroCliente;
	private String nombre;
	private String apellidop;
	private String apellidom;
	
	private HashMap<String, CuentaBancaria> cuentas;
	
	
	public ClienteBancario(String nroCliente, String nombre, String apellidop, String apellidom)
	{
		this.setNroCliente(nroCliente);
		this.setNombre(nombre);
		this.setApellidop(apellidop);
		this.setApellidom(apellidom);
	}

	public ClienteBancario() {
		this.setNroCliente(null);
		this.setNroCliente(null);
		this.setApellidop(null);
		this.setApellidom(null);
	}

	public String getNroCliente() {
		return nroCliente;
	}


	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidop() {
		return apellidop;
	}


	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}


	public String getApellidom() {
		return apellidom;
	}


	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}
	
	
	public boolean anhadirCuenta(CuentaBancaria cuenta)
	{
		if (cuenta != null)
		{
			cuentas.put(cuenta.getNroCuenta(), cuenta);
			return true;
		}
		return false;
	}
	
	public CuentaBancaria obtenerCuenta(String nrocuenta)
	{
		return cuentas.get(nrocuenta);
	}
}

