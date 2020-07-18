package com.yanes.database;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * Created by claud on 4/19/2018.
 */

public class Info extends ListActivity {
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
       super.onListItemClick(l, v, position, id);

        ArrayAdapter adapter = (ArrayAdapter<Final>)getListAdapter();
        Final fin = (Final) adapter.getItem(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);



        builder.setMessage(Html.fromHtml("<html>" + "<p><b>Name: </b>" + fin.getName()+"</p>" + "<p><b>State: </b>" + fin.getState()+"</p>" +
                "<p><b>Type: </b>" + fin.getType()+"</p>" + "<p><b>Description: </b>" + fin.getDescription() +"</p>" +"</html>"));
        builder. setTitle("Info");
        builder.create().show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        dbDataSource.close();
    }



}
