package com.duke.calendarlib.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duke.calendarlib.core.CalendarDataSource;
import com.duke.calendarlib.core.MonthHeader;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-13 18:43
 * @ Description:
 */
public class MonthHeadLayout extends LinearLayout {
    private MonthHeader[] monthHeaders = CalendarDataSource.getMonthHeaders();

    public MonthHeadLayout(Context context) {
        this(context, null, 0);
    }

    public MonthHeadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonthHeadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = MeasureSpec.getSize(widthMeasureSpec);
        if (getChildCount() != 7) {
            removeAllViews();
            TextView textView;
            for (int i = 0; i < monthHeaders.length; i++) {
                textView = new TextView(getContext());
                textView.setLayoutParams(new ViewGroup.LayoutParams(width / 7, ViewGroup.LayoutParams.MATCH_PARENT));
                textView.setText(monthHeaders[i].getChineseNumber());
                textView.setGravity(Gravity.CENTER);
                addView(textView);
            }
        }

    }

    public TextView[] getTextViews() {
        TextView[] textViews = new TextView[getChildCount()];
        View view;
        for (int i = 0; i < textViews.length; i++) {
            view = getChildAt(i);
            if (view instanceof TextView) {
                textViews[i] = (TextView) getChildAt(i);
            }
        }
        return textViews;
    }
}
