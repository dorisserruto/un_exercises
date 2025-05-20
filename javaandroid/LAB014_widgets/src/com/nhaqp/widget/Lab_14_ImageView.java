package com.nhaqp.widget;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Lab_14_ImageView extends Activity{
    /** Called when the activity is first created. */
	
	ArrayList<Button> buttonList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_image);
        
    }
}