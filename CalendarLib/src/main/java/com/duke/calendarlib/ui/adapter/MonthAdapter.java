package com.duke.calendarlib.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.duke.calendarlib.R;
import com.duke.calendarlib.bean.DayBean;
import com.duke.calendarlib.bean.MonthBean;

/**
 * @ Author: duke
 * @ DateTime: 2019-01-12 22:21
 * @ Description:
 */
public class MonthAdapter extends RecyclerView.Adapter<MonthAdapter.Holder> {
    private MonthBean monthBean;
    private int recyclerViewWidth;

    public void setData(MonthBean monthBean, int recyclerViewWidth) {
        this.monthBean = monthBean;
        this.recyclerViewWidth = recyclerViewWidth;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.duke_calendar_day_layout, viewGroup, false);
        return new Holder(view, recyclerViewWidth / 7);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        int line = i / 7;
        int index = i % 7;
        DayBean dayBean = monthBean.getDayArrayList().get(line)[index];
        holder.dayTextView.setText(String.valueOf(dayBean.getDayNumber()));
        holder.subDayTextView.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        if (monthBean == null || monthBean.getDayArrayList() == null) {
            return 0;
        }
        return monthBean.getDayArrayList().size() * 7;
    }

    public static class Holder extends RecyclerView.ViewHolder {
        private RelativeLayout root;
        private TextView dayTextView; // 阳历日期文本显示
        private TextView subDayTextView; // 农历或节日文本显示
        private ImageView holidayImageView; // 休班标记

        public Holder(@NonNull View view, int length) {
            super(view);
            root = view.findViewById(R.id.duke_calendar_day_view_root);
            dayTextView = view.findViewById(R.id.duke_calendar_day_text);
            subDayTextView = view.findViewById(R.id.duke_calendar_day_sub_text);
            holidayImageView = view.findViewById(R.id.duke_calendar_day_holiday_flag);
            ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
            }
            layoutParams.width = length;
            layoutParams.height = length;
            root.setLayoutParams(layoutParams);
        }
    }
}