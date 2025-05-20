package com.nhaqp.lab10;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



/**
 * lab10 Activity
 * 
 * @author pmanchego@gmail.com
 * @version 1.0
 *
 */
public class Lab10_activityActivity extends Activity {
    
	int i = 5;		// Set integer to 5
	
	TextView textViewR;
	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textViewR = (TextView) findViewById(R.id.textViewR);
        textViewR.setText(String.valueOf(i));
        
        
        
    }
}