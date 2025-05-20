package com.example.lab007_mytwitter;

import java.util.List;

import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import winterwell.jtwitter.User;
import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

	private final static String CONSUMER_KEY = "476fY1W3sYQVNd2gaLe6kw";
	private final static String CONSUMER_SECRET = "EeL3Y8Yqf4C6b0mgOu7pEQA3tZKi1fIBzjaCSwZQ";

	private final static String USER_KEY = "75113608-PHRHW7sCuT8my9bkTun0eAjfDfXzYRtASuozZJdr4";
	private final static String USER_SECRET = "ZUhnTejefmkTpHwH8ayDB87kRQvoC1ig41PFdJSuU";
	
	//EditText txtTweet;
	EditText set_input;
	AlertDialog.Builder inputDialog;
	Twitter my_twiter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.twitter_login);
        
        //txtTweet = (EditText) findViewById(R.id.txtTwitterSend);
    }

    public void onTweet(View v){
//    	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//		StrictMode.setThreadPolicy(policy);    
//
//		Twitter my_twiter;
//		
//		OAuthSignpostClient client = new OAuthSignpostClient(CONSUMER_KEY, CONSUMER_SECRET,
//                USER_KEY, USER_SECRET);
//		my_twiter = new Twitter("mirieelively", client);
//
//		
//		if(my_twiter == null)		
//			Toast.makeText(this, "Incorrect Login",Toast.LENGTH_LONG).show();
//		else
//			try{
//				my_twiter.setStatus(txtTweet.getText().toString());
//				Toast.makeText(this, "Tweet enviado",Toast.LENGTH_LONG).show();
//			} catch (Exception ex) {
//				Toast.makeText(this, "No es valido colocar el mismo Tweet",Toast.LENGTH_LONG).show();
//			}
    	
    	setTitle("Tweet");		
		inputDialog = new AlertDialog.Builder(this);
		inputDialog.setTitle("Enter Tweet");

		set_input = new EditText(this);
		set_input.setWidth(250);
		set_input.setHeight(30);
		inputDialog.setView(set_input); //incluyo el edittext a la caja de dialogo
		
		inputDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			//se tiene que implementar el metodo onclick
			public void onClick(DialogInterface dialog, int which) {
				String txt_tweet = set_input.getText().toString();
				my_twiter.setStatus(txt_tweet); //actualizar status en twitter
				Toast.makeText(MainActivity.this, "Tweet Successful", Toast.LENGTH_LONG).show();
			}});

		inputDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		});

		inputDialog.show();

    }
    
    public void clickButtonAmigos(View v){
    	setTitle("Amigos");
    	StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);    
		
		OAuthSignpostClient client = new OAuthSignpostClient(CONSUMER_KEY, CONSUMER_SECRET,
                USER_KEY, USER_SECRET);
    	my_twiter = new Twitter("mirieelively", client);
    	
    	@SuppressWarnings("deprecation")
		List<User> arr = my_twiter.getFriends();
    	
    	Object[] str = arr.toArray();
    	String[] str1 = new String[str.length];
 
    	
    	for(int i=0; i<str.length; i++){
    		str1[i] = str[i].toString();
    	}
    	Toast.makeText(this,str.length,Toast.LENGTH_LONG).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
