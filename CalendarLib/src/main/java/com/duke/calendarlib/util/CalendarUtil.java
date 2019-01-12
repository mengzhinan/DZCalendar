package com.duke.calendarlib.util;

import java.util.Calendar;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 15:24
 * @ Description:
 */
public class CalendarUtil {

    public static boolean isLeapYear(long currentTimeMillis) {
        return isLeapYear(getYearNumber(currentTimeMillis));
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
     * 获取一个月中的星期总数
     *
     * @param currentTimeMillis
     * @return
     */
    public static int getWeekNumberOfMonth(long currentTimeMillis) {
        return getNumberOf(getSomeDayTimeMillis(currentTimeMillis, getDaysNumber(currentTimeMillis)), Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取当月某天的毫秒数
     *
     * @param currentTimeMillis
     * @param dayNumber
     * @return
     */
    public static long getSomeDayTimeMillis(long currentTimeMillis, int dayNumber) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        // 这个月的1号
        calendar.set(Calendar.DAY_OF_MONTH, dayNumber);
        return calendar.getTimeInMillis();
    }

    /**
     * 获取当月1号是一个星期中的第几天
     *
     * @param currentTimeMillis
     * @return
     */
    public static int getFirstDayOfWeekIndex(long currentTimeMillis) {
        return getDayNumberOfWeek(getSomeDayTimeMillis(currentTimeMillis, 1));
    }

    /**
     * 获取 currentTimeMillis 代表的日期是一个星期中的第几天，获取到的数值顺序对应代表顺序是 <br />
     * SUNDAY(日), MONDAY(一), TUESDAY(二), WEDNESDAY(三), THURSDAY(四), FRIDAY(五), SATURDAY(六) <br />
     * 获取到的数值范围是：1 ~ 7 <br />
     *
     * @param currentTimeMillis
     * @return
     */
    public static int getDayNumberOfWeek(long currentTimeMillis) {
        return getNumberOf(currentTimeMillis, Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取一个月中的总天数
     *
     * @param currentTimeMillis
     * @return
     */
    public static int getDaysNumber(long currentTimeMillis) {
        int[] monthArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        monthArray[1] = isLeapYear(currentTimeMillis) ? 29 : 28;
        return monthArray[getMonthNumber(currentTimeMillis)];
    }

    /**
     * 获取月份数据，比喻 11。注意月份从0 ~ 11
     *
     * @param currentTimeMillis
     * @return
     */
    public static int getMonthNumber(long currentTimeMillis) {
        return getNumberOf(currentTimeMillis, Calendar.MONTH);
    }

    /**
     * 获取年份数据，比喻 2018
     *
     * @param currentTimeMillis
     * @return
     */
    public static int getYearNumber(long currentTimeMillis) {
        return getNumberOf(currentTimeMillis, Calendar.YEAR);
    }

    private static int getNumberOf(long currentTimeMillis, int calendarType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        return calendar.get(calendarType);
    }
}
