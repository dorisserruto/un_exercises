package com.nhaqp.lab02;

public class Calculadora {
	private double resultado;
	
	//Constructor
	Calculadora(double res){
		resultado = res;
	}
	
	public double getResultado(){
		return resultado;
	}
	
	public void sumar(double param1, double param2){
		resultado = param1 + param2;
	}
	
	public void restar(double param1, double param2){
		resultado = param1  - param2;
	}
	
	public void multiplicar(double param1, double param2){
		resultado = param1 * param2;
	}
	public void dividir(double param1, double param2){
		resultado = param1  / param2;
	}
}
