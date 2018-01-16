package com.makeveryday.ahnjunhyeock.doday.Date;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;

import com.makeveryday.ahnjunhyeock.doday.R;
import com.makeveryday.ahnjunhyeock.doday.Task.TaskListActivity;

import java.util.Calendar;

/**
 * Created by ahnjunhyeock on 2017. 11. 28..
 */

public class DateListFragment extends Fragment {

    int year;
    int month;
    int day;
    String setDateString;

    DatePickerDialog datePickerDialog;
    Calendar calendar;
    ImageView addDateImg;
    ListView dateList;
    DateListAdapter dateListAdapter;
    DateListItem dateListItem;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dateListAdapter = new DateListAdapter();

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DATE);

        datePickerDialog = new DatePickerDialog(getActivity(), dateListener, year, month, day);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.date_list_fragment, container, false);
        dateList = (ListView)v.findViewById(R.id.date_list);
        dateList.setAdapter(dateListAdapter);
        dateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = TaskListActivity.newIntent(getActivity(), dateListAdapter.getItemId(position));
                startActivity(intent);
            }
        });

        addDateImg=(ImageView)v.findViewById(R.id.date_add_btn);
        addDateImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        return v;
    }

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            setDateString = year + "." + (monthOfYear+1) + "." + dayOfMonth;
            dateListAdapter.addItem(setDateString);
        }
    };
}
