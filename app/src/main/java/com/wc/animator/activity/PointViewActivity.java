package com.wc.animator.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wc.animator.R;
import com.wc.animator.view.PointView;

/**
 * Created by 18848 on 2017/3/9.
 */

public class PointViewActivity extends AppCompatActivity {
    private PointView myPoint;
    private Button start;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pointview);
        initView();
    }

    private void initView() {
        myPoint = (PointView) findViewById(R.id.point);
        start = (Button) findViewById(R.id.start);
        initOnClick();
    }

    private void initOnClick() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimation();
            }
        });
    }

    private void doAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofInt(myPoint, "pointRadius", 0, 300, 100);
        animator.setDuration(2000);
        animator.start();
    }


}
