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
import com.duke.calendarlib.core.enums.MonthHeaderTextType;
import com.duke.calendarlib.core.enums.MonthHeaderType;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-13 18:43
 * @ Description:
 */
public class MonthHeadLayout extends LinearLayout {
    private MonthHeaderType[] monthHeaderEnums = CalendarDataSource.getMonthHeaderEnums();

    public MonthHeadLayout(Context context) {
        this(context, null, 0);
    }

    public MonthHeadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonthHeadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
        TextView textView;
        for (MonthHeaderType monthHeaderEnum : monthHeaderEnums) {
            textView = new TextView(getContext());
            // 后面再设置宽高
            textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            textView.setText(monthHeaderEnum.getChineseNumber());
            textView.setGravity(Gravity.CENTER);
            addView(textView);
        }
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int childCount = getChildCount();
        if (childCount > 0) {
            TextView textView;
            ViewGroup.LayoutParams layoutParams;
            for (int i = 0; i < childCount; i++) {
                if (!(getChildAt(i) instanceof TextView)) {
                    continue;
                }
                textView = (TextView) getChildAt(i);
                layoutParams = textView.getLayoutParams();
                layoutParams.width = width / 7;
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                textView.setLayoutParams(layoutParams);
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

    public void setMonthHeaderTextType(MonthHeaderTextType textType) {
        if (textType == null) {
            return;
        }
        int childCount = getChildCount();
        if (childCount > 0) {
            TextView textView;
            MonthHeaderType monthHeaderType;
            for (int i = 0; i < childCount; i++) {
                if (!(getChildAt(i) instanceof TextView)) {
                    continue;
                }
                monthHeaderType = monthHeaderEnums[i];
                textView = (TextView) getChildAt(i);
                if (textType == MonthHeaderTextType.INT_VALUE) {
                    textView.setText(String.valueOf(monthHeaderType.getIntValue()));
                } else if (textType == MonthHeaderTextType.ENGLISH_SHORT_NAME) {
                    textView.setText(monthHeaderType.getEnglishShortName());
                } else if (textType == MonthHeaderTextType.ENGLISH_FULL_NAME) {
                    textView.setText(monthHeaderType.getEnglishFullName());
                } else if (textType == MonthHeaderTextType.CHINESE_SHORT_NAME) {
                    textView.setText(monthHeaderType.getChineseShortName());
                } else if (textType == MonthHeaderTextType.CHINESE_FULL_NAME) {
                    textView.setText(monthHeaderType.getChineseFullName());
                } else {
                    // MonthHeaderTextType.CHINESE_NUMBER
                    textView.setText(monthHeaderType.getChineseNumber());
                }
            }
        }
    }
}
