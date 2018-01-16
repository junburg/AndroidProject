package com.example.gyeongsuk.underthefield.main;

import android.app.Activity;
import android.widget.Toast;

/**
 * Created by Gyeongsuk on 2016-12-18.
 */

public class BackPressClose {

    private long backKeyPressedTime = 0;
    private Toast toast;

    private Activity activity;

    public BackPressClose(Activity activity){
        this.activity=activity;
    }

    public void onBackPressed() {

        if (isAfter2Seconds()) {
            backKeyPressedTime = System.currentTimeMillis();

            toast = Toast.makeText(activity, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다. 음악을 계속 켜두시려면 " +
                    "홈버튼을 눌러 나가시면 됩니다.", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        if (isBefore2Seconds()) {
            programShutdown();
            toast.cancel();
        }
    }
    private Boolean isAfter2Seconds(){
        return System.currentTimeMillis()>backKeyPressedTime+2000;
    }

    private Boolean isBefore2Seconds(){
        return System.currentTimeMillis()<=backKeyPressedTime+2000;
    }

    private void programShutdown(){
        activity.moveTaskToBack(true);
        activity.finish();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
