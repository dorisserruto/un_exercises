package com.nhaqp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "dbemployee";
	static String FIRSTNAME = "FirstName";
	static String LASTTNAME = "LastName";
	static String EMAIL = "Email";
	static String IDCATEGORY = "IdCategory";

	public EmployeeHelper(Context context) {
		super(context, DATABASE_NAME, null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE employees (_id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Email TEXT, IdCategory INTEGER);");

		ContentValues cv = new ContentValues();
		cv.put(FIRSTNAME, "Juan");
		cv.put(LASTTNAME, "Perez");
		cv.put(EMAIL, "jperez@nhaqp.com");
		cv.put(IDCATEGORY, 1);
		db.insert("employees", null, cv);

		cv = new ContentValues();
		cv.put(FIRSTNAME, "Carlos");
		cv.put(LASTTNAME, "Maldonado");
		cv.put(EMAIL, "cmaldonado@nhaqp.com");
		cv.put(IDCATEGORY, 1);
		db.insert("employees", null, cv);

		cv = new ContentValues();
		cv.put(FIRSTNAME, "Pedro");
		cv.put(LASTTNAME, "Fernandez");
		cv.put(EMAIL, "pfernandez@nhaqp.com");
		cv.put(IDCATEGORY, 2);
		db.insert("employees", null, cv);

		cv = new ContentValues();
		cv.put(FIRSTNAME, "Gustavo");
		cv.put(LASTTNAME, "Lopez");
		cv.put(EMAIL, "glopez@nhaqp.com");
		cv.put(IDCATEGORY, 1);
		db.insert("employees", null, cv);
						
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		android.util.Log.v("Employee", "Database Upgrading, old data will be destroyed");
		db.execSQL("DROP TABLE IF EXISTS employees");
		onCreate(db);
	}

}
