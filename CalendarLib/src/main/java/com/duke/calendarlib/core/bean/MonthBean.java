package com.duke.calendarlib.core.bean;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:30
 * @ Description:
 */
public class MonthBean {

    // 当前约月数，月份默认是0-11
    private int monthNumber;

    private ArrayList<DayBean[]> dayArrayList;

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public ArrayList<DayBean[]> getDayArrayList() {
        return dayArrayList;
    }

    public void setDayArrayList(ArrayList<DayBean[]> dayArrayList) {
        this.dayArrayList = dayArrayList;
    }
}
