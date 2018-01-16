package com.makeveryday.ahnjunhyeock.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by ahnjunhyeock on 2017. 11. 30..
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
