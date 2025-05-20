package com.nhaqp.notepad;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Lab15_notepad extends Activity {

	String res = null;
	EditText fld;
	
	ArrayList<CheckBox> lstChecks;
	
	CheckBox cbItalic;
	CheckBox cbBold;
	CheckBox cbMonospace;
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		

		this.fld = (EditText) this.findViewById(R.id.editNotepad);
		InputStream in = getResources().openRawResource(R.raw.readme);
				
		this.cbItalic = (CheckBox)findViewById(R.id.cbItalic);
		this.cbBold= (CheckBox)findViewById(R.id.cbBold);
		this.cbMonospace = (CheckBox)findViewById(R.id.cbMonospace);

		try {
			if (in != null) {
				InputStreamReader input = new InputStreamReader(in);
				BufferedReader buffreader = new BufferedReader(input);
				res = "";
				String line;
				while ((line = buffreader.readLine()) != null) {
					res += line;
				}
				in.close();
				fld.setText(res);
				fld.setTextColor(Color.WHITE);
				Toast.makeText(getApplicationContext(),
						"File Contents ==> " + "File Loaded",
						Toast.LENGTH_SHORT).show();
			} else {

			}
		} catch (Exception ex) {

		}
	}

	public void onCheckBoxClicked(View v) {
		
//		int style = 0; //Normal
//		if(this.cbItalic.isChecked())
//			this.fld.setTypeface(Typeface.DEFAULT, 2);
//		if(this.cbBold.isChecked())
//			this.fld.setTypeface(Typeface.DEFAULT, 1);
//		if(this.cbMonospace.isChecked())
//			this.fld.setTypeface(Typeface.MONOSPACE, 0);
//		
		
		switch (v.getId()) {
		case R.id.cbItalic:
			this.fld.setTextAppearance(this, R.style.italic);
			//this.fld.setTypeface(Typeface.NORMAL, 2);
			break;
		case R.id.cbBold:
			this.fld.setTextAppearance(this, R.style.bold);
			break;
		case R.id.cbMonospace:
			this.fld.setTextAppearance(this, R.style.monospace);
			break;
		}
	}
}