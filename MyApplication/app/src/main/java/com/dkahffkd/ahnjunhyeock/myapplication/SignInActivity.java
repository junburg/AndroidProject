package com.dkahffkd.ahnjunhyeock.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SignInActivity extends AppCompatActivity {

    private EditText mUserIdIn;
    private EditText mUserPwIn;
    private Button mSignInBtn;
    private Button mSignUpBtn;

    private String sUserIdIn;
    private String sUserPwIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mUserIdIn = (EditText) findViewById(R.id.sign_in_id);
        mUserPwIn = (EditText) findViewById(R.id.sign_in_pw);

        mSignInBtn = (Button) findViewById(R.id.sign_in_btn);
        mSignInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sUserIdIn = mUserIdIn.getText().toString();
                sUserPwIn = mUserPwIn.getText().toString();
                String result = null;
                try {

                    CustomTask task = new CustomTask();
                    result = task.execute(sUserIdIn, sUserPwIn).get();
                    Log.i("리턴 값", result);
                } catch (Exception e) {

                }

                Intent i = new Intent(SignInActivity.this, LoginSuccessActivity.class);
                i.putExtra("result", result);
                startActivity(i);


            }

        });

        mSignUpBtn = (Button) findViewById(R.id.sign_up_btn);
        mSignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });
    }




 class CustomTask extends AsyncTask<String, Void, String> {
    String sendMsg, receiveMsg;

    @Override
    protected String doInBackground(String... strings) {
        try {
            String str;
            URL url = new URL("https://code.lds.org/nexus/content/groups/main-repo");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestMethod("POST");
            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
            sendMsg = "id=" + strings[0] + "&pw=" + strings[1];
            osw.write(sendMsg);
            osw.flush();
            if (conn.getResponseCode() == conn.HTTP_OK) {
                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "EUC-KR");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuffer buffer = new StringBuffer();
                while ((str = reader.readLine()) != null) {
                    buffer.append(str);
                }
                receiveMsg = buffer.toString();

            } else {
                Log.i("통신 결과", conn.getResponseCode() + "에러");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receiveMsg;
    }
}
}
