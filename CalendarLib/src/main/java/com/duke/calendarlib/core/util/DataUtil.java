package com.duke.calendarlib.core.util;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 15:22
 * @ Description:
 */
public class DataUtil {

    public static int getTimeMillisArray(ArrayList<Long> list) {
        return getTimeMillisArray(list, 1901, 2099);
    }

    public static int getTimeMillisArray(ArrayList<Long> list, int yearStart, int yearEnd) {
        long currentTime = System.currentTimeMillis();
        int currentYear = CalendarUtil.getYearNumber(currentTime);
        int currentMonth = CalendarUtil.getMonthNumber(currentTime);
        int index = 0;
        for (int i = yearStart; i <= yearEnd; i++) {
            for (int j = 0; j < 12; j++) {
                if (i == currentYear && j == currentMonth) {
                    // 计算当前年月的位置索引
                    index = (i - yearStart) * 12 + j;
                }
                list.add(CalendarUtil.getTimeMillisByYearAndMonth(currentTime, i, j));
            }
        }
        return index;
    }
}
