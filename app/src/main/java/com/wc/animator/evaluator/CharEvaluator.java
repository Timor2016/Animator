package com.wc.animator.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by 18848 on 2017/3/9.
 */

public class CharEvaluator implements TypeEvaluator<Character> {
    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = (int) startValue;
        int endInt = (int) endValue;
        int curInt = (int) (startInt + fraction * (endInt - startInt));
        return (char) curInt;
    }
}
