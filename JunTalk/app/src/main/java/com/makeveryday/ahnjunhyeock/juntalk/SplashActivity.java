package com.makeveryday.ahnjunhyeock.juntalk;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

/*
앱 로딩에 필요한 액티비티를 정의한다.
 */
public class SplashActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    // Firebase의 RmoteConfig은 앱을 업데이트 하지 않고도 앱의 동작과 모양을 변경할 수 있다.
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 화면의 상태표시줄을 보이지 않게 한다.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        linearLayout = (LinearLayout) findViewById(R.id.splashActivity_linearLayout);

        // RemoteConfig 인스턴스를 가져오고 개발자 모드로 사용 설정
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        mFirebaseRemoteConfig.setConfigSettings(configSettings);

        // 기본 구성값 설정
        mFirebaseRemoteConfig.setDefaults(R.xml.default_config);

        // fetch()로 서버의 값을 가져오는 것이 성공하면, activateFetched()로 값을 앱에 적용한다.
        mFirebaseRemoteConfig.fetch(0)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            mFirebaseRemoteConfig.activateFetched();
                        } else {
                        }
                        displayMessage();
                    }
                });
    }

    /*
      특정 상황(ex: 서버 점검)에서 RemoteConfig를 이용해 다이얼로그를 띄운다.
     */
    void displayMessage() {

        // RemoteConfig에서 설정한 매개변수의 값들을 가져온다.
        String splash_background = mFirebaseRemoteConfig.getString("splash_background");
        boolean caps = mFirebaseRemoteConfig.getBoolean("splash_message_caps");
        String splash_message = mFirebaseRemoteConfig.getString("splash_message");

        linearLayout.setBackgroundColor(Color.parseColor(splash_background));

        // caps의 값이 true이면 다이얼로그에 splash_message를 set하고 띄운다. false이면 LoginActivity로 넘어간다.
        if (caps) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(splash_message).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            builder.create().show();
        } else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }

    }
}
