package com.nhaqp.telco;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Dialer extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void dial(View v) {
    	
    	EditText number = (EditText)this.findViewById(R.id.txtNumber);
    	String toDial = "tel:" + number.getText().toString();
    	//startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
    	startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(toDial)));
    	
    }
}