package org.luke.animapp.animation;

import android.view.animation.Interpolator;

import java.util.ArrayList;

public class ParallelAnimation extends Animation {
    private final ArrayList<Animation> children = new ArrayList<>();

    public ParallelAnimation(long duration, Interpolator interpolator) {
        super(duration, interpolator);
    }

    public ParallelAnimation(Interpolator interpolator) {
        super(interpolator);
    }

    public ParallelAnimation(long duration) {
        super(duration);
    }

    @SuppressWarnings("unchecked")
    public <T extends ParallelAnimation> T add(Animation animation) {
        children.add(animation);
        return (T) this;
    }

    @Override
    public void update(float progress) {
        children.forEach(a -> a.update(progress));
    }
}
