package com.duke.calendarlib.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duke.calendarlib.R;
import com.duke.calendarlib.ui.widget.MonthHeadLayout;
import com.duke.calendarlib.ui.widget.MonthLayout;

public class MonthFragment extends Fragment {
    private static final String MONTH_TIME_MILLIS = "month_time_millis";
    private static final String IS_SHOW_HEADER_VIEW = "is_show_header_view";
    private long monthTimeMillis;
    private boolean isShowHeaderView;
    private MonthLayout monthLayout;
    private MonthHeadLayout monthHeadLayout;

    public MonthFragment() {
    }

    /**
     * @param timeMillis     某月任意时间的毫秒数
     * @param isShowHeadView 是否显示日历表头
     * @return
     */
    public static MonthFragment newInstance(long timeMillis, boolean isShowHeadView) {
        MonthFragment fragment = new MonthFragment();
        Bundle args = new Bundle();
        args.putLong(MONTH_TIME_MILLIS, timeMillis);
        args.putBoolean(IS_SHOW_HEADER_VIEW, isShowHeadView);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            monthTimeMillis = getArguments().getLong(MONTH_TIME_MILLIS);
            isShowHeaderView = getArguments().getBoolean(IS_SHOW_HEADER_VIEW, false);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.duke_calendar_fragment_month, container, false);
        monthHeadLayout = view.findViewById(R.id.month_header_layout);
        monthLayout = view.findViewById(R.id.month_layout);
        monthLayout.setData(monthTimeMillis);
        monthHeadLayout.setVisibility(isShowHeaderView ? View.VISIBLE : View.GONE);
        return view;
    }

    public MonthHeadLayout getMonthHeadLayout() {
        if (isShowHeaderView) {
            return monthHeadLayout;
        }
        return null;
    }
}
