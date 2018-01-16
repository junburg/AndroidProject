package com.makeveryday.ahnjunhyeock.doday.WriteTask;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.makeveryday.ahnjunhyeock.doday.SingleFragmentActivity;
import com.makeveryday.ahnjunhyeock.doday.Task.TaskListActivity;

/**
 * Created by ahnjunhyeock on 2017. 12. 4..
 */

public class WriteTaskActivity extends SingleFragmentActivity {

    private static final String EXTRA_TASK_ID =
            "com.makeveryday.android.doday.task_id";

    @Override
    protected Fragment createFragment() {
        return new WriteTaskFragment();
    }

    public static Intent newIntent(Context packageContext, long position) {
        Intent intent = new Intent(packageContext, WriteTaskActivity.class);
        intent.putExtra(EXTRA_TASK_ID, position);
        return intent;
    }

}
