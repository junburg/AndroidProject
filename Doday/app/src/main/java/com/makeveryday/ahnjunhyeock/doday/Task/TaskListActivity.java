package com.makeveryday.ahnjunhyeock.doday.Task;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.makeveryday.ahnjunhyeock.doday.SingleFragmentActivity;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ahnjunhyeock on 2017. 12. 4..
 */

public class TaskListActivity extends SingleFragmentActivity {

    private static final String EXTRA_DATE_ID =
            "com.makeveryday.android.doday.date_id";

    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }
    public static Intent newIntent(Context packageContext, long position) {
        Intent intent = new Intent(packageContext, TaskListActivity.class);
        intent.putExtra(EXTRA_DATE_ID, position);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
}
