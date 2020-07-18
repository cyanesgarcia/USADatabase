package com.yanes.database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by claud on 4/20/2018.
 */

public class type extends Activity implements AdapterView.OnItemClickListener {
    public static String  Type;
    static final String[] TYPES={
            "Capital","Foods & Drinks","Places",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type);

        ListView lv= (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, TYPES
        );
        lv.setAdapter(adapter1);
        lv.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Type = (String) adapterView.getItemAtPosition(i);

       Intent intent=new Intent(this,Info.class);
       startActivity(intent);
    }
}
