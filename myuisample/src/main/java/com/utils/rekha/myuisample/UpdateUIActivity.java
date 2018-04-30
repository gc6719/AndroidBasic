package com.utils.rekha.myuisample;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateUIActivity extends AppCompatActivity {

    Switch swt_main, swt_switch_two, swt_switch_three;
    TextView txt_switch_two, txt_switch_three, txt_swt_status;
    RadioGroup radio_grp_notiofy;
    RadioButton radio_auto, radio_manual;
    ImageView img_auto, img_manual;

    void initView() {

        //Notification Radio Group
        radio_auto = (RadioButton) findViewById(R.id.radio_auto);
        radio_manual = (RadioButton) findViewById(R.id.radio_manual);
        radio_grp_notiofy = (RadioGroup) findViewById(R.id.radio_grp_notiofy);
        img_auto = (ImageView) findViewById(R.id.img_auto);
        img_manual = (ImageView) findViewById(R.id.img_manual);

        //Main Switch View
        swt_main = (Switch) findViewById(R.id.swt_main);
        txt_swt_status = (TextView) findViewById(R.id.txt_swt_status);


        txt_switch_two = (TextView) findViewById(R.id.txt_switch_two);
        swt_switch_two = (Switch) findViewById(R.id.swt_switch_two);

        txt_switch_three = (TextView) findViewById(R.id.txt_switch_three);
        swt_switch_three = (Switch) findViewById(R.id.swt_switch_three);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ui);
        initView();


        // Set Layout Status
        setLayoutEnabled(swt_main.isChecked());
        swt_main.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setLayoutEnabled(buttonView.isChecked());
            }
        });

        // Set Notification view
        setNotificationOption(radio_auto.isChecked());
        radio_grp_notiofy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                setNotificationOption (checkedId == radio_auto.getId()) ;
            }
        });

        img_auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Auto setting",Toast.LENGTH_SHORT).show();
            }
        });

        img_manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Manual setting",Toast.LENGTH_SHORT).show();
            }
        });
    }


    void setNotificationOption(boolean isAuto) {
        img_auto.setEnabled(isAuto);
        img_manual .setEnabled(!isAuto);
        img_auto.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), isAuto ? R.color.text_color : R.color.text_color_disabled));
        img_manual.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), isAuto ? R.color.text_color_disabled : R.color.text_color));

    }


    void setLayoutEnabled(boolean isEnabled) {
        txt_swt_status.setText(isEnabled ? "No" : "Off");
        txt_switch_two.setEnabled(isEnabled);
        txt_switch_three.setEnabled(isEnabled);
        swt_switch_two.setEnabled(isEnabled);
        swt_switch_three.setEnabled(isEnabled);

    }


}
