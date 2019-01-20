package com.duke.calendarlib.core.util;

import java.util.Calendar;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 15:24
 * @ Description:
 */
public class CalendarUtil {

    /**
     * 是否是闰年
     *
     * @param timeMillis 当年任意时间的毫秒数
     * @return 是 或 否
     */
    public static boolean isLeapYear(long timeMillis) {
        return isLeapYear(getYearNumber(timeMillis));
    }

    /**
     * 是否是闰年
     *
     * @param year 年份数字
     * @return 是 或 否
     */
    public static boolean isLeapYear(int year) {
//        给定一个年份，判断是否是闰年。满足条件之一：
//        A：能被4整除，并且不能被100整除。
//        或者
//        B：能被400整除。
        boolean isAOK = (year % 4 == 0 && year % 100 != 0);
        boolean isBOK = (year % 400 == 0);
        return isAOK || isBOK;
    }

    /**
     * 获取某种类型的日历数据
     *
     * @param timeMillis   毫秒数
     * @param calendarType 某种日历类型，参考 Calendar 类的常量
     * @return 返回 int 类型的数据，依据 calendarType 类型的含义
     */
    private static int getOfCalendarType(long timeMillis, int calendarType) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        return calendar.get(calendarType);
    }

    /**
     * 获取年份数据，比喻 2018
     *
     * @param timeMillis 一年中任意时间的毫秒数
     * @return 返回对应的年份数字
     */
    public static int getYearNumber(long timeMillis) {
        return getOfCalendarType(timeMillis, Calendar.YEAR);
    }

    /**
     * 获取月份数据，比喻 11。注意月份从0 ~ 11
     *
     * @param timeMillis 当月内任意时间的毫秒数
     * @return 月份数字
     */
    public static int getMonthNumber(long timeMillis) {
        return getOfCalendarType(timeMillis, Calendar.MONTH);
    }

    /**
     * 获取 当前毫秒数 是当月的第多少天
     *
     * @param timeMillis 一个月中某天的毫秒数
     * @return 返回天数数字。第一天数值为1。
     */
    public static int getDayNumberIndexOfMonth(long timeMillis) {
        return getOfCalendarType(timeMillis, Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取 当前毫秒数 是当年的第多少天
     *
     * @param timeMillis 一年中某天的毫秒数
     * @return 返回天数数字。第一天数值为1。
     */
    public static int getDayNumberIndexOfYear(long timeMillis) {
        return getOfCalendarType(timeMillis, Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取 当月某天 是一个月中的第几个星期
     *
     * @param timeMillis 当前毫秒数
     * @param dayNumber  当月中的某天
     * @return 是当月的第几个星期。一个月的第一周数值为1。
     */
    public static int getWeekNumberIndexOfMonth(long timeMillis, int dayNumber) {
        return getOfCalendarType(getTimeMillisByDayNumber(timeMillis, dayNumber), Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取 当前时间 是一年中的第几个星期
     *
     * @param timeMillis 当前毫秒数
     * @return 一年中的第几个星期。一年的第一周数值为1。
     */
    public static int getWeekNumberIndexOfYear(long timeMillis) {
        return getOfCalendarType(timeMillis, Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取 timeMillis 代表的日期是一个星期中的第几天，获取到的数值顺序对应代表顺序是 <br />
     * SUNDAY(日), MONDAY(一), TUESDAY(二), WEDNESDAY(三), THURSDAY(四), FRIDAY(五), SATURDAY(六) <br />
     * 获取到的数值范围是：1 ~ 7 <br />
     *
     * @param timeMillis 当前毫秒数
     * @return 返回当天在一个星期中的索引，或者说当前时间是一个星期中的第几天。
     */
    public static int getDayNumberIndexOfWeek(long timeMillis) {
        return getOfCalendarType(timeMillis, Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取当月总共的星期数量
     *
     * @param timeMillis 当前毫秒数
     * @return 当月总共的星期数
     */
    public static int getTotalWeeksOfMonth(long timeMillis) {
        return getWeekNumberIndexOfMonth(timeMillis, getTotalDayNumbersOfMonth(timeMillis));
    }

    /**
     * 获取当月1号是一个星期中的第几天(或者理解为：当月1号是星期几)
     *
     * @param timeMillis 当前毫秒数
     * @return 当月1号的毫秒数
     */
    public static int getMonthFirstDayIndexInWeek(long timeMillis) {
        return getDayNumberIndexOfWeek(getTimeMillisByDayNumber(timeMillis, 1));
    }

    /**
     * 获取一个月中的总天数
     *
     * @param timeMillis 当前毫秒数
     * @return 返回当月的总天数
     */
    public static int getTotalDayNumbersOfMonth(long timeMillis) {
        return getTotalDayNumbersOfMonth(getYearNumber(timeMillis), getMonthNumber(timeMillis));
    }

    public static int getTotalDayNumbersOfMonth(int year, int month) {
        int[] monthArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        monthArray[1] = isLeapYear(year) ? 29 : 28;
        return monthArray[month];
    }

    /**
     * 获取上一个月的总天数
     *
     * @param timeMillis 当前毫秒数
     * @return 上一个月的总天数
     */
    public static int getPreviousMonthTotalDays(long timeMillis) {
        int year = getYearNumber(timeMillis);
        int month = getMonthNumber(timeMillis);
        month--;
        if (month < 0) {
            //跨年的情况
            month = 11;
            year--;
        }
        return getTotalDayNumbersOfMonth(year, month);
    }

    /**
     * 判断当前日期是否是周末
     *
     * @param timeMillis 当前时间毫秒数
     * @return 是否是周末
     */
    public static boolean isWeekEnd(long timeMillis) {
        int week = getDayNumberIndexOfWeek(timeMillis);
        return week == Calendar.SUNDAY || week == Calendar.SATURDAY;
    }

    /**
     * 获取当月某天的毫秒数
     *
     * @param timeMillis 当前毫秒数
     * @param dayNumber  当月的第几天数值
     * @return 一月中某天的毫秒数
     */
    public static long getTimeMillisByDayNumber(long timeMillis, int dayNumber) {
        return getTimeMillisBy(timeMillis, getYearNumber(timeMillis), getMonthNumber(timeMillis), dayNumber);
    }

    /**
     * 获取某年某月对应当前时间的毫秒数
     *
     * @param timeMillis 当前时间毫秒数
     * @param year       某年年份数值
     * @param month      某月月份数值(月份数值范围为 0~11)
     * @return 某年某月对应当天的毫秒数
     */
    public static long getTimeMillisByYearAndMonth(long timeMillis, int year, int month) {
        int currentYear = getYearNumber(timeMillis);
        int currentMonth = getMonthNumber(timeMillis);
        if (currentYear == year && currentMonth == month) {
            return timeMillis;
        }
        int currentDay = getDayNumberIndexOfMonth(timeMillis);
        int targetDays = getTotalDayNumbersOfMonth(year, month);
        // 月份天数不同(days)，后面对月份做处理时是否会出问题
        return getTimeMillisBy(timeMillis, year, month, min(currentDay, targetDays));
    }

    /**
     * 获取上一个月某天的毫秒数
     *
     * @param timeMillis 当前毫秒数
     * @param dayNumber  上一个月某天
     * @return 上一个月某天毫秒数
     */
    public static long getTimeMillisOfPreviousMonth(long timeMillis, int dayNumber) {
        int year = getYearNumber(timeMillis);
        int month = getMonthNumber(timeMillis);
        month--;
        if (month < 0) {
            month = 11;
            year--;
        }
        return getTimeMillisBy(timeMillis, year, month, dayNumber);
    }

    /**
     * 获取下一个月某天的毫秒数
     *
     * @param timeMillis 当前毫秒数
     * @param dayNumber  下一个月某天
     * @return 下一个月某天毫秒数
     */
    public static long getTimeMillisOfNextMonth(long timeMillis, int dayNumber) {
        int year = getYearNumber(timeMillis);
        int month = getMonthNumber(timeMillis);
        month++;
        if (month > 11) {
            month = 0;
            year++;
        }
        return getTimeMillisBy(timeMillis, year, month, dayNumber);
    }

    /**
     * 获取指定 年、月、日 的毫秒数
     *
     * @param timeMillis 当前毫秒数
     * @param year       指定年份
     * @param month      指定月份
     * @param day        指定日期
     * @return 毫秒数
     */
    private static long getTimeMillisBy(long timeMillis, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMillis);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        // 同义
//        calendar.set(Calendar.DATE, dayNumber);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTimeInMillis();
    }

    private static int min(int a, int b) {
        return a > b ? b : a;
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
