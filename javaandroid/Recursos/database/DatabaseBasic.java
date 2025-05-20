package com.nhaqp.database;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class DatabaseBasic extends Activity {

	private DatabaseBasicHelper db = null;
	private Cursor employeeCursor = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_basic);

		TextView tv = (TextView) this.findViewById(R.id.textView1);
		tv.setText("");

		db = new DatabaseBasicHelper(this);

		employeeCursor = db.getReadableDatabase().rawQuery(
				"SELECT * FROM employees ORDER BY LastName", null);
		
		employeeCursor.moveToFirst();
		while(employeeCursor.isAfterLast() == false) {
			tv.append(" " + employeeCursor.getString(2));
			employeeCursor.moveToNext();
		}
		
		employeeCursor.close();
	}
}