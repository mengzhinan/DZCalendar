package com.duke.calendarlib.bean;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:47
 * @ Description:
 */
public class WeekBean {

    // 一个月中的第几个星期
    public int weekNumber;

    public ArrayList<DayBean> dayList;

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public ArrayList<DayBean> getDayList() {
        return dayList;
    }

    public void setDayList(ArrayList<DayBean> dayList) {
        this.dayList = dayList;
    }
}
