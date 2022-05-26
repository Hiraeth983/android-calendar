package com.haibin.calendar.custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import com.haibin.calendar.Article;
import com.haibin.calendar.ArticleAdapter;
import com.haibin.calendar.R;
import com.haibin.calendar.base.activity.BaseActivity;
import com.haibin.calendar.colorful.ColorfulActivity;
import com.haibin.calendar.group.GroupItemDecoration;
import com.haibin.calendar.group.GroupRecyclerView;
import com.haibin.calendar.index.IndexActivity;
import com.haibin.calendar.schedule.ScheduleActivity;
import com.haibin.calendar.simple.SimpleActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomActivity extends BaseActivity implements
        CalendarView.OnCalendarSelectListener,
        CalendarView.OnYearChangeListener,
        View.OnClickListener {

    TextView mTextMonthDay;

    TextView mTextYear;

    TextView mTextLunar;

    TextView mTextCurrentDay;

    CalendarView mCalendarView;

    RelativeLayout mRelativeTool;

    private int mYear;

    CalendarLayout mCalendarLayout;

    GroupRecyclerView mRecyclerView;

    private FloatingActionButton mCurrentDay;

    private FloatingActionButton mAddScheduleFloatButton;

    public static void show(Context context) {
        context.startActivity(new Intent(context, CustomActivity.class));
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void initView() {
        setStatusBarDarkMode();
        mTextMonthDay = findViewById(R.id.tv_month_day);

        mTextYear = findViewById(R.id.tv_year);

        mTextLunar = findViewById(R.id.tv_lunar);

        mRelativeTool = findViewById(R.id.rl_tool);

        mCalendarView = findViewById(R.id.calendarView);

        // 设置当前日期定位悬浮按钮监听事件
        mCurrentDay = findViewById(R.id.currentDay);
        mCurrentDay.hide();
        mCurrentDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendarView.scrollToCurrent();
                mCurrentDay.hide();
            }
        });

        // 设置新建日程悬浮按钮监听事件
        mAddScheduleFloatButton = findViewById(R.id.addSchedule);
        mAddScheduleFloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        // 设置对应日期的日历图片 formatter.format(date)
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        Date date = new Date(System.currentTimeMillis());
        int day = Integer.parseInt(formatter.format(date));
        switch (day) {
            case 1:
                mCurrentDay.setImageResource(R.mipmap.ic_1);
                break;
            case 2:
                mCurrentDay.setImageResource(R.mipmap.ic_2);
                break;
            case 3:
                mCurrentDay.setImageResource(R.mipmap.ic_3);
                break;
            case 4:
                mCurrentDay.setImageResource(R.mipmap.ic_4);
                break;
            case 5:
                mCurrentDay.setImageResource(R.mipmap.ic_5);
                break;
            case 6:
                mCurrentDay.setImageResource(R.mipmap.ic_6);
                break;
            case 7:
                mCurrentDay.setImageResource(R.mipmap.ic_7);
                break;
            case 8:
                mCurrentDay.setImageResource(R.mipmap.ic_8);
                break;
            case 9:
                mCurrentDay.setImageResource(R.mipmap.ic_9);
                break;
            case 10:
                mCurrentDay.setImageResource(R.mipmap.ic_10);
                break;
            case 11:
                mCurrentDay.setImageResource(R.mipmap.ic_11);
                break;
            case 12:
                mCurrentDay.setImageResource(R.mipmap.ic_12);
                break;
            case 13:
                mCurrentDay.setImageResource(R.mipmap.ic_13);
                break;
            case 14:
                mCurrentDay.setImageResource(R.mipmap.ic_14);
                break;
            case 15:
                mCurrentDay.setImageResource(R.mipmap.ic_15);
                break;
            case 16:
                mCurrentDay.setImageResource(R.mipmap.ic_16);
                break;
            case 17:
                mCurrentDay.setImageResource(R.mipmap.ic_17);
                break;
            case 18:
                mCurrentDay.setImageResource(R.mipmap.ic_18);
                break;
            case 19:
                mCurrentDay.setImageResource(R.mipmap.ic_19);
                break;
            case 20:
                mCurrentDay.setImageResource(R.mipmap.ic_20);
                break;
            case 21:
                mCurrentDay.setImageResource(R.mipmap.ic_21);
                break;
            case 22:
                mCurrentDay.setImageResource(R.mipmap.ic_22);
                break;
            case 23:
                mCurrentDay.setImageResource(R.mipmap.ic_23);
                break;
            case 24:
                mCurrentDay.setImageResource(R.mipmap.ic_24);
                break;
            case 25:
                mCurrentDay.setImageResource(R.mipmap.ic_25);
                break;
            case 26:
                mCurrentDay.setImageResource(R.mipmap.ic_26);
                break;
            case 27:
                mCurrentDay.setImageResource(R.mipmap.ic_27);
                break;
            case 28:
                mCurrentDay.setImageResource(R.mipmap.ic_28);
                break;
            case 29:
                mCurrentDay.setImageResource(R.mipmap.ic_29);
                break;
            case 30:
                mCurrentDay.setImageResource(R.mipmap.ic_30);
                break;
            case 31:
                mCurrentDay.setImageResource(R.mipmap.ic_31);
                break;
            default:
                break;
        }

        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCalendarLayout.isExpand()) {
                    mCalendarLayout.expand();
                    return;
                }
                mCalendarView.showYearSelectLayout(mYear);
                mTextLunar.setVisibility(View.GONE);
                mTextYear.setVisibility(View.GONE);
                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });
        mCalendarLayout = findViewById(R.id.calendarLayout);
        mCalendarView.setOnCalendarSelectListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
    }

    @Override
    protected void initData() {
        int year = mCalendarView.getCurYear();
        int month = mCalendarView.getCurMonth();

        Map<String, Calendar> map = new HashMap<>();
        map.put(getSchemeCalendar(year, month, 3, 0xFF40db25, "假").toString(),
                getSchemeCalendar(year, month, 3, 0xFF40db25, "假"));
        map.put(getSchemeCalendar(year, month, 6, 0xFFe69138, "事").toString(),
                getSchemeCalendar(year, month, 6, 0xFFe69138, "事"));
        map.put(getSchemeCalendar(year, month, 9, 0xFFdf1356, "议").toString(),
                getSchemeCalendar(year, month, 9, 0xFFdf1356, "议"));
        map.put(getSchemeCalendar(year, month, 13, 0xFFedc56d, "记").toString(),
                getSchemeCalendar(year, month, 13, 0xFFedc56d, "记"));
        map.put(getSchemeCalendar(year, month, 14, 0xFFedc56d, "记").toString(),
                getSchemeCalendar(year, month, 14, 0xFFedc56d, "记"));
        map.put(getSchemeCalendar(year, month, 15, 0xFFaacc44, "假").toString(),
                getSchemeCalendar(year, month, 15, 0xFFaacc44, "假"));
        map.put(getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记").toString(),
                getSchemeCalendar(year, month, 18, 0xFFbc13f0, "记"));
        map.put(getSchemeCalendar(year, month, 25, 0xFF13acf0, "假").toString(),
                getSchemeCalendar(year, month, 25, 0xFF13acf0, "假"));
        map.put(getSchemeCalendar(year, month, 27, 0xFF13acf0, "多").toString(),
                getSchemeCalendar(year, month, 27, 0xFF13acf0, "多"));
        //此方法在巨大的数据量上不影响遍历性能，推荐使用
        mCalendarView.setSchemeDate(map);


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new GroupItemDecoration<String, Article>());
        mRecyclerView.setAdapter(new ArticleAdapter(this));
        mRecyclerView.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_flyme:
                CustomActivity.show(this);
                break;
            case R.id.ll_simple:
                SimpleActivity.show(this);
                break;
            case R.id.ll_colorful:
                ColorfulActivity.show(this);
                break;
            case R.id.ll_index:
                IndexActivity.show(this);
                break;
        }
    }

    private Calendar getSchemeCalendar(int year, int month, int day, int color, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(color);//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800, "假");
        calendar.addScheme(0xFF008800, "节");
        return calendar;
    }

    @Override
    public void onCalendarOutOfRange(Calendar calendar) {

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onCalendarSelect(Calendar calendar, boolean isClick) {
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
        if (isClick) {
            mCurrentDay.show();
        }
        Log.e("onDateSelected", "  -- " + calendar.getYear() +
                "  --  " + calendar.getMonth() +
                "  -- " + calendar.getDay() +
                "  --  " + isClick + "  --   " + calendar.getScheme());
    }

    @Override
    public void onYearChange(int year) {
        mTextMonthDay.setText(String.valueOf(year));
    }


}
