package com.nhaqp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseBasicHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "dbemp";
	private static String FIRSTNAME = "FirstName";
	private static String LASTTNAME = "LastName";
	private static String EMAIL = "Email";

	public DatabaseBasicHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE employees (_id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Email TEXT);");

		ContentValues cv = new ContentValues();
		cv.put(FIRSTNAME, "Juan");
		cv.put(LASTTNAME, "Perez");
		cv.put(EMAIL, "jperez@nhaqp.com");
		db.insert("employees", null, cv);

		cv.put(FIRSTNAME, "Pedro");
		cv.put(LASTTNAME, "Fernandez");
		cv.put(EMAIL, "pfernandez@nhaqp.com");
		db.insert("employees", null, cv);
				
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.v("DatabaseBasic", "Database Upgrading, old data will be destroyed");
		db.execSQL("DROP TABLE IF EXISTS employee");
		onCreate(db);
	}

}
