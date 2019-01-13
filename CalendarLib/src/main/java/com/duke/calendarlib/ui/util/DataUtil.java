package com.duke.calendarlib.ui.util;

import com.duke.calendarlib.core.util.CalendarUtil;

import java.util.ArrayList;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 15:22
 * @ Description:
 */
public class DataUtil {

    public static boolean isEmpty(String text) {
        return (text == null || "".equals(text.trim()));
    }

    public static int getIndexAndComputeTimeMillisArray(ArrayList<Long> list) {
        return getIndexAndComputeTimeMillisArray(list, 1901, 2099);
    }

    public static int getIndexAndComputeTimeMillisArray(ArrayList<Long> list, int yearStart, int yearEnd) {
        long currentTime = System.currentTimeMillis();
        int currentYear = CalendarUtil.getYearNumber(currentTime);
        int currentMonth = CalendarUtil.getMonthNumber(currentTime);
        int index = 0;
        for (int i = yearStart; i <= yearEnd; i++) {
            for (int j = 0; j < 12; j++) {
                if (i == currentYear && j == currentMonth) {
                    index = (i - yearStart) * 12 + j;
                }
                list.add(CalendarUtil.getMonthTimeMillis(i, j));
            }
        }
        return index;
    }


}
