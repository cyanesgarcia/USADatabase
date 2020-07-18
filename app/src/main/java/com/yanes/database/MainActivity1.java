package com.yanes.database;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by claud on 4/20/2018.
 */

public class MainActivity1 extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button album = (Button)findViewById(R.id.album);
        album.setOnClickListener(this);
        Button about_us= (Button) findViewById(R.id.about_us);
        about_us.setOnClickListener(this);
        Button resource= (Button) findViewById(R.id.resources);
        resource.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.album){
            Intent intent=new Intent(this,States.class);
            startActivity(intent);

        }else if(view.getId() == R.id.about_us){
            Intent intent=new Intent(this,Aboutus.class);
            startActivity(intent);

        }else if(view.getId() == R.id.resources){
            Intent intent=new Intent(this,Resources.class);
            startActivity(intent);

        }
    }
}
