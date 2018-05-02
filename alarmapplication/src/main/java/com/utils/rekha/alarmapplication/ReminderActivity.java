package com.utils.rekha.alarmapplication;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class ReminderActivity extends AppCompatActivity {

    Calendar calendar = Calendar.getInstance();
    ImageView dateImg, timeImg, repeatImg, repeatIntervalImg, repeatTypeImg;
    TextView dateTxt, dateEdit, timeTxt, timeEdit, repeatTxt, repeatEdit,
            repeatIntervalTxt, repeatIntervalEdit, repeatTypeTxt, repeatTypeEdit;
    LinearLayout dateLayout, timeLayout, repeatIntervalLayout, repeatTypeLayout;
    RelativeLayout repeatLayout;
    Switch switchButton;
    Button btnstartAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_reminder);
        initViews();
        datePicker();
        timePicker();
        switchFun();
        repeatTypeFun();
        repeatIntClick();

    }

    public void initViews() {
        dateLayout = (LinearLayout) findViewById(R.id.date_layout);
        timeLayout = (LinearLayout) findViewById(R.id.time_layout);
        repeatIntervalLayout = (LinearLayout) findViewById(R.id.repeat_interval_layout);
        repeatTypeLayout = (LinearLayout) findViewById(R.id.repeat_type_layout);
        repeatLayout = (RelativeLayout) findViewById(R.id.repeat_layout);

        switchButton = (Switch) findViewById(R.id.switch_button);

        dateImg = (ImageView) findViewById(R.id.date_img);
        timeImg = (ImageView) findViewById(R.id.time_img);
        repeatImg = (ImageView) findViewById(R.id.repeat_img);
        repeatIntervalImg = (ImageView) findViewById(R.id.repeat_interval_img);
        repeatTypeImg = (ImageView) findViewById(R.id.repeat_type_img);

        dateTxt = (TextView) findViewById(R.id.date_txt);
        dateEdit = (TextView) findViewById(R.id.date_edit);
        timeTxt = (TextView) findViewById(R.id.time_txt);
        timeEdit = (TextView) findViewById(R.id.time_edit);
        repeatTxt = (TextView) findViewById(R.id.repeat_text);
        repeatEdit = (TextView) findViewById(R.id.repeat_edit);
        repeatIntervalTxt = (TextView) findViewById(R.id.repeat_interval_txt);
        repeatIntervalEdit = (TextView) findViewById(R.id.repeat_interval_edit);
        repeatTypeTxt = (TextView) findViewById(R.id.repeat_type_txt);
        repeatTypeEdit = (TextView) findViewById(R.id.repeat_type_edit);
        btnstartAlarm = (Button) findViewById(R.id.start_alarm);
        setDefaults();
        btnstartAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Intent intent = new Intent(ReminderActivity.this, RingAlarm.class);
                PendingIntent pendingIntent= PendingIntent.getActivity(ReminderActivity.this,12,intent,PendingIntent.FLAG_CANCEL_CURRENT );
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+( 30*1000),
                        10*1000, pendingIntent);*/
                startAlarm();
            }
        });
    }


    private void setDefaults() {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        dateEdit.setText(date.format(calendar.getTime()));

        date = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        timeEdit.setText(date.format(calendar.getTime()));
        setreptype("Minute");
        setRepInt("1");

    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateDateEdit();
        }
    };

    TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calendar.set(Calendar.MINUTE, minute);
            updateTimeEdit();
        }
    };

    public void datePicker() {
        dateLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                new DatePickerDialog(ReminderActivity.this, date,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                return false;
            }
        });
    }

    public void updateDateEdit() {
        String myformat = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myformat, Locale.getDefault());
        dateEdit.setText(dateFormat.format(calendar.getTime()));
    }

    public void timePicker() {
        timeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                new TimePickerDialog(ReminderActivity.this, time,
                        calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false).show();
                return false;
            }
        });
    }

    public void updateTimeEdit() {
        String myFormat = "hh:mm a";
        SimpleDateFormat timeFormat = new SimpleDateFormat(myFormat, Locale.getDefault());
        timeEdit.setText(timeFormat.format(calendar.getTime()));
    }

    public void switchFun() {
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    repeatSetVal();
                } else {
                    repeatEdit.setText("OFF");
                }
            }
        });
    }

    public void repeatTypeFun() {

        repeatTypeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                showCustomAlert();
                return false;
            }
        });
    }

    public void showCustomAlert() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.alarm_repeat_type, null);
        TextView minute, hour, day, week, month;

        minute = (TextView) alertLayout.findViewById(R.id.minute);
        hour = (TextView) alertLayout.findViewById(R.id.hour);
        day = (TextView) alertLayout.findViewById(R.id.day);
        week = (TextView) alertLayout.findViewById(R.id.week);
        month = (TextView) alertLayout.findViewById(R.id.month);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(alertLayout);
        builder.setCancelable(false);
        final AlertDialog dialog = builder.create();
        minute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setreptype("Minute");
                dialog.dismiss();
            }
        });
        hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setreptype("Hour");
                dialog.dismiss();
            }
        });
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setreptype("Day");
                dialog.dismiss();
            }
        });
        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setreptype("Week");
                dialog.dismiss();
            }
        });
        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setreptype("Month");
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void setreptype(String type) {
        repeatTypeEdit.setText(type);
        repeatSetVal();
    }

    private void repeatIntClick() {
        repeatIntervalLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                repeatIntervalFun();
                return false;
            }
        });
    }

    public void repeatIntervalFun() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText editText = new EditText(ReminderActivity.this);
        editText.setInputType(EditorInfo.TYPE_CLASS_NUMBER);
        alert.setTitle("Enter Number");
        alert.setView(editText);
        AlertDialog dialog = alert.create();
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String setInt = editText.getText().toString();
                setRepInt(setInt);
                dialog.dismiss();

            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }

    public void setRepInt(String inter) {
        repeatIntervalEdit.setText(inter);
        repeatSetVal();
    }

    private void repeatSetVal() {
        repeatEdit.setText("Every " + repeatIntervalEdit.getText().toString() + " " + repeatTypeEdit.getText().toString() + "(s)");
    }

    private void startAlarm() {
        String date = dateEdit.getText().toString();
        String time = timeEdit.getText().toString();
        int interval = Integer.parseInt(repeatIntervalEdit.getText().toString());
        String type = repeatTypeEdit.getText().toString();
        Boolean repeat = switchButton.isChecked();

        long triggerTime = getTriggerTime(date, time);

        Intent intent = new Intent(this, RingAlarm.class);
        Bundle bundle = new Bundle();
        bundle.putString("value", "TEst");
        intent.putExtra("value", bundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(ReminderActivity.this, 12, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        if (repeat) {
            long repeatTime = getRepeatTime(interval, type);
            if (triggerTime > 0) {

                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, repeatTime, pendingIntent);
                Toast.makeText(this, "Alarm set", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Alarm not set", Toast.LENGTH_SHORT).show();
            }
        } else {
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime, pendingIntent);
            Toast.makeText(this, "Alarm set", Toast.LENGTH_SHORT).show();
        }


    }

    private long getTriggerTime(String date, String time) {
        long v = 0;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy:hh:mm a", Locale.getDefault());
        Calendar tempCal = Calendar.getInstance();
        try {
            tempCal.setTime(format.parse(date + ":" + time));
            Date today = new Date();
            Date d2 = tempCal.getTime();
            v = d2.getTime() - today.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }


        return SystemClock.elapsedRealtime() + v;
    }

    private long getRepeatTime(int interval, String type) {
        long temp = 1000;
        switch (type) {
            case "Minute":
                temp = 60 * temp;
                break;
            case "Hour":
                temp = 60 * 60 * temp;
                break;
            case "Day":
                temp = 24 * 60 * 60 * temp;
                break;
            case "Week":
                temp = 7 * 24 * 60 * 60 * temp;
                break;
            case "Month":
                temp = 30 * 7 * 24 * 60 * 60 * temp;
                break;

        }


        return interval * temp;
    }


}
