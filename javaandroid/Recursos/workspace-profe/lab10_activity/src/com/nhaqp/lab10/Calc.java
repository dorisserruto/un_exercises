/**
 * 
 */
package com.nhaqp.lab10;

import android.util.Log;

/**
 * @author Administrator
 *
 */
public class Calc {
	 
	  double r;

	  //Constructor
	  Calc(double p){
		  r = p;
	  }
	  
	  public void add(double a)
	  {
	    r = r + a;
	  }
	  public void sub(double b)
	  {
	    r = r - b;
	  }
	  public void div(double c)
	  {
		  try{
			  r = r / c;
		  } catch (Exception e){
			  Log.d("Calc", "error al dividir...");	   
		  }
	  }
	  public double getResult()
	  {
	 		return r;
	  }
	  
	  public static boolean isEqual(double a, double b)
	  {
		  /* If-Else */
		  if (a == b){
			  return true;
		  }
		  else	return false;
		  
	  }
}
