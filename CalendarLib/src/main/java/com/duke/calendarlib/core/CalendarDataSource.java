package com.duke.calendarlib.core;

import com.duke.calendarlib.core.bean.DayBean;
import com.duke.calendarlib.core.bean.MonthBean;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:28
 * @ Description: 构造月份中的 日 数据
 */
public class CalendarDataSource {

    public enum MonthHeader {
        SUNDAY(1, "sun", "sunday", "日", "周日", "星期日"),
        MONDAY(2, "mon", "monday", "一", "周一", "星期一"),
        TUESDAY(3, "tue", "tuesday", "二", "周二", "星期二"),
        WEDNESDAY(4, "wed", "wednesday", "三", "周三", "星期三"),
        THURSDAY(5, "thu", "thursday", "四", "周四", "星期四"),
        FRIDAY(6, "fri", "friday", "五", "周五", "星期五"),
        SATURDAY(7, "sat", "saturday", "六", "周六", "星期六");

        private int intValue;
        private String englishShortName;
        private String englishFullName;
        private String chineseNumber;
        private String chineseShortName;
        private String chineseFullName;

        public int getIntValue() {
            return intValue;
        }

        public String getEnglishShortName() {
            return englishShortName;
        }

        public String getEnglishFullName() {
            return englishFullName;
        }

        public String getChineseNumber() {
            return chineseNumber;
        }

        public String getChineseShortName() {
            return chineseShortName;
        }

        public String getChineseFullName() {
            return chineseFullName;
        }

        MonthHeader(int intValue, String englishShortName, String englishFullName,
                    String chineseNumber, String chineseShortName, String chineseFullName) {
            this.intValue = intValue;
            this.englishShortName = englishShortName;
            this.englishFullName = englishFullName;
            this.chineseNumber = chineseNumber;
            this.chineseShortName = chineseShortName;
            this.chineseFullName = chineseFullName;
        }
    }

    /**
     * 获取日历头文本枚举
     *
     * @return
     */
    public static MonthHeader[] getMonthHeaders() {
        return new MonthHeader[]{MonthHeader.SUNDAY,
                MonthHeader.MONDAY,
                MonthHeader.TUESDAY,
                MonthHeader.WEDNESDAY,
                MonthHeader.THURSDAY,
                MonthHeader.FRIDAY,
                MonthHeader.SATURDAY};
    }

    /**
     * 获取对应月份的数据
     *
     * @param timeMillis 当前月份任意时间的毫秒数
     * @return
     */
    public static MonthBean getMonthBean(long timeMillis) {
        MonthBean monthBean = new MonthBean();
        ArrayList<DayBean[]> dayArrayList = getDayArrayList(timeMillis);
        monthBean.setDayArrayList(dayArrayList);
        monthBean.setMonthNumber(CalendarUtil.getMonthNumber(timeMillis));
        return monthBean;
    }

    private static ArrayList<DayBean[]> getDayArrayList(long timeMillis) {
        // 获取当前月的星期数
        int weeksOfMonth = CalendarUtil.getTotalWeeksOfMonth(timeMillis);
        ArrayList<DayBean[]> dayArrayList = new ArrayList<>(weeksOfMonth);
        // 获取当前月份的总天数
        int daysOfMonth = CalendarUtil.getDaysNumber(timeMillis);
        // 获取当前月的1号是星期几(1-7)
        int weekIndex = CalendarUtil.getFirstDayOfWeekIndex(timeMillis) - 1;
        // 记录第一个数组最后一个空位的索引，目的是为了添加前一个月月末的几天数据
        int endEmptyIndex = weekIndex - 1;
        if (endEmptyIndex < 0) {
            // 避免当前月初无空缺日期的情况，无需添加上一个月月初的数据
            endEmptyIndex = 0;
        }
        // 天数标记值
        int dayIndex = 1;
        // 记录 week 数组的数量
        int weekNumber = 1;
        DayBean[] dayWeekArray = new DayBean[7];
        // 记录当前月第一个星期数组对象
        DayBean[] startDayWeekArray = dayWeekArray;
        dayArrayList.add(dayWeekArray);
        do {
            dayWeekArray[weekIndex] = getDayBean(timeMillis, dayIndex, true, weekNumber);
            dayIndex++;
            weekIndex++;
            if (weekIndex >= 7) {
                // 一个星期的数据处理完成，切换到下一个星期
                weekIndex = 0;
                weekNumber++;
                dayWeekArray = new DayBean[7];
                dayArrayList.add(dayWeekArray);
            }
        } while (dayIndex <= daysOfMonth);

        // 处理月头的数据，即上一个月月末的几天数据，添加到当前月月头中
        addPreviousMonthEndDays(startDayWeekArray, endEmptyIndex, timeMillis);

        // 处理月末的数据，即下一个月月初的几天数据，添加到当前月月末中
        addNextMonthStartDays(dayWeekArray, timeMillis, weekNumber);
        return dayArrayList;
    }

    private static void addPreviousMonthEndDays(DayBean[] dayWeekArray, int endEmptyIndex, long timeMillis) {
        // 获取上一个月的总天数
        int previousMonthDays = CalendarUtil.getPreviousMonthDaysNumber(timeMillis);
        for (int i = endEmptyIndex; i >= 0; i--) {
            dayWeekArray[i] = getDayBean(timeMillis, previousMonthDays, false, 1);
            previousMonthDays--;
        }
    }

    /**
     * 把下一个月月初的几天，添加到当前月的最后一个星期数组中
     *
     * @param dayWeekArray
     * @param timeMillis
     */
    private static void addNextMonthStartDays(DayBean[] dayWeekArray, long timeMillis, int weekNumber) {
        int nextMonthDayIndex = 1;
        // dayWeekArray 数组就是当前月最后一个星期的数组
        for (int i = 0; i < dayWeekArray.length; i++) {
            if (dayWeekArray[i] != null) {
                continue;
            }
            dayWeekArray[i] = getDayBean(timeMillis, nextMonthDayIndex, false, weekNumber);
            nextMonthDayIndex++;
        }
    }

    private static DayBean getDayBean(long timeMillis, int dayNumber, boolean isInCurrentMonth, int weekNumber) {
        DayBean dayBean = new DayBean();
        dayBean.setDayMilliseconds(CalendarUtil.getSomeDayTimeMillis(timeMillis, dayNumber));
        dayBean.setDayNumber(dayNumber);
        dayBean.setWeekNumber(weekNumber);
        dayBean.setInCurrentMonth(isInCurrentMonth);
        return dayBean;
    }
}
