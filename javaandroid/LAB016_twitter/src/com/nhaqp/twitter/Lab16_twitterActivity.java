package com.nhaqp.twitter;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Lab16_twitterActivity extends Activity {
    private final static String CONSUMER_KEY = "TxJ2dHmN9XZfe1nUqRgyRQ";
    private final static String CONSUMER_SECRET = "lxe1EkNC5pWELWV5DiyQ12gf1gkEBbdBN1X1ZlvYKKw";
    private final static String USER_KEY = "235651904-GZ789n1Mg3fqqO2xrYUloRKqBd7G7Eps2LzxdlKm";
    private final static String USER_SECRET = "KWjCcJ5FyDJhoG1z6uknIe46wVL25cq8zipFuQveL4";
	
    Twitter my_twiter;
	
    EditText edit;
    
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        edit = (EditText) this.findViewById(R.id.editText2);
        
        //politica de seguridad para que funcione como un thread
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);    

		//obj de seguridad		
		OAuthSignpostClient client = new OAuthSignpostClient(CONSUMER_KEY, CONSUMER_SECRET,
                USER_KEY, USER_SECRET);
		
		//inicializo mi obj twitter...
		my_twiter = new Twitter("Olbapcito", client);

		
		if(my_twiter == null)		
			Toast.makeText(this, "Incorrect Login",Toast.LENGTH_LONG).show();
		else
		{
			my_twiter.setStatus("Olbapcito jugando con Twitter again!!!...");
		}
        
    }
    
    public void clickButtonTweet(View v)
    {
    	if(my_twiter.getStatus().toString().equals(edit.getText().toString()))
    		Toast.makeText(this, "Status repetido",Toast.LENGTH_LONG).show();
    	else
    		my_twiter.setStatus(edit.getText().toString());
    }
    
}