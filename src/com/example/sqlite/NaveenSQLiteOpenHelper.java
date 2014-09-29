package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class NaveenSQLiteOpenHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "naveenkumarbv.db";
	private static int DATABASE_VERSION=1;
	
	public static final String TABLE_NAME = "books";
	public static final String ID = "id";
	public static final String TITLE = "title";
	
	private static final String TABLE_CREATE = 
			"CREATE TABLE " +TABLE_NAME+ "(" + ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +TITLE + " TEXT " +")";


	public NaveenSQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(TABLE_CREATE);
		Log.i("MEssg : ", "Table has been created");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int Oldversion, int Newversion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		Log.i("MEssg : ", "Table has been Removed and calling to upadate");
		onCreate(db);
	}

}
