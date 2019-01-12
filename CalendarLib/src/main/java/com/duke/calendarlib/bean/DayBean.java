package com.duke.calendarlib.bean;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:30
 * @ Description:
 */
public class DayBean {

    // 当天日期的数字形式
    private int dayNumber;

    // 一个月中的第几个星期
    private int weekNumber;

    // 当天日期的毫秒数，忽略时分秒部分数据
    private long dayMilliseconds;

    // 当天的日期在这周中是第几天
    private int dayNumberInWeek;

    // 是否是当月的日期(用于区分月头月末处的日期)
    private boolean isInCurrentMonth;

    // 是否是当天日期
    private boolean isEqualCurrentDay;

    // 是否是过期的日期(是否超过当天的日期)
    private boolean isOverdueDay;

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public long getDayMilliseconds() {
        return dayMilliseconds;
    }

    public void setDayMilliseconds(long dayMilliseconds) {
        this.dayMilliseconds = dayMilliseconds;
    }

    public int getDayNumberInWeek() {
        return dayNumberInWeek;
    }

    public void setDayNumberInWeek(int dayNumberInWeek) {
        this.dayNumberInWeek = dayNumberInWeek;
    }

    public boolean isInCurrentMonth() {
        return isInCurrentMonth;
    }

    public void setInCurrentMonth(boolean inCurrentMonth) {
        isInCurrentMonth = inCurrentMonth;
    }

    public boolean isEqualCurrentDay() {
        return isEqualCurrentDay;
    }

    public void setEqualCurrentDay(boolean equalCurrentDay) {
        isEqualCurrentDay = equalCurrentDay;
    }

    public boolean isOverdueDay() {
        return isOverdueDay;
    }

    public void setOverdueDay(boolean overdueDay) {
        isOverdueDay = overdueDay;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }
}
