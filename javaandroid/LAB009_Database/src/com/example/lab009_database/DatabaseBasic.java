package com.example.lab009_database;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class DatabaseBasic extends Activity {

	private DatabaseBasicHelper db = null;
	private Cursor employeeCursor = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_basic);
        
        TextView tv = (TextView) this.findViewById(R.id.textView1);
        tv.setText("");
        
        db = new DatabaseBasicHelper(this);
        employeeCursor = db.getReadableDatabase().rawQuery("SELECT * FROM employees ORDER BY LastName", null);
        
        employeeCursor.moveToFirst();
        while(employeeCursor.isAfterLast() == false){
        	tv.append(" " + employeeCursor.getString(2));
        	employeeCursor.moveToNext();
        }
        
        employeeCursor.close();
        
        //DDMS: seleccionar emulador->FileExplorer->data->data->com.nhaqp.database->databases: ver los db
        //En la esquina superior derecha: PULL: BAJAR A DISCO - PUSH: SUBIR A ANDROID
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
