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
    private ArrayList<DayBean> dayList;
    // 保存当月的天数
    private int currentMonthDays;

    public int getCurrentMonthDays() {
        return currentMonthDays;
    }

    public void setCurrentMonthDays(int currentMonthDays) {
        this.currentMonthDays = currentMonthDays;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public ArrayList<DayBean> getDayList() {
        return dayList;
    }

    public void setDayList(ArrayList<DayBean> dayList) {
        this.dayList = dayList;
    }
}
