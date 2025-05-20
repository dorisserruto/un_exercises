package org.mybanca.www.Server;

public class Sucursal {
	
	private String codSucursal;
	private String nomSucursal;
	
	public Sucursal(String codsucursal, String nomsucursal)
	{
		this.setCodSucursal(codsucursal);
		this.setNomSucursal(nomsucursal);
	}

	public String getCodSucursal() {
		return codSucursal;
	}

	public void setCodSucursal(String codSucursal) {
		this.codSucursal = codSucursal;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

}
