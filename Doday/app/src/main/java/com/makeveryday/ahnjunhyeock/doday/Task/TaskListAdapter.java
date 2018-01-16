package com.makeveryday.ahnjunhyeock.doday.Task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeveryday.ahnjunhyeock.doday.R;

import java.util.ArrayList;

/**
 * Created by ahnjunhyeock on 2017. 11. 28..
 */

public class TaskListAdapter extends BaseAdapter {

    private ArrayList<TaskListItem> taskListItemsArray = new ArrayList<>();

    TextView taskTxt;
    ImageView deleteTaskList;

    public TaskListAdapter() {
    }

    @Override
    public int getCount() {
        return taskListItemsArray.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.task_list_item, parent, false);
        }

        taskTxt = (TextView) convertView.findViewById(R.id.date_text);
        deleteTaskList = (ImageView)convertView.findViewById(R.id.delete_date_list);

        deleteTaskList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(pos);
            }
        });

        TaskListItem taskListItem = taskListItemsArray.get(position);

        taskTxt.setText(taskListItem.getTask());

        return convertView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return taskListItemsArray.get(position);
    }

    public void addItem(String task) {
        TaskListItem taskListItem = new TaskListItem();

        taskListItem.setTask(task);
        taskListItemsArray.add(taskListItem);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        taskListItemsArray.remove(getItem(position));
        notifyDataSetChanged();
    }
}
