package com.nhaqp.telco;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class Email_Send extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    
    public void enviarMail(View v){
    	String[] to = {"doris.serruto.r@gmail.com"};
    	String[] cc = {"doris.serruto@ucsp.edu.pe"};
    	sendEmail(to,cc,"hola subject","hola android developers");
    }

	private void sendEmail(String[] emailAdresses, String[] carbonCopies, String subject, String message) {
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		
		emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAdresses);
		emailIntent.putExtra(Intent.EXTRA_CC, carbonCopies);
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, message);
		emailIntent.setType("message/rfc822");
		
		startActivity(Intent.createChooser(emailIntent, "Email"));
	}
}
