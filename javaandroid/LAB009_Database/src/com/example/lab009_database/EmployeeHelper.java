package com.example.lab009_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class EmployeeHelper extends SQLiteOpenHelper {

	public static final String DATABASE_NAME="dbemployee";
	public static String FIRST_NAME = "FirstName";
	public static String LAST_NAME = "LastName";
	public static String EMAIL = "Email";
	public static String IDCATEGORY = "IdCategory";
	
	public static String DESCRIPTION = "Description";
	
	public EmployeeHelper(Context context) {
		super(context,DATABASE_NAME,null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE employees (_id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Email TEXT, IdCategory INTEGER);");
		
		ContentValues cv = new ContentValues();
		cv.put(FIRST_NAME, "Juan");
		cv.put(LAST_NAME, "Perez");
		cv.put(EMAIL, "jperez@nhaqp.com");
		cv.put(IDCATEGORY, 1);
		
		db.insert("employees",null, cv);
		
		cv.put(FIRST_NAME, "Pedro");
		cv.put(LAST_NAME, "Fernandez");
		cv.put(EMAIL, "pfernandez@nhaqp.com");
		cv.put(IDCATEGORY, 2);
		
		db.insert("employees",null, cv);
		
		cv.put(FIRST_NAME, "Alejandro");
		cv.put(LAST_NAME, "Malaga");
		cv.put(EMAIL, "amalaga@nhaqp.com");
		cv.put(IDCATEGORY, 1);
		
		db.insert("employees",null, cv);
		
		cv.put(FIRST_NAME, "Fabian");
		cv.put(LAST_NAME, "Gallegos");
		cv.put(EMAIL, "fgallegos@nhaqp.com");
		cv.put(IDCATEGORY, 2);
		
		db.insert("employees",null, cv);
		
		
		// Anhadir Categoria
		db.execSQL("CREATE TABLE category (_id INTEGER PRIMARY KEY AUTOINCREMENT, Description TEXT);");
		
		ContentValues cv2 = new ContentValues();
		cv2.put(DESCRIPTION, "Obrero");	
		db.insert("employees",null, cv2);
		
		cv2.put(DESCRIPTION, "Empleado");
		db.insert("employees",null, cv2);
		
		cv2.put(DESCRIPTION, "Funcionario");
		db.insert("employees",null, cv2);
	}

	//Pag 460
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//Usado cuando se instala una nueva version
		android.util.Log.v("Employee","Upgrading, data will be destroyed");
		db.execSQL("DROP TABLE IF EXISTS employees;");
		db.execSQL("DROP TABLE IF EXISTS category;");
		onCreate(db);

	}

}
