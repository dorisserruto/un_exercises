package com.nhaqp.telco;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class SMS_Send extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    
    public void enviarSMS(View v){
    	
    	SmsManager sms = SmsManager.getDefault();
    	sms.sendTextMessage("5554",null,"hola android",null,null);
    	
//    	Intent i = new Intent(android.content.Intent.ACTION_VIEW);
//    	i.putExtra("address", "5554");
//    	i.putExtra("sms_body", "Hola android developers");
//    	i.setType("vnd.android-dir/nms-sms");
//    	startActivity(i);
    }
}
