package com.henry.calendarviewsample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.henry.calendarview.DatePickerController;
import com.henry.calendarview.DayPickerView;
import com.henry.calendarview.SimpleMonthAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DayPickerView dayPickerView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        dayPickerView = (DayPickerView) findViewById(R.id.dpv_calendar);

        DayPickerView.DataModel dataModel = new DayPickerView.DataModel();
        dataModel.yearStart = 2018;
        dataModel.monthStart = 0;
        dataModel.monthCount = 2;
        dataModel.defTag = "￥100";
        dataModel.leastDaysNum = 0;
        dataModel.mostDaysNum = 0;

        List<SimpleMonthAdapter.CalendarDay> invalidDays = new ArrayList<>();
        SimpleMonthAdapter.CalendarDay invalidDay1 = new SimpleMonthAdapter.CalendarDay(2018, 11, 10);
        SimpleMonthAdapter.CalendarDay invalidDay2 = new SimpleMonthAdapter.CalendarDay(2018, 11, 11);

        SimpleMonthAdapter.CalendarDay invalidDay3 = new SimpleMonthAdapter.CalendarDay(2018, 11, 12);
        invalidDays.add(invalidDay1);
        invalidDays.add(invalidDay2);
        invalidDays.add(invalidDay3);
        dataModel.invalidDays = invalidDays;

        List<SimpleMonthAdapter.CalendarDay> busyDays = new ArrayList<>();
        SimpleMonthAdapter.CalendarDay busyDay1 = new SimpleMonthAdapter.CalendarDay(2018, 11, 20);
        busyDay1.setTag("10箱");
        SimpleMonthAdapter.CalendarDay busyDay2 = new SimpleMonthAdapter.CalendarDay(2018, 11, 21);
        busyDay2.setTag("20箱");
        SimpleMonthAdapter.CalendarDay busyDay3 = new SimpleMonthAdapter.CalendarDay(2018, 11, 22);
        busyDay3.setTag("30箱");
        busyDays.add(busyDay1);
        busyDays.add(busyDay2);
        busyDays.add(busyDay3);
//        dataModel.busyDays = busyDays;

        dataModel.mNegativeDays = busyDays;


//        SimpleMonthAdapter.CalendarDay startDay = new SimpleMonthAdapter.CalendarDay(2016, 6, 5);
//        SimpleMonthAdapter.CalendarDay endDay = new SimpleMonthAdapter.CalendarDay(2016, 6, 20);
//        SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay> selectedDays = new SimpleMonthAdapter.SelectedDays<>(startDay, endDay);
//        dataModel.selectedDays = selectedDays;

        SimpleMonthAdapter.CalendarDay tag = new SimpleMonthAdapter.CalendarDay(2018, 11, 15);
        tag.setTag("标签1");

        SimpleMonthAdapter.CalendarDay tag2 = new SimpleMonthAdapter.CalendarDay(2018, 11, 16);
        tag2.setTag("标签2");
        List<SimpleMonthAdapter.CalendarDay> tags = new ArrayList<>();
        tags.add(tag);
        tags.add(tag2);
        dataModel.tags = tags;

        dayPickerView.setParameter(dataModel, new DatePickerController() {
            @Override
            public void onDayOfMonthSelected(SimpleMonthAdapter.CalendarDay calendarDay) {
                Toast.makeText(context, "onDayOfMonthSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDateRangeSelected(List<SimpleMonthAdapter.CalendarDay> selectedDays) {
                Toast.makeText(context, "onDateRangeSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void alertSelectedFail(FailEven even) {
                Toast.makeText(context, "alertSelectedFail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
