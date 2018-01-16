package com.makeveryday.ahnjunhyeock.doday.Date;

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

public class DateListAdapter extends BaseAdapter {

    private ArrayList<DateListItem> dateListItemsArray = new ArrayList<DateListItem>();

    public DateListAdapter() {

    }

    @Override
    public int getCount() {
        return dateListItemsArray.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.date_list_item, parent, false);
        }

        TextView dateTxt = (TextView) convertView.findViewById(R.id.date_text);
        ImageView deleteDateList = (ImageView)convertView.findViewById(R.id.delete_date_list);

        deleteDateList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteItem(pos);
            }
        });

        DateListItem dateListItem = dateListItemsArray.get(position);

        dateTxt.setText(dateListItem.getDate());

        return convertView;


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return dateListItemsArray.get(position);
    }

    public void addItem(String date) {
        DateListItem dateListItem = new DateListItem();

        dateListItem.setDate(date);
        dateListItemsArray.add(dateListItem);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        dateListItemsArray.remove(getItem(position));
        notifyDataSetChanged();
    }

}
