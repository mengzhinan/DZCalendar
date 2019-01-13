package com.duke.calendarlib.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-13 21:28
 * @ Description:
 */
public class MonthViewPagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> list;

    public MonthViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
