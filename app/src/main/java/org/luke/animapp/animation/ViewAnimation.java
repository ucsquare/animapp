package org.luke.animapp.animation;

import android.os.Handler;
import android.os.Looper;
import android.view.View;

public abstract class ViewAnimation extends ValueAnimation {
    protected View view;

    public ViewAnimation(View view, long duration, float from, float to) {
        super(duration, from, to);
        this.view = view;
    }

    public ViewAnimation(View view, float from, float to) {
        super(from, to);
        this.view = view;
    }

    @Override
    public void updateValue(float value) {
        new Handler(Looper.getMainLooper()).post(() -> apply(value));
    }

    public abstract void apply(float value);
}
