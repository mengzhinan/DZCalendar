package com.duke.calendarlib.bean;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:30
 * @ Description:
 */
public class DayBean {

    // 当天日期的数字形式
    public int dayNumber;

    // 当天日期的毫秒数，忽略时分秒部分数据
    public long dayMilliseconds;

    // 当天的日期在这周中是第几天
    public int dayNumberInWeek;

    // 是否是当月的日期(用于区分月头月末处的日期)
    public boolean isInCurrentMonth;

    // 是否是当天日期
    public boolean isEqualCurrentDay;

    // 是否是过期的日期(是否超过当天的日期)

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

    public boolean isOverdueDay;


}
