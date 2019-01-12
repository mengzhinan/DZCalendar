package com.duke.calendarlib.util;

import com.duke.calendarlib.bean.MonthBean;
import com.duke.calendarlib.bean.WeekBean;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:28
 * @ Description: 构造月份中的 日 数据
 */
public class DataUtil {

    public static int test(long currentTimeMillis) {
        return CalendarUtil.getWeekNumberOfMonth(currentTimeMillis);
    }

    /**
     * 获取对应月份的数据
     *
     * @param currentTimeMillis 当前月份任意时间的毫秒数
     * @return
     */
    public static MonthBean getMonthBean(long currentTimeMillis) {
        MonthBean monthBean = new MonthBean();
        ArrayList<WeekBean> weekBeanArrayList = getWeekBeanList(currentTimeMillis);
        monthBean.setWeekList(weekBeanArrayList);
        monthBean.setMonthNumber(CalendarUtil.getMonthNumber(currentTimeMillis));
        return monthBean;
    }

    private static ArrayList<WeekBean> getWeekBeanList(long currentTimeMillis) {
        ArrayList<WeekBean> weekList = new ArrayList<>(6);
        // 获取当前月份的总天数
        int daysOfMonth = CalendarUtil.getDaysNumber(currentTimeMillis);
        // 获取当前月的1号是星期几
        int firstDayToWeekIndex = CalendarUtil.getFirstDayOfWeekIndex(currentTimeMillis);
        // 获取当前月的星期数
        int weeksOfMonth = CalendarUtil.getWeekNumberOfMonth(currentTimeMillis);


        return weekList;
    }

}
