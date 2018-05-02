package com.utils.rekha.alarmapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, RingAlarm.class);
        PendingIntent pendingIntent= PendingIntent.getActivity(this,12,intent,PendingIntent.FLAG_CANCEL_CURRENT );
        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Calendar calendar =Calendar.getInstance();
        //calendar.setTime(new Date());

       // calendar.add(Calendar.MINUTE, 5);
        long triggerTime = calendar.getTimeInMillis() +( 30*1000) ;
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+( 30*1000),
                10*1000, pendingIntent);
    }}
