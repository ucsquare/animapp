package org.luke.animapp.animation;

import android.view.View;

public class ScaleXYAnimation extends ViewAnimation {
    public ScaleXYAnimation(View view, long duration, float from, float to) {
        super(view, duration, from, to);
    }

    public ScaleXYAnimation(View view, float from, float to) {
        super(view, from, to);
    }

    @Override
    public void apply(float value) {
        view.setScaleX(value);
        view.setScaleY(value);
    }
}
