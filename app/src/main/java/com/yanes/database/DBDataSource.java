package com.yanes.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claud on 4/5/2018.
 */

public class DBDataSource {
    private SQLiteDatabase database;
    private MySQLiteHelper databaseHelper;
    String state= null;
    String t = null;

    public DBDataSource(Context context){
        databaseHelper = new MySQLiteHelper(context);
    }

    public void open(){
        database = databaseHelper.getReadableDatabase();
    }

    public void close(){
        database.close();
    }

    public List <Final> getAll(){
        List<Final> people = new ArrayList<>();

        String[] columnNames = MySQLiteHelper.FinalColum.names();

        // select person_id, last_name, first_name, age
        //from Person
        //order by last_name

      Cursor cursor = database.query(
                MySQLiteHelper.FINAL_TABLE,
                columnNames,
                null,null,null,null,
                MySQLiteHelper.FinalColum.Name.toString() //ordena por name
        );
        cursor.moveToFirst();

       while (! cursor.isAfterLast()) {

                Final fin = cursorToPerson(cursor);
               if(state.equals( States.State )&& t.equals( type.Type)) {
                    people.add(fin);
              }
                cursor.moveToNext();

     }
        cursor.close();

        return people;
    }

    private Final cursorToPerson(Cursor cursor){
       Final p = new Final();

        state = cursor.getString(MySQLiteHelper.FinalColum.State.ordinal());
            p.setState(state);

         t = cursor.getString(MySQLiteHelper.FinalColum.Type.ordinal());
            p.setType(t);
        String name = cursor.getString(MySQLiteHelper.FinalColum.Name.ordinal());
        p.setName(name);
            String des = cursor.getString(MySQLiteHelper.FinalColum.Description.ordinal());
            p.setDescription(des);

            return p;
    }
}
