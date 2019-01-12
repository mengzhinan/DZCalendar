package com.duke.dzcalendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.duke.calendarlib.bean.MonthBean;
import com.duke.calendarlib.core.CalendarDataSource;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        MonthBean monthBean = CalendarDataSource.getMonthBean(System.currentTimeMillis());


        Log.v("test","test");
    }
}
