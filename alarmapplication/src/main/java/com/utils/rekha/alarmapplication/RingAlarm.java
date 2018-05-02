package com.utils.rekha.alarmapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class RingAlarm extends AppCompatActivity {
    MediaPlayer mp=null;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ring_alarm);
        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Button stopAlarm = (Button)findViewById(R.id.stopo_alarm);
        mp= MediaPlayer.create(getBaseContext(), R.raw.ttt);
        stopAlarm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mp.stop();
                finish();
                return false;
            }
        });
        playSound(this, getAlarmUri());

        Button cancelAlarm = (Button)findViewById(R.id.cancel_alarm);
        cancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                PendingIntent pendingIntent = PendingIntent.getActivity(RingAlarm.this,12,intent, PendingIntent.FLAG_CANCEL_CURRENT);

               // pendingIntent.cancel();
                alarmManager.cancel(pendingIntent);
                mp.stop();
                finish();

            }
        });

    }

    private  void playSound(final Context context, Uri alert)
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mp.start();
                } catch (Throwable t) {
                    Log.d("Animation", "Thread Exception" + t);
                }
            }
        });
        thread.start();
    }
    @Override
    protected  void  onDestroy()
    {
        super.onDestroy();
        mp.stop();
    }

    private  Uri getAlarmUri()
    {
        Uri alert= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alert==null)
        {
            alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            if (alert==null)
            {
                alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
            }
        }
        return alert;
    }
}
