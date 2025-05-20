package com.nhaqp.lab10;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Date;

public class Lab10_NowRedux extends Activity {
  Button btn;

  @Override
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    
    setContentView(R.layout.main);

    btn=(Button)findViewById(R.id.button);
    /* btn.setOnClickListener(this); */
    updateTime();
  }

  public void onClick(View view) {
    updateTime();
  }

  private void updateTime() {
    btn.setText(new Date().toString());
  }
  
  public void someMethod(View view) {
	  btn.setText("click en segundo boton");
  }

}
