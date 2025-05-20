package com.nhaqp.lab10;


import winterwell.jtwitter.OAuthSignpostClient;
import winterwell.jtwitter.Twitter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Widgets_Twitter extends Activity {

	private final static String CONSUMER_KEY = "9nreFQIyradTs1apiZ45hw";
    private final static String CONSUMER_SECRET = "SvCVJP5fDhYj02fEgqqJbpi49NMyD5d2bJkgpzfKQ";
    private final static String USER_KEY = "54436831-RPdEOn4FaJaQ6Xm2s1o6aVlsMExH5yPgKalWrkWae";
    private final static String USER_SECRET = "FxH5ZJj5sBZ9tnP7Z4m2DFoTUgRBTtE7Hv8YiWUXfAg";
    
	Twitter my_twiter;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.twitter_login);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);    

				
		OAuthSignpostClient client = new OAuthSignpostClient(CONSUMER_KEY, CONSUMER_SECRET,
                USER_KEY, USER_SECRET);
		my_twiter = new Twitter("pmanchego", client);

		
		if(my_twiter == null)		
			Toast.makeText(this, "Incorrect Login",Toast.LENGTH_LONG).show();
		else
			my_twiter.setStatus("hello from my android device!");

	}
	
	public void clickButton1(View view) {
		setContentView(R.layout.twitter_main);
	}
	
	
	EditText set_input;
	AlertDialog.Builder inputDialog;
	public void clickButton2(View view) {
		setTitle("Tweet");		
		inputDialog = new AlertDialog.Builder(this);
		inputDialog.setTitle("Enter Tweet");

		set_input = new EditText(this);
		set_input.setWidth(250);
		set_input.setHeight(30);
		inputDialog.setView(set_input);
		inputDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int which) {
			String txt_tweet = set_input.getText().toString();
			my_twiter.setStatus(txt_tweet);
			Toast.makeText(Widgets_Twitter.this, "Tweet Successful", Toast.LENGTH_LONG).show();
		}});

		inputDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
		}
		});

		inputDialog.show();

		}

	public void clickButton3(View view) {
		setContentView(R.layout.twitter_main);
	}
	public void clickButton4(View view) {
		setContentView(R.layout.twitter_main);
	}
	public void clickButton5(View view) {
		setContentView(R.layout.twitter_main);
	}
	
	

	
}