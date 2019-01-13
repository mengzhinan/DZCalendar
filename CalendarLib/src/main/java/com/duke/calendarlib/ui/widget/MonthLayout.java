package com.duke.calendarlib.ui.widget;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.duke.calendarlib.R;
import com.duke.calendarlib.core.CalendarDataSource;
import com.duke.calendarlib.ui.adapter.MonthRecyclerViewAdapter;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-13 18:45
 * @ Description:
 */
public class MonthLayout extends LinearLayout {
    private RecyclerView recyclerView;
    private MonthRecyclerViewAdapter monthAdapter;
    private int monthWidth = 0;
    // 当前月份某一时间点的毫秒数
    private long timeMillis;

    public MonthLayout(Context context) {
        this(context, null, 0);
    }

    public MonthLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MonthLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.duke_calendar_month_layout, this, false);
        recyclerView = view.findViewById(R.id.duke_calendar_recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 7));
        monthAdapter = new MonthRecyclerViewAdapter();
        recyclerView.setAdapter(monthAdapter);
        addView(view);
    }

    /**
     * 设置 月份 数据
     *
     * @param timeMillis 当月任意时间的毫秒数，生产出当月所有的日期
     */
    public void setData(long timeMillis) {
        this.timeMillis = timeMillis;
        if (monthWidth > 0) {
            monthAdapter.setData(CalendarDataSource.getMonthBean(timeMillis), monthWidth);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        if (monthWidth != width) {
            monthWidth = width;
            monthAdapter.setData(CalendarDataSource.getMonthBean(timeMillis), monthWidth);
        }
    }
}
