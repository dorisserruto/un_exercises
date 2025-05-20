package com.example.lab009_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseBasicHelper extends SQLiteOpenHelper {

	//Pag 358
	private static final String DATABASE_NAME="dbemp";
	private static String FIRST_NAME = "FirstName";
	private static String LAST_NAME = "LastName";
	private static String EMAIL = "Email";
	
	public DatabaseBasicHelper(Context context) {
		super(context,DATABASE_NAME,null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE employees (_id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Email TEXT);");
		
		ContentValues cv = new ContentValues();
		cv.put(FIRST_NAME, "Juan"); //nombre de la columna-valor
		cv.put(LAST_NAME, "Perez");
		cv.put(EMAIL, "jperez@nhaqp.com");
		
		db.insert("employees",null, cv);
		
		
		cv.put(FIRST_NAME, "Pedro");
		cv.put(LAST_NAME, "Fernandez");
		cv.put(EMAIL, "pfernandez@nhaqp.com");
		
		db.insert("employees",null, cv);
	}

	//Pag 460
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//Usado cuando se instala una nueva version
		android.util.Log.v("DatabaseBasic","Upgrading, data will be destroyed");
		db.execSQL("DROP TABLE IF EXISTS employees;");
		onCreate(db);

	}

}
