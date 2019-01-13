package com.duke.calendarlib.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-13 18:45
 * @ Description:
 */
public class MonthLayout extends LinearLayout {
    public MonthLayout(Context context) {
        this(context, null, 0);
    }

    public MonthLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonthLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}