package com.makeveryday.ahnjunhyeock.appcopystudy.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.makeveryday.ahnjunhyeock.appcopystudy.R;
import com.nshmura.recyclertablayout.RecyclerTabLayout;

/**
 * Created by ahnjunhyeock on 2017. 12. 3..
 */

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private Toolbar toolBar;
    private ViewPagerAdapter pagerAdapter;
    private RecyclerTabLayout tabLayout;
    private ViewPager viewPager;
    private int scrollState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.main_tool_bar);
        setSupportActionBar(toolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setTitle(R.string.app_name);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.main_view_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(pagerAdapter.getCenterPosition(0));
        viewPager.addOnPageChangeListener(this);

        tabLayout = (RecyclerTabLayout) findViewById(R.id.main_tab);
        tabLayout.setUpWithViewPager(viewPager);

    }


    /*
    ToolBar Menu
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);

    }

    /*
    TabLayout
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        boolean nearLeftEdge = (position <= pagerAdapter.fragments.size());
        boolean nearRightEdge = (position >= pagerAdapter.getCount() - pagerAdapter.fragments.size());
        if (nearLeftEdge || nearRightEdge) {
            viewPager.setCurrentItem(pagerAdapter.getCenterPosition(2), false);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        scrollState = state;
    }

}




