package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class InserAndReadData {
	SQLiteOpenHelper OpenHelperSQLite;
	SQLiteDatabase DateBaseSQLite;
	
	public InserAndReadData(Context context) {
		OpenHelperSQLite = new NaveenSQLiteOpenHelper(context);
	}
	
	public void open() {
		Log.i("Mesg : ", "Database opened");
		DateBaseSQLite = OpenHelperSQLite.getWritableDatabase();
		/*
		 * it ll call onUpgrade() first then oncreate() function.
		 * otherwise u can call open() function only.
		 * But OpenHelperSQLite.getWritableDatabase(); should not called in main thread becz
		 * it ll take time to Upgrade the table.
		 */
	}

	public void close() {
		Log.i("Mesg : ", "Database closed");		
		OpenHelperSQLite.close();
	}
	
	public void Insert(String name,int id) {
		ContentValues values = new ContentValues();
		values.put(NaveenSQLiteOpenHelper.TITLE, name);
		values.put(NaveenSQLiteOpenHelper.ID, id);
		
		long insertid = DateBaseSQLite.insert(NaveenSQLiteOpenHelper.TABLE_NAME, null, values);
		/*
		 * -1 = error
		 * >0 = ok.
		 * 
		 * and 
		 * instead null, u can array which contain table column names, like
		 * private static final String[] allColumns = {
		 * NaveenSQLiteOpenHelper.ID
		 * NaveenSQLiteOpenHelper.TITLE
		 * }
		 */
		Log.i("Total Numbers Inserted : ",Long.toString(insertid));
		
	}
	
	public void Read(){
		
		Cursor cursor = DateBaseSQLite.query(NaveenSQLiteOpenHelper.TABLE_NAME, null, null, null, null, null, null);
				
		Log.i("Mesg : ", "Returned " + cursor.getCount() + " rows");
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				Log.i("ID : ",Long.toString(cursor.getLong(cursor.getColumnIndex(NaveenSQLiteOpenHelper.ID))) );
				Log.i("Name : ",cursor.getString(cursor.getColumnIndex(NaveenSQLiteOpenHelper.TITLE)) );
			}
		}
		
	}
  
	
	/*
	 *  List<Tour> Read(){
	 *  
	 *  List<ModelClass> Books = new ArrayList<ModelClass>();
	 *  
	 *  for loop..........
	 *  ModelClass Book = new ModelClass();
				Book.setId(cursor.getLong(cursor.getColumnIndex(NaveenSQLiteOpenHelper.TITLE)));
				Book.setTitle(cursor.getString(cursor.getColumnIndex(NaveenSQLiteOpenHelper.ID)));
				Books.add(Book);
		end of for loop........
				
				return Books;
	 *  }
	 * private List<ModelClass> Books;
	 * ArrayAdapter<ModelClass> adapter = new ArrayAdapter<ModelClass>(this, 
				android.R.layout.simple_list_item_1, Books);
		setListAdapter(adapter);
	 *
	 */


}
