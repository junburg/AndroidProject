package com.dkahffkd.ahnjunhyeock.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginSuccessActivity extends AppCompatActivity {

    private TextView mCheck;
    private TextView mCheckIdPw;
    private String sCheckIdPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        mCheck = (TextView)findViewById(R.id.login_text);
        mCheckIdPw = (TextView)findViewById(R.id.login_check);

        Intent i = getIntent();
        sCheckIdPw = i.getExtras().getString("result");
        mCheckIdPw.setText(sCheckIdPw);
    }
}
