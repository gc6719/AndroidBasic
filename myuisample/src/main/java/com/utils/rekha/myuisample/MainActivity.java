package com.utils.rekha.myuisample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button send_me , gone , invisible , visible , showList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_me = ((Button) findViewById(R.id.send_me));

        gone = ((Button) findViewById(R.id.gone));
        invisible = ((Button) findViewById(R.id.invisible));
        visible = ((Button) findViewById(R.id.visible));

       // send_me.setText("Main Activity");
        send_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class) ;
                startActivity(intent);
            }
        });


        visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class) ;
                startActivity(intent);
            }
        });


        invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class) ;
                startActivity(intent);
            }
        });


        gone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class) ;
                startActivity(intent);
            }
        });


        showList = (Button)findViewById(R.id.showlist);
        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });

    }
}
