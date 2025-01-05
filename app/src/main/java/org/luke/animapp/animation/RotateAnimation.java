package org.luke.animapp.animation;

import android.view.View;

public class RotateAnimation extends ViewAnimation {
    public RotateAnimation(View view, long duration, float from, float to) {
        super(view, duration, from, to);
    }

    public RotateAnimation(View view, float from, float to) {
        super(view, from, to);
    }

    @Override
    public void apply(float value) {
        view.setRotation(value);
    }
}
