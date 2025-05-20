package com.nhaqp.telco;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class Dialer extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    
    //Pag
    public void dial(View v){
    	EditText number = (EditText) this.findViewById(R.id.txtNumber);
    	String toDial = "tel:" + number.getText().toString(); //tel-convencion como maps
    	
    	//startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial))); //APARECEN DIGITOS PARA MARCAR
    	startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(toDial)));
    }
}
