package com.duke.calendarlib.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 14:53
 * @ Description:
 */
public class DayLayout extends RelativeLayout {
    public DayLayout(Context context) {
        this(context, null, 0);
    }

    public DayLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DayLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
