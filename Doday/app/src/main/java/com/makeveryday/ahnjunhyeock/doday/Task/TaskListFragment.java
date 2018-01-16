package com.makeveryday.ahnjunhyeock.doday.Task;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.makeveryday.ahnjunhyeock.doday.R;
import com.makeveryday.ahnjunhyeock.doday.WriteTask.WriteTaskActivity;

/**
 * Created by ahnjunhyeock on 2017. 11. 28..
 */

public class TaskListFragment extends Fragment {

    TaskListAdapter taskListAdapter;
    ImageView addTaskImg;
    TextView taskDateTxt;
    ListView taskList;
    String taskDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.task_list_fragment, container, false);

        taskDateTxt = (TextView)v.findViewById(R.id.task_date_txt);
        taskDateTxt.setText(taskDate);

        taskList = (ListView)v.findViewById(R.id.task_list);
        taskList.setAdapter(taskListAdapter);

        addTaskImg = (ImageView)v.findViewById(R.id.task_add_btn);
        addTaskImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WriteTaskActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}


