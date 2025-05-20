package com.nhaqp.examen;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseBasicHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME="dbtypes";
	private static String DESCRIPTION = "Descripcion";
	
	public DatabaseBasicHelper(Context context) {
		super(context,DATABASE_NAME,null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE tipos (_id INTEGER PRIMARY KEY AUTOINCREMENT, Descripcion TEXT);");
		
		ContentValues cv = new ContentValues();
		cv.put(DESCRIPTION, "lala"); //nombre de la columna-valor
		db.insert("tipos",null, cv);
		
		
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
