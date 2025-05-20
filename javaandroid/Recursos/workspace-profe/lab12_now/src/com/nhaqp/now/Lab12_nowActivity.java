package com.nhaqp.now;

import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Lab12_nowActivity extends Activity implements OnClickListener {
    Button btn;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        
        btn = new Button(this);
        btn.setOnClickListener(this);
        
        setContentView(btn);
    }

	public void onClick(View v) {
		updateTime();
		
	}
	
	private void updateTime() {
		btn.setText(new Date().toString());
	}
}