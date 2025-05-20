package com.nhaqp.player1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class Lab13_player1Service extends Service {

	MediaPlayer player;
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "Servicio Creado", Toast.LENGTH_LONG).show();
		Log.d("Lab13", "oncreate para iniciar!");
	
		player = MediaPlayer.create(this, R.raw.song);
        player.setLooping(false);
	}
	
	@Override
	public void onDestroy() {
		Toast.makeText(this, "Reproductor finalizado", Toast.LENGTH_LONG).show();
		Log.d("Lab13", "onclick para finalizar!");
		player.stop();
	}
	
	@Override
	public void onStart(Intent intent, int starid) {
		Toast.makeText(this, "Reproductor iniciado", Toast.LENGTH_LONG).show();
		Log.d("Lab13", "onclick para iniciar!");
		player.start();	
		
	}
	
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
