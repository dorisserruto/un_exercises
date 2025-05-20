package com.nhaqp.widget;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LAB006_ImageView extends Activity implements View.OnClickListener{
	
	ArrayList<Button> buttonList;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_imageview);

    }

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}