package org.master.android.androidbasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.MessageFormat;
import java.util.Observable;
import java.util.Observer;

public class MVCPatternActivity extends AppCompatActivity implements Observer {

    private Model mModel ;
    private Button btn1 , btn2 , btn3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvcpattern);
        mModel = new Model();
        mModel.addObserver(this);
        btn1 = findViewById(R.id.btn_one) ;
        btn2 = findViewById(R.id.btn_two) ;
        btn3 = findViewById(R.id.btn_three) ;

        btn1.setOnClickListener(v-> setValue(0) );
        btn2.setOnClickListener(v-> setValue(1) );
        btn3.setOnClickListener(v-> setValue(2) );
    }

    void setValue(int index){
        mModel.setValueAtIndex(index);
    }

    @Override
    public void update(Observable o, Object arg) {
        btn1.setText(MessageFormat.format("Count: {0}", mModel.getValueAtIndex(0)));
        btn2.setText(MessageFormat.format("Count: {0}", mModel.getValueAtIndex(1)));
        btn3.setText(MessageFormat.format("Count: {0}", mModel.getValueAtIndex(2)));
    }
}
