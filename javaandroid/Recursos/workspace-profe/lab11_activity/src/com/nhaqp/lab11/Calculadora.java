package com.nhaqp.lab11;

public class Calculadora {

	double resultado;
	
	
	//Constructor
	Calculadora(double p) {
		resultado = p;
	}
	
	public double getResultado()
	{
		return resultado;
	}

	public void sumar(double a, double b){		
		resultado = a + b;
	}	
	public void restar(double a, double b){		
		resultado = a - b;
	}
	public void multiplicar(double a, double b){		
		resultado = a * b;
	}
	public void dividir(double a, double b){		
		resultado = a / b;
	}
	
}
