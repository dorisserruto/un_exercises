package com.nhaqp.lab010_rotacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class resultadoActividad extends Activity {

	static final int PICK_RESULTADO=9999;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_resultado);
    }
    
    public void onClick(View v){
    	Intent in = new Intent();
    	in.putExtra("data", "hola android");
    	setResult(PICK_RESULTADO,in);
    	finish();
    }
  
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

    
}
