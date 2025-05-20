package com.nhaqp.telco;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class Email_send extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void EnviarMail(View v){
    
    	String[] to = {"pmanchego@gmail.com"};
    	String[] cc = {"pmanchego@hotmail.com"};
    	sendEmail(to, cc, "hola subject", "hola android developers");
   
    	
    }
    
    private void sendEmail(String[] emailAddresses, String[] carbonCopies, 
    							String subject, String message)
    {
    		Intent emailIntent = new Intent(Intent.ACTION_SEND);
    		emailIntent.setData(Uri.parse("mailto:"));
    		String[] to = emailAddresses;
    		String[] cc = carbonCopies;
    		emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
    		emailIntent.putExtra(Intent.EXTRA_CC, cc);
    		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
    		emailIntent.putExtra(Intent.EXTRA_TEXT, message);
    		emailIntent.setType("message/rfc822");
    		startActivity(Intent.createChooser(emailIntent, "Email"));
    		
  }
    
}