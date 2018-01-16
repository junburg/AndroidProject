package com.example.gyeongsuk.underthefield.main.Domestic;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.gyeongsuk.underthefield.main.MainActivity;

/**
 * Created by Gyeongsuk on 2016-12-16.
 */
public class MyWebViewClient extends WebViewClient {

    @Override
    public void onPageFinished(WebView view, String url){
        super.onPageFinished(view, url);
        MainActivity.cd.dismiss();
    }
}
