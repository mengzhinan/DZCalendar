package com.duke.calendarlib.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.duke.calendarlib.R;
import com.duke.calendarlib.ui.adapter.MonthViewPagerAdapter;
import com.duke.calendarlib.ui.fragment.MonthFragment;
import com.duke.calendarlib.ui.util.DataUtil;
import com.duke.calendarlib.ui.widget.MonthHeadLayout;

import java.util.ArrayList;

public class MonthActivity extends AppCompatActivity {
    private MonthHeadLayout monthHeadLayout;
    private ViewPager viewPager;
    private MonthViewPagerAdapter adapter;
    private ArrayList<Fragment> fragmentArrayList;
    private int currentMonthIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duke_calendar_activity_month);
        monthHeadLayout = findViewById(R.id.month_header_layout);
        initData(1970, 2039);
        viewPager = findViewById(R.id.month_view_pager);
        adapter = new MonthViewPagerAdapter(getSupportFragmentManager(), fragmentArrayList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentMonthIndex);
        viewPager.setOffscreenPageLimit(3);
    }

    private void initData(int yearStart, int yearEnd) {
        ArrayList<Long> monthTimeMillisList = new ArrayList<Long>((yearEnd - yearStart) * 12);
        currentMonthIndex = DataUtil.getIndexAndComputeTimeMillisArray(monthTimeMillisList, yearStart, yearEnd);
        int size = monthTimeMillisList.size();
        fragmentArrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            fragmentArrayList.add(MonthFragment.newInstance(monthTimeMillisList.get(i), false));
        }
    }
}
