package com.example.gyeongsuk.underthefield.start;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gyeongsuk.underthefield.R;
import com.example.gyeongsuk.underthefield.main.MainActivity;
import com.matthewtamlin.sliding_intro_screen_library.indicators.DotIndicator;

public class StartActivity extends AppCompatActivity {

    DotIndicator indicator;
    ViewPager startPager;
    ImageView startIv;
    TextView tv;
    Button startBtn;
    FirstTextFragment ftf;
    SecondTextFragment stf;
    ThirdTextFragment ttf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startPager = (ViewPager)findViewById(R.id.startPager);

        ftf = new FirstTextFragment();
        stf = new SecondTextFragment();
        ttf = new ThirdTextFragment();

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        startPager.setAdapter(adapter);
        startPager.setOffscreenPageLimit(3);

        indicator = (DotIndicator)findViewById(R.id.indicator);
        indicator.setSelectedDotColor(Color.parseColor("#00257b"));
        indicator.setUnselectedDotColor(Color.parseColor("#ffffff"));
        indicator.setSpacingBetweenDotsDp(40);
        indicator.setSelectedDotDiameterDp(15);
        indicator.setUnselectedDotDiameterDp(10);

        final int pageCount = adapter.getCount();
        indicator.setNumberOfItems(pageCount);

//        Runnable setImageRunnable = new Runnable(){
//
//            @Override
//            public void run() {
//
//                int currentPage = startPager.getCurrentItem();
//                if(currentPage >= (pageCount - 1)) startPager.setCurrentItem( 0, true);
//                else startPager.setCurrentItem(currentPage + 1, true);
//                indicator.setSelectedItem((currentPage + 1 == pageCount)?0 : currentPage + 1, true);
//            }
//
//        };

        startPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                indicator.setSelectedItem(startPager.getCurrentItem(),true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tv = (TextView)findViewById(R.id.startMainText);

        Typeface tf = Typeface.createFromAsset(getAssets(), "harlowsi.ttf");
        tv.setTypeface(tf);

        startIv = (ImageView)findViewById(R.id.startImage);
        startIv.setColorFilter(Color.parseColor("#BDBDBD"), PorterDuff.Mode.MULTIPLY);

        startBtn = (Button)findViewById(R.id.startButton);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
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
                fragment = ftf;
                break;
            case 1:
                fragment = stf;
                break;
            case 2:
                fragment = ttf;
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return 3;
    }
}

}
