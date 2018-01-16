package com.makeveryday.ahnjunhyeock.doday.Date;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.makeveryday.ahnjunhyeock.doday.SingleFragmentActivity;

/**
 * Created by ahnjunhyeock on 2017. 12. 4..
 */

public class DateListActivity extends SingleFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new DateListFragment();
    }
}
