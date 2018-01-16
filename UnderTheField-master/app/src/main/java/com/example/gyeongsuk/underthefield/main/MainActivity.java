package com.example.gyeongsuk.underthefield.main;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.example.gyeongsuk.underthefield.R;
import com.example.gyeongsuk.underthefield.main.Domestic.CardAdapterDomestic;
import com.example.gyeongsuk.underthefield.main.Domestic.DomesticFragment;
import com.example.gyeongsuk.underthefield.main.Global.GlobalFragment;
import com.example.gyeongsuk.underthefield.main.History.HistoryFragment;
import com.example.gyeongsuk.underthefield.main.Recommendation.RecFragment;

public class MainActivity extends AppCompatActivity {

    public static boolean first = true;
    public static CustomDialog cd;
    ViewPager pager;
    TabLayout tab;
    DomesticFragment df;
    GlobalFragment gf;
    HistoryFragment hf;
    RecFragment rf;
    ImageView mainIv;
    Context context;
    BackPressClose backPressClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cd = new CustomDialog(this);
        cd.show();

        backPressClose = new BackPressClose(this);
        df = new DomesticFragment();
        gf = new GlobalFragment();
        hf = new HistoryFragment();
        rf = new RecFragment();

        mainIv = (ImageView)findViewById(R.id.mainImage);
        mainIv.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);

        tab = (TabLayout) findViewById(R.id.tab);
        tab.addTab(tab.newTab().setIcon(R.drawable.ic_terrain_black_24dp));
        tab.addTab(tab.newTab().setIcon(R.drawable.ic_public_black_24dp));
        tab.addTab(tab.newTab().setIcon(R.drawable.ic_save_black_24dp));
        tab.addTab(tab.newTab().setIcon(R.drawable.ic_drafts_black_24dp));

        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(4);

        tab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(pager) {

                                         @Override
                                         public void onTabSelected(TabLayout.Tab tab) {
                                             super.onTabSelected(tab);
                                             int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.tabSelectedIconColor);
                                             tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                                         }

                                         @Override
                                         public void onTabUnselected(TabLayout.Tab tab) {
                                             super.onTabUnselected(tab);
                                             int tabIconColor =ContextCompat.getColor(MainActivity.this ,R.color.tabUnselectedIconColor);
                                             tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                                         }

                                         @Override
                                         public void onTabReselected(TabLayout.Tab tab) {
                                             super.onTabReselected(tab);
                                         }
                                     }
        );
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));



    }

    @Override
    public void onBackPressed() {
        backPressClose.onBackPressed();
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {


        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = df;
                    break;
                case 1:
                    fragment = gf;
                    break;
                case 2:
                    fragment = hf;
                    break;
                case 3:
                    fragment = rf;
            }
            return fragment;

        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}