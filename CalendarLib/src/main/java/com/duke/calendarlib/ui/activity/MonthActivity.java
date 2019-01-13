package com.duke.calendarlib.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.duke.calendarlib.R;
import com.duke.calendarlib.core.CalendarDataSource;
import com.duke.calendarlib.ui.adapter.MonthAdapter;

public class MonthActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MonthAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duke_calendar_activity_month);
        recyclerView = findViewById(R.id.duke_calendar_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 7));
        adapter = new MonthAdapter();
        adapter.setData(CalendarDataSource.getMonthBean(System.currentTimeMillis()), getResources().getDisplayMetrics().widthPixels);
        recyclerView.setAdapter(adapter);
    }
}
