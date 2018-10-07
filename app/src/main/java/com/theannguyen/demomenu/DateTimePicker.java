package com.theannguyen.demomenu;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class DateTimePicker extends AppCompatActivity {

    DatePicker datePicker;
    TimePicker timePicker;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);

        //datePicker = (DatePicker) findViewById(R.id.dpDate);
        timePicker = (TimePicker) findViewById(R.id.tpTime);

        setupDatePicker();
        setupTimePicker();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setupTimePicker() {
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(DateTimePicker.this,hourOfDay + "- " + minute,Toast.LENGTH_SHORT ).show();
            }
        });
    }

    private void setupDatePicker() {
//        Calendar calendar = Calendar.getInstance();
//        int month = calendar.get(calendar.MONTH);
//        int year  = calendar.get(calendar.YEAR);
//        final int day   = calendar.get(calendar.DAY_OF_MONTH);
//
//        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                Toast.makeText(DateTimePicker.this,"Day : " + dayOfMonth + "",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
