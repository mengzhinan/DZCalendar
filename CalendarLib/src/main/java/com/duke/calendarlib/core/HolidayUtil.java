package com.duke.calendarlib.core;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 21:59
 * @ Description:
 */
public class HolidayUtil {
    private static final String JSON_NAME = "holiday.json";
    private static JSONObject holidayJSONObject;
    private static HolidayUtil instance;

    private HolidayUtil(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(JSON_NAME);
            byte[] buffer = new byte[inputStream.available()];
            int dataLength = inputStream.read(buffer);
            String jsonString = new String(buffer, 0, dataLength);
            holidayJSONObject = new JSONObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    inputStream = null;
                }
            }
        }
    }

    public static synchronized HolidayUtil getInstance(Context context) {
        if (context == null || context.getResources() == null) {
            throw new IllegalArgumentException("In HolidayUtil.java getInstance() param context is null");
        }
        if (instance == null) {
            instance = new HolidayUtil(context);
        }
        return instance;
    }

    public HolidayType getHolidayOfSomeDay(long timeMillis) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(timeMillis);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            String monthStr = month < 10 ? ("0" + month) : ("" + month);
            JSONArray jsonArray = holidayJSONObject.optJSONArray(year + monthStr);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int value = jsonArray.optInt(day);

            if (value == HolidayType.REST.getIntValue()) {
                return HolidayType.REST;
            } else if (value == HolidayType.WORK.getIntValue()) {
                return HolidayType.WORK;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return HolidayType.NONE;
    }
}
