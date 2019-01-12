package com.duke.calendarlib.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:58
 * @ Description:
 */
public class WeekLayout extends LinearLayout {
    public WeekLayout(Context context) {
        this(context, null, 0);
    }

    public WeekLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeekLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 横向布局
        setOrientation(LinearLayout.HORIZONTAL);
    }
}
