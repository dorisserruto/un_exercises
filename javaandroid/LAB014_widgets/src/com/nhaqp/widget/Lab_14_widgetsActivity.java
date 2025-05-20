package com.nhaqp.widget;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Lab_14_widgetsActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	
	ArrayList<Button> buttonList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_button);
        buttonList = new ArrayList<Button>();
        buttonList.add((Button)this.findViewById(R.id.button4));
        buttonList.add((Button)this.findViewById(R.id.button5));
        buttonList.add((Button)this.findViewById(R.id.button6));
        
        for(Button b:buttonList) {
        	b.setTag("0");
        	b.setOnClickListener(this);
        }
        
    }
    
    public void someMethod(View view){
    	Toast.makeText(this, "Mr Anderson", Toast.LENGTH_LONG).show();
    }

	public void onClick(View v) {
		Button b = (Button)v;
		if(b.getTag() == "0"){
			b.setText("A");
			b.setTag("1");
		}
		else{
			b.setText("B");
			b.setTag("0");
		}
	}
}