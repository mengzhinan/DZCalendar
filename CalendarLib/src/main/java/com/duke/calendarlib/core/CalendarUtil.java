package com.duke.calendarlib.core;

import java.util.Calendar;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 15:24
 * @ Description:
 */
public class CalendarUtil {

    public static boolean isLeapYear(long timeMillis) {
        return isLeapYear(getYearNumber(timeMillis));
    }

    public static boolean isLeapYear(int year) {
//        给定一个年份，判断是否是闰年。条件为：
//        A：能被4整除，并且不能被100整除。或者
//        B：能被400整除。
        boolean isAOK = (year % 4 == 0 && year % 100 != 0);
        boolean isBOK = (year % 400 == 0);
        return isAOK || isBOK;
    }

    /**
     * 获取当前日期是一个月中的第几个星期
     *
     * @param timeMillis
     * @return
     */
    public static int getWeekNumberOfMonth(long timeMillis, int dayNumber) {
        return getNumberOf(getSomeDayTimeMillis(timeMillis, dayNumber), Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取当前月总共的星期数量
     *
     * @param timeMillis
     * @return
     */
    public static int getTotalWeeksOfMonth(long timeMillis) {
        return getWeekNumberOfMonth(timeMillis, getDaysNumber(timeMillis));
    }

    /**
     * 获取当月某天的毫秒数
     *
     * @param timeMillis
     * @param dayNumber
     * @return
     */
    public static long getSomeDayTimeMillis(long timeMillis, int dayNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        // 这个月的1号
        calendar.set(Calendar.DAY_OF_MONTH, dayNumber);
        return calendar.getTimeInMillis();
    }

    /**
     * 判断当前日期是否是周末
     *
     * @param timeMillis
     * @param dayNumber
     * @return
     */
    public static boolean isWeekEnd(long timeMillis, int dayNumber) {
        timeMillis = getSomeDayTimeMillis(timeMillis, dayNumber);
        int week = getDayNumberOfWeekIndex(timeMillis);
        return week == Calendar.SUNDAY || week == Calendar.SATURDAY;
    }

    public static long getPreviousMonthTimeMillis(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        // 这个月的1号
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        return calendar.getTimeInMillis();
    }

    public static long getNextMonthTimeMillis(long timeMillis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        // 这个月的1号
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当月1号是一个星期中的第几天
     *
     * @param timeMillis
     * @return
     */
    public static int getFirstDayOfWeekIndex(long timeMillis) {
        return getDayNumberOfWeekIndex(getSomeDayTimeMillis(timeMillis, 1));
    }

    /**
     * 获取 timeMillis 代表的日期是一个星期中的第几天，获取到的数值顺序对应代表顺序是 <br />
     * SUNDAY(日), MONDAY(一), TUESDAY(二), WEDNESDAY(三), THURSDAY(四), FRIDAY(五), SATURDAY(六) <br />
     * 获取到的数值范围是：1 ~ 7 <br />
     *
     * @param timeMillis
     * @return
     */
    public static int getDayNumberOfWeekIndex(long timeMillis) {
        return getNumberOf(timeMillis, Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取一个月中的总天数
     *
     * @param timeMillis
     * @return
     */
    public static int getDaysNumber(long timeMillis) {
        int[] monthArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        monthArray[1] = isLeapYear(timeMillis) ? 29 : 28;
        return monthArray[getMonthNumber(timeMillis)];
    }

    public static int getPreviousMonthDaysNumber(long timeMillis) {
        return getDaysNumber(getPreviousMonthTimeMillis(timeMillis));
    }

    public static int getNextMonthDaysNumber(long timeMillis) {
        return getDaysNumber(getNextMonthTimeMillis(timeMillis));
    }

    /**
     * 获取月份数据，比喻 11。注意月份从0 ~ 11
     *
     * @param timeMillis
     * @return
     */
    public static int getMonthNumber(long timeMillis) {
        return getNumberOf(timeMillis, Calendar.MONTH);
    }

    /**
     * 获取年份数据，比喻 2018
     *
     * @param timeMillis
     * @return
     */
    public static int getYearNumber(long timeMillis) {
        return getNumberOf(timeMillis, Calendar.YEAR);
    }

    private static int getNumberOf(long timeMillis, int calendarType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        return calendar.get(calendarType);
    }
}
