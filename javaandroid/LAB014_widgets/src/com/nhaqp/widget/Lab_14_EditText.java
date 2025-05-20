package com.nhaqp.widget;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class Lab_14_EditText extends Activity{
    /** Called when the activity is first created. */
	
	ArrayList<Button> buttonList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_field);
        
        AutoCompleteTextView atv = (AutoCompleteTextView)this.findViewById(R.id.editText3);
        
        String[] cities = getResources().getStringArray(R.array.ciudades);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cities);
        atv.setAdapter(adapter);
        
    }
}