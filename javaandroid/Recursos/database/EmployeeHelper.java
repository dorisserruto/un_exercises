package com.nhaqp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class EmployeesHelper extends SQLiteOpenHelper {
  private static final String DATABASE_NAME="dbemp";
  static final String FIRSTNAME="FirstName";
  static final String LASTNAME="LastName";
  static final String EMAIL="Email";
    
  public EmployeesHelper(Context context) {
    super(context, DATABASE_NAME, null, 1);
  }
  
  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE employees (_id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT, Email TEXT);");    
    
    ContentValues cv=new ContentValues();
    
    cv.put(FIRSTNAME, "Juan");
    cv.put(LASTNAME, "Perez");
    cv.put(EMAIL, "jperez@nhaqp.com");
    db.insert("employees", null, cv);
    
    cv.put(FIRSTNAME, "Pedro");
    cv.put(LASTNAME, "Fernandez");
    cv.put(EMAIL, "pfernandez@nhaqp.com");
    db.insert("employees", null, cv);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    android.util.Log.w("DatabaseBasic", "Upgrading database, which will destroy all old data");
    db.execSQL("DROP TABLE IF EXISTS employee");
    onCreate(db);
  }

}
