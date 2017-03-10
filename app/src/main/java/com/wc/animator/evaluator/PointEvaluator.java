package com.wc.animator.evaluator;

import android.animation.TypeEvaluator;

import com.wc.animator.bean.PointBean;

/**
 * Created by 18848 on 2017/3/9.
 */

public class PointEvaluator implements TypeEvaluator<PointBean> {
    @Override
    public PointBean evaluate(float fraction, PointBean startValue, PointBean endValue) {
        int start = startValue.getRadius();
        int end = endValue.getRadius();
        int curInt = (int) (start + fraction * (end - start));
        PointBean bean = new PointBean();
        bean.setRadius(curInt);
        return bean;
    }
}
