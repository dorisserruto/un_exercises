package org.mybanca.www.Server;

public class CuentaBancaria {

	private String nroCuenta;
	private String tipoMoneda;
	private double monto;
	
	public CuentaBancaria(String nrocuenta, String tipomoneda, double monto)
	{
		this.setNroCuenta(nrocuenta);
		this.setTipoMoneda(tipomoneda);
		this.setMonto(monto);
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
}
