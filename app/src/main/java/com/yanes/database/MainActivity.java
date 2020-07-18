package com.yanes.database;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {
    private DBDataSource dbDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbDataSource = new DBDataSource(getApplicationContext());

    }

    @Override
    protected void onStart() {
        super.onStart();
        dbDataSource.open();

   List<Final> people = dbDataSource.getAll();

       ArrayAdapter<Final> adapter = new ArrayAdapter<Final>(getApplicationContext(),android.R.layout.simple_list_item_1, people);
    setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
       // Intent intent=new Intent(this, Info.class);
       // startActivity(intent);
 }

    @Override
    protected void onStop() {
        super.onStop();
        dbDataSource.close();
    }

}
