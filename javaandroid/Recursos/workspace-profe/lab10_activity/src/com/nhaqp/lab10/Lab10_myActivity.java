package com.nhaqp.lab10;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * lab10 Activity
 * 
 * @author pmanchego@gmail.com
 * @version 1.0
 * 
 *          Java Tutorial 1. Run / Debug 2. Hello Android World 3. Comments 4.
 *          Data Types 5. Operators 7. If-else 8. Loops 9. Class 10.Exceptions
 */
public class Lab10_myActivity extends Activity implements OnClickListener {

	int i = 5; // Set the integer to 5
	TextView textViewR;
	EditText editText1;
	EditText editText2;
	Button button1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/* Hello Android World */
		textViewR = (TextView) findViewById(R.id.textView3);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);
		// textViewR.setText("Hello Android World");

		/* Data Types */
		// integers
		byte largestByte = Byte.MAX_VALUE;
		short largestShort = Short.MAX_VALUE;
		int largestInteger = Integer.MAX_VALUE;
		long largestLong = Long.MAX_VALUE;

		// real numbers
		float largestFloat = Float.MAX_VALUE;
		double largestDouble = Double.MAX_VALUE;

		// other primitive types
		char aChar = 'S';
		boolean aBoolean = true;

		String s = new String("abc");

		// textViewR.setText(String.valueOf(largestShort));

		/* Operators */
		int i = 10;
		int j = 20;
		double x = 10.5;
		double y = 20.5;
		int r = i + j;
		double d = x + y;
		// textViewR.setText(String.valueOf(d));

		double n1 = Double.valueOf(String.valueOf(editText1.getText()));
		double n2 = Double.valueOf(String.valueOf(editText2.getText()));
		double r3 = n1 + n2;
		// textViewR.setText(String.valueOf(r3));

		/* Class */
		Calc calc = new Calc(n1);
		calc.add(n2);
		textViewR.setText(String.valueOf(calc.getResult()));

	}

	public void onClick(View src) {
		double n1 = Double.valueOf(String.valueOf(editText1.getText()));
		double n2 = Double.valueOf(String.valueOf(editText2.getText()));
		Calc calc = new Calc(n1);
		calc.div(n2);
		textViewR.setText(String.valueOf(calc.getResult()));
		
		
		/* If-Else */
		/*
		if (Calc.isEqual(n1, n2) == true) {
			textViewR.setText("iguales");
		} else textViewR.setText("diferentes");
		*/
	}
}