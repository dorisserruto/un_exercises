package org.mybanca.www.Server;

import java.util.HashMap;

public class Banco {
	
	private String nombre;
	private HashMap<String, ClienteBancario> clientes;
	private HashMap<String, Sucursal> sucursales;
	
	//Clientes de prueba
	ClienteBancario cli1,cli2,cli3;
	
	public Banco(String nombre)
	{
		this.setNombre(nombre);
		//Crear una lista de clientes (solo prueba)
		cli1 = new ClienteBancario("0001","Daenerys","Targaryen","");
		cli2 = new ClienteBancario("0002","Arya","Stark","");
		cli3 = new ClienteBancario("003","Margaery","Tyrell","");
		
		this.anhadirCliente(cli1);
		this.anhadirCliente(cli2);
		this.anhadirCliente(cli3);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean anhadirCliente(ClienteBancario nuevocliente)
	{
		if (nuevocliente != null)
		{
			clientes.put(nuevocliente.getNroCliente(), nuevocliente);
			return true;
		}
		return false;
	}
	
	public ClienteBancario obtenerCliente(String nrocliente)
	{
		return clientes.get(nrocliente);
	}
	
	public boolean anhadirSucursal(Sucursal nuevasucursal)
	{
		if (nuevasucursal != null)
		{
			sucursales.put(nuevasucursal.getCodSucursal(), nuevasucursal);
		}
		return false;
	}
	
	public Sucursal obtenerSucursal(String codsucursal)
	{
		return sucursales.get(codsucursal);
	}
}
