package com.wc.animator.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.wc.animator.bean.PointBean;
import com.wc.animator.evaluator.PointEvaluator;

/**
 * Created by 18848 on 2017/3/9.
 */

public class PointView extends View {

    private Paint pointPaint;
    private PointBean point = new PointBean(20);

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        pointPaint = new Paint();
        pointPaint.setAntiAlias(true);
        pointPaint.setColor(Color.RED);
        pointPaint.setStyle(Paint.Style.FILL);
        doPoint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (point != null) {
            canvas.drawCircle(500, 500, point.getRadius(), pointPaint);
        }

    }

    private void doPoint() {
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), new PointBean(20), new PointBean(200));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                point = (PointBean) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(3000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
    }

    public void setPointRadius(int radius) {
        point.setRadius(radius);
        invalidate();
    }
}
