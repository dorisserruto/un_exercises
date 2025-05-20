package com.nhaqp.lab010_rotacion;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v4.app.NavUtils;

@SuppressWarnings("deprecation")
public class rotacionOne extends Activity {

	//pagina 242
	static final int PICK_REQUEST=1337;
	Button viewButton = null;
	//uniform resource identifier: identificar objetos en el sistema android
	Uri contact = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.viewButton = (Button) this.findViewById(R.id.btnPick);
        
        viewButton.setEnabled(contact!=null);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
    	if (requestCode == PICK_REQUEST){
    		if (resultCode == RESULT_OK){
    			contact = data.getData();
    			viewButton.setEnabled(true);
    		}
    	}
    }
    
    public void pickContact(View v){
    	@SuppressWarnings("deprecation")
		Intent i = new Intent(Intent.ACTION_PICK,Contacts.CONTENT_URI);
    	startActivityForResult(i, PICK_REQUEST);
    }
    
    public void viewContact(View v){
    	startActivity(new Intent(Intent.ACTION_VIEW,contact));
    }
    

    //guardar en state el valor
    @Override
    protected void onSaveInstanceState(Bundle outState){
    	super.onSaveInstanceState(outState);
    	if (contact!=null){
    		outState.putString("contact", contact.toString());
    	}
    }
    
    private void restoreMe(Bundle state){
    	contact = null;
    	
    	if (state != null){
    		String contactUri = state.getString("contact");
    		if (contactUri != null){
    			contact = Uri.parse(contactUri);
    		}
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
