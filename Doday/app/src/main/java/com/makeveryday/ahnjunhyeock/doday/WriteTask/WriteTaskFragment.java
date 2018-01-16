package com.makeveryday.ahnjunhyeock.doday.WriteTask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.makeveryday.ahnjunhyeock.doday.R;
import com.makeveryday.ahnjunhyeock.doday.Task.TaskListAdapter;

import io.realm.Realm;

/**
 * Created by ahnjunhyeock on 2017. 11. 28..
 */

public class WriteTaskFragment extends Fragment {
    TextView timeTxt, startTimeTxt, toTxt, endTimeTxt, subjectTxt, whyTxt, howTxt;
    EditText subjectInTxt, whyInTxt, howInTxt;
    Button taskInBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.write_task_fragment, container, false);

        timeTxt = (TextView)v.findViewById(R.id.time_txt);
        startTimeTxt = (TextView)v.findViewById(R.id.start_time_txt);
        toTxt = (TextView)v.findViewById(R.id.to_txt);
        endTimeTxt = (TextView)v.findViewById(R.id.end_time_txt);
        subjectTxt = (TextView) v.findViewById(R.id.subject_txt);
        whyTxt = (TextView)v.findViewById(R.id.why_txt);
        howTxt = (TextView)v.findViewById(R.id.how_txt);

        subjectInTxt = (EditText)v.findViewById(R.id.subject_input_edit);
        whyInTxt = (EditText)v.findViewById(R.id.why_input_edit);
        howInTxt = (EditText)v.findViewById(R.id.how_input_edit);

        taskInBtn = (Button)v.findViewById(R.id.task_input_btn);

        taskInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = subjectInTxt.getText().toString();

                getActivity().finish();
            }
        });
        return v;
    }


}
