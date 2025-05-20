package com.nhaqp.widgets;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class Lab14_EditText extends Activity {
    

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_field);
        
      AutoCompleteTextView atv = (AutoCompleteTextView) this.findViewById(R.id.autoCompleteTextView1);
      String[] cities = getResources().getStringArray(R.array.cities_array);  

ArrayAdapter<String> adapter =
new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, cities);
      
atv.setAdapter(adapter);
      
    }
    
    
}