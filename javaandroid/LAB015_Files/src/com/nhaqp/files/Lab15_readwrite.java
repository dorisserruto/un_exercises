package com.nhaqp.files;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import java.io.InputStream;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


/**
 * @author pmanchego@gmail.com
 * @version 	1.0
 *
 */
public class Lab15_readwrite extends Activity {
  private final static String NOTES="notes.txt";
  private EditText editor;
  
  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    setContentView(R.layout.main_readwrite);
    editor=(EditText)findViewById(R.id.editor);
  }
  
  public void onResume() {
    super.onResume();
    
    try {
      InputStream in=openFileInput(NOTES);
      
      if (in!=null) {
        InputStreamReader tmp=new InputStreamReader(in);
        BufferedReader reader=new BufferedReader(tmp);
        String str;
        StringBuilder buf=new StringBuilder();
        
        while ((str = reader.readLine()) != null) {
          buf.append(str+"\n");
        }
        
        in.close();
        editor.setText(buf.toString());
      }
    }
    catch (java.io.FileNotFoundException e) {
      // that's OK, we probably haven't created it yet
    }
    catch (Throwable t) {
      Toast
        .makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG)
        .show();
    }
  }
  
  public void onPause() {
    super.onPause();
    
    try {
      OutputStreamWriter out=
          new OutputStreamWriter(openFileOutput(NOTES, 0));
      
      out.write(editor.getText().toString());
      out.close();    
    }
    catch (Throwable t) {
      Toast
        .makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG)
        .show();
    }
  }
      
}
