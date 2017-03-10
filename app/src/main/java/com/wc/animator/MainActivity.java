package com.wc.animator;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import com.wc.animator.activity.PointViewActivity;
import com.wc.animator.activity.XMLsetActivity;
import com.wc.animator.evaluator.CharEvaluator;

public class MainActivity extends AppCompatActivity {

    private Button object;
    private Button poinView;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        object = (Button) findViewById(R.id.object);
        poinView = (Button) findViewById(R.id.point_view);
        btn1 = (Button) findViewById(R.id.btn1);
        initOnClick();
    }

    private void initOnClick() {
        object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objAnimator();
            }
        });

        poinView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PointViewActivity.class));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, XMLsetActivity.class));
            }
        });
    }


    //测试自定义Evaluator
    private void objAnimator() {
        ValueAnimator animator = ValueAnimator.ofObject(new CharEvaluator(), 'A', 'Z');
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (char) animation.getAnimatedValue();
                object.setText(String.valueOf(text));
            }
        });
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }
}
