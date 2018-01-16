package com.makeveryday.ahnjunhyeock.appcopystudy.Main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.BeginFragment;
import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.ComputerArchFragment;
import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.DatabaseFragment;
import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.NetworkFragment;
import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.ProgrammingLangFragment;
import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.SoftwareEngFragment;
import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.DataStrFragment;
import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.AlgorithmFragment;
import com.makeveryday.ahnjunhyeock.appcopystudy.FirstTab.OperatingSysFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahnjunhyeock on 2017. 12. 8..
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private static final int NUMBER_OF_LOOPS = 10000;

    protected List<Fragment> fragments = new ArrayList<>();
    protected String[] title = new String[]{
            "요이땅",
            "컴퓨터 구조",
            "소프트웨어 공학",
            "프로그래밍 언어",
            "자료구조",
            "알고리즘",
            "운영체제",
            "데이터 베이스",
            "네트워크"
    };

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new BeginFragment());
        fragments.add(new ComputerArchFragment());
        fragments.add(new SoftwareEngFragment());
        fragments.add(new ProgrammingLangFragment());
        fragments.add(new DataStrFragment());
        fragments.add(new AlgorithmFragment());
        fragments.add(new OperatingSysFragment());
        fragments.add(new DatabaseFragment());
        fragments.add(new NetworkFragment());

    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position % fragments.size());
    }

    @Override
    public String getPageTitle(int position) {
        return title[position % fragments.size()];
    }

    public int getCenterPosition(int position) {
        return fragments.size() * NUMBER_OF_LOOPS / 2 + position;
    }

    @Override
    public int getCount() {
        return fragments.size() * NUMBER_OF_LOOPS;
    }

    public Fragment getValueAt(int position) {
        if (fragments.size() == 0) {
            return null;
        }
        return fragments.get(position % fragments.size());
    }

}
