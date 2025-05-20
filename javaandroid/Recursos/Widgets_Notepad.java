package com.nhaqp.lab10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Widgets_Notepad extends Activity implements View.OnClickListener {

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.main_notepad);
		EditText fld = (EditText) this.findViewById(R.id.editNotepad);
		
		String res = null;
		try {

			//InputStream in = openFileInput("readme.txt");
			//InputStream in = getResources().openRawResource(R.raw.readme);
			InputStream in = new FileInputStream(new File("/mnt/sdcard/download/readme.txt"));
			
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
				fld.setTextColor(Color.BLUE);
				Toast.makeText(getApplicationContext(),
						"File Contents ==> " + "File Loaded", Toast.LENGTH_SHORT).show();
			} else {				
				
			}

		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					e.toString() + e.getMessage(), Toast.LENGTH_LONG).show();
		}

	}

	public void onClick(View view) {

	}

}