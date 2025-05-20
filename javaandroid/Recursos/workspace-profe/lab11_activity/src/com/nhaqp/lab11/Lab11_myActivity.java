package com.nhaqp.lab11;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/**
 * lab11 Activity OnClickListener
 * #adb shell
 * #logcat
 * 
 * @author 		pmanchego@gmail.com
 * @version 	1.0
 */
public class Lab11_myActivity extends Activity implements OnClickListener {
	private static final String TAG = "Lab11_myActivity";
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
	      Toast.makeText(this, "Servicio Iniciado", Toast.LENGTH_LONG).show();
	      Log.d(TAG, "onClick: iniciando reproductor");	   
	      break;
	    case R.id.buttonStop:
	      Toast.makeText(this, "Servicio Detenido", Toast.LENGTH_LONG).show();
	      Log.d(TAG, "onClick: deteniendo reproductor");
	      break;
	    }
	  }
}