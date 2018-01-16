package com.makeveryday.ahnjunhyeock.healthcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView startTimeTxt, endTimeTxt, diffTimeTxt;
    private Button setStartTimeBtn, setEndTimeBtn, setDiffTimeBtn, setListBtn;
    private String startTime, endTime;
    private Calendar calendar;
    private AboutTime at1;
    private AboutTime at2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendar = Calendar.getInstance();

        at1 = new AboutTime();
        at2 = new AboutTime();

        startTimeTxt = (TextView) findViewById(R.id.start_time_txt);
        endTimeTxt = (TextView) findViewById(R.id.end_time_txt);
        diffTimeTxt = (TextView)findViewById(R.id.diff_start_end_txt);

        setStartTimeBtn = (Button) findViewById(R.id.set_start_time_btn);
        setStartTimeBtn.setOnClickListener(this);
        setEndTimeBtn = (Button) findViewById(R.id.set_end_time_btn);
        setEndTimeBtn.setOnClickListener(this);
        setDiffTimeBtn = (Button)findViewById(R.id.set_diff_start_end_btn);
        setDiffTimeBtn.setOnClickListener(this);
        setListBtn = (Button)findViewById(R.id.set_list_btn);
        setListBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        int diffTotalSecond = 0;
        switch (v.getId()) {
            case R.id.set_start_time_btn:
                startTimeTxt.setText(getTime(at1));
                break;
            case R.id.set_end_time_btn:
                endTimeTxt.setText(getTime(at2));
                break;
            case R.id.set_diff_start_end_btn:
                diffTotalSecond = getTotalSecond(at2) - getTotalSecond(at1);
                diffTimeTxt.setText(getDiffTime(diffTotalSecond));
                break;

        }
    }


    private String getTime(AboutTime at) {
        at.setHour(calendar.get(Calendar.HOUR_OF_DAY));
        at.setMinute(calendar.get(Calendar.MINUTE));
        at.setSecond(calendar.get(Calendar.SECOND));

        return at.getStringTime();

    }

    private int getTotalSecond(AboutTime at) {
        int hourToSecond = at.getHour() * 60 * 60;
        int minuteToSecond = at.getMinute() * 60;
        int second = at.getSecond();

        return hourToSecond + minuteToSecond + second;
    }

    private String getDiffTime(int diffTotalSecond) {
        int diffHour = diffTotalSecond / (60 * 60);
        int diffMinute = diffTotalSecond % (60 * 60) / 60;
        int diffSecond = diffTotalSecond % (60 * 60) % 60;

        return diffHour + ":" + diffMinute + ":" + diffSecond;
    }


}
