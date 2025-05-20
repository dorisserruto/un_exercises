package com.nhaqp.lab010_rotacion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class mainActividad extends Activity {

	static final int PICK_RESULTADO=9999;
	String extra = null;
	EditText edtRes = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_pantalla);
        edtRes = (EditText) this.findViewById(R.id.edtResultado);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	//podria haber varios intents, es para identificarlo
    	if (requestCode == PICK_RESULTADO) {
    		//if (resultCode == RESULT_OK){ //que el usuario no ha cancelado la actividad
    			extra = data.getStringExtra("data");
    			edtRes.setText(extra);
    		//}
    	}
    }
    
    public void onClick(View v){
    	Intent t = new Intent(this,resultadoActividad.class);
    	this.startActivityForResult(t, PICK_RESULTADO);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
