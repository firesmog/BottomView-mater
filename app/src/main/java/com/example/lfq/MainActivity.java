package com.example.lfq;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lfq.view.AnimateUtil;
import com.example.lfq.view.BaseBottomView;
import com.example.lfq.view.OnDismissListener;

public class MainActivity extends FragmentActivity {

    private LinearLayout ly_show;
    private TextView tv;
    private Button bt;
    private Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  ly_show = (LinearLayout) findViewById(R.id.ly_show);
        tv=(TextView) findViewById(R.id.tv_content1);
        bt = (Button) findViewById(R.id.bt_4);
        bt2 = (Button) findViewById(R.id.bt_1);
        //Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
      //  ly_show.startAnimation(anim);
    */
    }

    public void onClick(View view) {
        System.out.println("*******************");
//        float curTranslation = tv.getTranslationY();
        //float height=ly_show.getHeight();
        /*ObjectAnimator//
                .ofFloat(bt, "translationY", 0.0F, -360.0F, 0.0F)//
                .setDuration(500)//
                .start();*/
       /* ObjectAnimator//
                .ofFloat(bt, "translationX", 0.0F, 360.0F)//
                .setDuration(500)//
                .start();*/
        final BaseBottomView bottomView = new BaseBottomView(this, R.layout.layout_bottom);
        bottomView.findViewById(R.id.tv_content1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomView.setOnDismissListener(new OnDismissListener() {
                    @Override
                    public void onDismiss(Object o) {
                        Toast.makeText(MainActivity.this, "跳转SecondActivity", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        bottomView.findViewById(R.id.tv_content2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "选择 content2", Toast.LENGTH_SHORT).show();
                bottomView.dismiss();
            }
        });
        bottomView.setCancelable(true);
        bottomView.show();

    }

    public void onClick1(View view) {
//        Toast.makeText(this, "onClick1", Toast.LENGTH_SHORT).show();
    }

    public void onClick2(View view) {
        Toast.makeText(this, "onClick2", Toast.LENGTH_SHORT).show();
    }

    public void onClick3(View view) {
        Toast.makeText(this, "onClick3", Toast.LENGTH_SHORT).show();
    }

}

