package com.nhaqp.lab001;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Actividad 001
 * 
 * @author doris.serruto.r@gmail.com
 * @version 1.0
 *
 */
public class LAB001_ActivityActivity extends Activity {
    
	int i = 5;
	TextView textViewR;
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textViewR = (TextView) findViewById(R.id.textViewR);
        textViewR.setText("Hola Programador!"+ i);
    }
}