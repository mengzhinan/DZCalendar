package com.duke.calendarlib.core.enums;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-13 14:28
 * @ Description:
 */
public enum MonthHeaderType {

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

    MonthHeaderType(int intValue, String englishShortName, String englishFullName,
                    String chineseNumber, String chineseShortName, String chineseFullName) {
        this.intValue = intValue;
        this.englishShortName = englishShortName;
        this.englishFullName = englishFullName;
        this.chineseNumber = chineseNumber;
        this.chineseShortName = chineseShortName;
        this.chineseFullName = chineseFullName;
    }

}
