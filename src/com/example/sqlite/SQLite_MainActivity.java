package com.example.sqlite;

import android.os.Bundle;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.Menu;

public class SQLite_MainActivity extends Activity {

	InserAndReadData DataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite__main);
        
        DataSource=new InserAndReadData(this);
        DataSource.open();
        DataSource.Insert("Naveen Kumar BV", 67);
        DataSource.Insert("Sunil Kumar BV", 87);
        DataSource.Insert("Saroja KN", 97);
        DataSource.Read();
        DataSource.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_sqlite__main, menu);
        return true;
    }
    
}
