package com.duke.calendarlib.core;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-13 17:57
 * @ Description:
 */
public enum HolidayType {

    NONE(0, "无"),
    REST(1, "休息"),
    WORK(2, "上班");

    private int intValue;
    private String chineseName;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    HolidayType(int intValue, String chineseName) {
        this.intValue = intValue;
        this.chineseName = chineseName;
    }
}
