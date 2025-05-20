package com.nhaqp.player1;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Lab13_player1Activity extends Activity implements OnClickListener {

	Button btnI, btnF;
	MediaPlayer player;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
        btnI = (Button) this.findViewById(R.id.btnStart);
        btnF = (Button) this.findViewById(R.id.btnFinalizar);
    
        btnI.setOnClickListener(this);
        btnF.setOnClickListener(this);
        
        
    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		
		case R.id.btnStart:
			this.startService(new Intent(this,Lab13_player1Service.class));
			break;
			
		case R.id.btnFinalizar:			
			this.stopService(new Intent(this,Lab13_player1Service.class));
			break;
		
		}
		
	}
}