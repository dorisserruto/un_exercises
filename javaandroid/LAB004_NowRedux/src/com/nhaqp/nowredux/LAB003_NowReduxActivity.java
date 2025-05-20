package com.nhaqp.nowredux;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LAB003_NowReduxActivity extends Activity{
    Button btn;
    Button btn2;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn = (Button) this.findViewById(R.id.btnNow);
        btn2 = (Button) this.findViewById(R.id.btnDos);
    }
    
    public void someMethod(View v){ //Requiere recibir el parametro View
    	btn.setText(new Date().toString());
    }
}