package com.duke.calendarlib.core;

import com.duke.calendarlib.core.bean.DayBean;
import com.duke.calendarlib.core.bean.MonthBean;
import com.duke.calendarlib.core.enums.MonthHeaderType;
import com.duke.calendarlib.core.util.CalendarUtil;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:28
 * @ Description: 构造月份中的 日 数据
 */
public class CalendarDataSource {

    /**
     * 获取日历头文本枚举
     *
     * @return
     */
    public static MonthHeaderType[] getMonthHeaderEnums() {
        return new MonthHeaderType[]{MonthHeaderType.SUNDAY,
                MonthHeaderType.MONDAY,
                MonthHeaderType.TUESDAY,
                MonthHeaderType.WEDNESDAY,
                MonthHeaderType.THURSDAY,
                MonthHeaderType.FRIDAY,
                MonthHeaderType.SATURDAY};
    }

    /**
     * 获取对应月份的数据
     *
     * @param timeMillis 当前月份任意时间的毫秒数
     * @return
     */
    public static MonthBean getMonthBean(long timeMillis) {
        MonthBean monthBean = new MonthBean();
        ArrayList<DayBean> dayList = getDayList(timeMillis, monthBean);
        monthBean.setDayList(dayList);
        monthBean.setMonthNumber(CalendarUtil.getMonthNumber(timeMillis));
        return monthBean;
    }

    private static ArrayList<DayBean> getDayList(long timeMillis, MonthBean monthBean) {
        // 获取当前月的星期数，比喻 6
        int weeksOfMonth = CalendarUtil.getTotalWeeksOfMonth(timeMillis);
        ArrayList<DayBean> dayList = new ArrayList<>(weeksOfMonth * 7);
        // 获取当前月份的总天数
        int daysOfMonth = CalendarUtil.getDaysNumber(timeMillis);
        monthBean.setCurrentMonthDays(daysOfMonth);
        // 获取当前月的1号是星期几(1-7)(数组索引是从0开始的)
        int listPosition = CalendarUtil.getFirstDayOfWeekIndex(timeMillis) - 1;

        int headEmptyIndex = listPosition - 1;
        // 处理月头部分日期(上个月月末的天数)
        addPreviousMonthEndDays(dayList, headEmptyIndex, timeMillis);

        // 下一个月1号对应的最后一个星期的索引
        int nextMonthWeekIndex = listPosition + daysOfMonth;

        // 天数标记值
        int dayIndex = 1;
        // 记录 week 数组的数量
        int weekNumber = 1;
        DayBean dayBean;
        do {
            dayBean = getDayBean(timeMillis, dayIndex, true, weekNumber);
            dayList.add(dayBean);
            dayIndex++;
            listPosition++;
            if (listPosition % 7 == 0) {
                listPosition = 0;
                // 一个星期的数据处理完成，切换到下一个星期
                weekNumber++;
            }
        } while (dayIndex <= daysOfMonth);

        // 处理月末的数据，即下一个月月初的几天数据，添加到当前月月末中
        addNextMonthStartDays(dayList, timeMillis, nextMonthWeekIndex, weeksOfMonth);

        return dayList;
    }

    private static void addPreviousMonthEndDays(ArrayList<DayBean> dayList, int headEmptyIndex, long timeMillis) {
        // 记录第一个数组最后一个空位的索引，目的是为了添加前一个月月末的几天数据
        if (headEmptyIndex < 0) {
            // 避免当前月初无空缺日期的情况，无需添加上一个月月初的数据
            headEmptyIndex = 0;
        }
        // 获取上一个月的总天数 - (这个月月头的空缺位置) = 当前月第一个星期的第一个index对应上个月的哪一天
        int previousMonthDays = CalendarUtil.getPreviousMonthDaysNumber(timeMillis);
        int previousMonthWeekStart = previousMonthDays - headEmptyIndex;
        DayBean dayBean;
        for (int i = previousMonthWeekStart; i <= previousMonthDays; i++) {
            dayBean = getDayBean(timeMillis, i, false, 1);
            dayBean.setWeekEnd(CalendarUtil.isWeekEnd(CalendarUtil.getPreviousMonthTimeMillis(timeMillis), i));
            dayBean.setDayMilliseconds(CalendarUtil.getSomeDayTimeMillis(CalendarUtil.getPreviousMonthTimeMillis(timeMillis), i));
            dayList.add(dayBean);
        }
    }

    /**
     * 把下一个月月初的几天，添加到当前月的最后一个星期数组中
     *
     * @param timeMillis
     */
    private static void addNextMonthStartDays(ArrayList<DayBean> dayList, long timeMillis, int startIndex, int totalWeekNumber) {
        int nextMonthDayIndex = 1;
        DayBean dayBean;
        for (int i = startIndex; i < totalWeekNumber * 7; i++) {
            dayBean = getDayBean(timeMillis, nextMonthDayIndex, false, totalWeekNumber);
            dayBean.setDayMilliseconds(CalendarUtil.getSomeDayTimeMillis(CalendarUtil.getNextMonthTimeMillis(timeMillis), nextMonthDayIndex));
            dayBean.setWeekEnd(CalendarUtil.isWeekEnd(CalendarUtil.getNextMonthTimeMillis(timeMillis), nextMonthDayIndex));
            dayList.add(dayBean);
            nextMonthDayIndex++;
        }
    }

    private static DayBean getDayBean(long timeMillis, int dayNumber, boolean isInCurrentMonth, int weekNumber) {
        DayBean dayBean = new DayBean();
        dayBean.setDayMilliseconds(CalendarUtil.getSomeDayTimeMillis(timeMillis, dayNumber));
        dayBean.setDayNumber(dayNumber);
        dayBean.setWeekNumber(weekNumber);
        dayBean.setWeekEnd(CalendarUtil.isWeekEnd(timeMillis, dayNumber));
        dayBean.setInCurrentMonth(isInCurrentMonth);
        return dayBean;
    }
}
