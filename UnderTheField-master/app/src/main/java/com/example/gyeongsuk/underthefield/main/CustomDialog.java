package com.example.gyeongsuk.underthefield.main;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.gyeongsuk.underthefield.R;

/**
 * Created by Gyeongsuk on 2016-12-16.
 */

public class CustomDialog extends Dialog {

    Button btn;

    public CustomDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.custom_dialog);
        btn=(Button)findViewById(R.id.cancelButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.cd.dismiss();
            }
        });


    }

    public CustomDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
