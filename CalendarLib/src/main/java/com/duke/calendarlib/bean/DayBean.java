package com.duke.calendarlib.bean;

import android.support.annotation.NonNull;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:30
 * @ Description:
 */
public class DayBean {

    // 当天日期的毫秒数，忽略时分秒部分数据
    private long dayMilliseconds;
    // 当天日期的数字形式
    private int dayNumber;
    // 一个月中的第几个星期
    private int weekNumber;
    // 是否是当月的日期(用于区分月头月末处的日期)
    private boolean isInCurrentMonth;

    @NonNull
    @Override
    public String toString() {
        return "DayBean:" +
                "\n dayMilliseconds = " + dayMilliseconds +
                "\n dayNumber = " + dayNumber +
                "\n weekNumber = " + weekNumber +
                "\n isInCurrentMonth = " + isInCurrentMonth;
    }

    public long getDayMilliseconds() {
        return dayMilliseconds;
    }

    public void setDayMilliseconds(long dayMilliseconds) {
        this.dayMilliseconds = dayMilliseconds;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public boolean isInCurrentMonth() {
        return isInCurrentMonth;
    }

    public void setInCurrentMonth(boolean inCurrentMonth) {
        isInCurrentMonth = inCurrentMonth;
    }
}
