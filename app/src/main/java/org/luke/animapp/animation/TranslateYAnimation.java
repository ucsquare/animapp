package org.luke.animapp.animation;

import android.view.View;

public class TranslateYAnimation extends ViewAnimation {
    public TranslateYAnimation(View view, long duration, float from, float to) {
        super(view, duration, from, to);
    }

    public TranslateYAnimation(View view, float from, float to) {
        super(view, from, to);
    }

    @Override
    public void apply(float value) {
        view.setTranslationY(value);
    }
}
