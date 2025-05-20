/**
 * 
 */
package com.nhaqp.lab12;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * lab12 Service
 * @author 		pmanchego@gmail.com
 * @version 	1.0
 */
public class Lab12_myService extends Service {
	private static final String TAG = "Lab12_myService";
	MediaPlayer player;

	@Override
	public void onCreate() {
		Toast.makeText(this, "Servicio Creado", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
		
		player = MediaPlayer.create(this, R.raw.song);
		player.setLooping(false); // Set looping
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "Servicio Detenido", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
		player.stop();
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		Toast.makeText(this, "Mi servicio iniciado", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onStart");
		player.start();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
