package example.com.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int currAngle=30;
    private View piechart;
    private  Button bt_positive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        piechart = findViewById(R.id.piechart);
        bt_positive=(Button)findViewById(R.id.positive);
        //Animation animation = AnimationUtils.loadAnimation(this, R.anim.romate);
      //  piechart.startAnimation(animation);
    }
    public void positive(View v) {
       /* Animation anim = new RotateAnimation(currAngle, currAngle + 180, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        *//** 匀速插值器 *//*
        LinearInterpolator lir = new LinearInterpolator();
        anim.setInterpolator(lir);
        anim.setDuration(1000);
        *//** 动画完成后不恢复原状 *//*
        anim.setFillAfter(false);
        currAngle += 180;
        if (currAngle > 360) {
            currAngle = currAngle - 360;
        }
        piechart.startAnimation(anim);*/

        ObjectAnimator//
                .ofFloat(bt_positive, "rotationX", 180.0F, 360.0F,0.0F)//
                .setDuration(5000)//
                .start();
    }
    public void negative(final View v) {
       /* Animation anim = new RotateAnimation(currAngle, currAngle - 180, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        *//** 匀速插值器 *//*
        LinearInterpolator lir = new LinearInterpolator();
        anim.setInterpolator(lir);
        anim.setDuration(1000);
        *//** 动画完成后不恢复原状 *//*
        anim.setFillAfter(false);
        currAngle -= 180;
        if (currAngle < -360) {
            currAngle = currAngle + 360;
        }
        piechart.startAnimation(anim);*/
        ObjectAnimator anim = ObjectAnimator//
                .ofFloat(v, "alpha", 1.0F,  0.0F)//
                .setDuration(500);//
        anim.start();
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
            @Override
            public void onAnimationUpdate(ValueAnimator animation)
            {
                float cVal = (Float) animation.getAnimatedValue();
                v.setAlpha(cVal);
                v.setScaleX(cVal);
                v.setScaleY(cVal);
            }
        });
    }
}


