package com.duke.calendarlib.bean;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:30
 * @ Description:
 */
public class MonthBean {

    // 当前约月数，月份默认是0-11
    public int monthNumber;

    public ArrayList<WeekBean> weekList;

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public ArrayList<WeekBean> getWeekList() {
        return weekList;
    }

    public void setWeekList(ArrayList<WeekBean> weekList) {
        this.weekList = weekList;
    }
}
