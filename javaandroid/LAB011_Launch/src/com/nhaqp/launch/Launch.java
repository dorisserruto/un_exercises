package com.nhaqp.launch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Launch extends Activity {

	private EditText lat;
	private EditText lon;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);
        
        lat = (EditText) this.findViewById(R.id.lat);
        lon = (EditText) this.findViewById(R.id.lon);
    }
    
    public void showMe(View v){
    	String slat = lat.getText().toString();
    	String slon = lon.getText().toString();
    	
    	//keyword geo: location
    	//referencia: http://www.getlatlon.com/
    	Uri uri = Uri.parse("geo:"+slat+","+slon);
    	startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }

    
}
