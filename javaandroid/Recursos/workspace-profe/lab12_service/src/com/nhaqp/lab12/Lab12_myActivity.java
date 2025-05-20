package com.nhaqp.lab12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * lab12 Activity Service
 * #adb shell
 * #logcat
 * 
 * @author 		pmanchego@gmail.com
 * @version 	1.0
 */
public class Lab12_myActivity extends Activity implements OnClickListener {
	private static final String TAG = "Lab12_myActivity";
	  Button buttonStart, buttonStop;

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);

	    buttonStart = (Button) findViewById(R.id.buttonStart);
	    buttonStop = (Button) findViewById(R.id.buttonStop);

	    buttonStart.setOnClickListener(this);
	    buttonStop.setOnClickListener(this);
	  }

	  public void onClick(View src) {
	    switch (src.getId()) {
	    case R.id.buttonStart:
	      Log.d(TAG, "onClick: iniciando reproductor");
	      startService(new Intent(this, Lab12_myService.class));
	      break;
	    case R.id.buttonStop:
	      Log.d(TAG, "onClick: deteniendo reproductor");
	      stopService(new Intent(this, Lab12_myService.class));
	      break;
	    }
	  }
}