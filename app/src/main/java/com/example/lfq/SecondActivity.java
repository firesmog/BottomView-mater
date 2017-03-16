package com.example.lfq;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

/**
 * --------------------------------------------
 * auther :  Lvfq
 * 2016/11/12 0:30
 * description ：
 * -------------------------------------------
 **/
public class SecondActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("this is secondActivity");
        setContentView(textView);
    }
}
