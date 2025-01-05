package org.luke.animapp.animation;

public abstract class ValueAnimation extends Animation {
    private float from;
    private float to;

    public ValueAnimation(long duration, float from, float to) {
        super(duration);
        this.from = from;
        this.to = to;
    }

    public ValueAnimation(float from, float to) {
        super();
        this.from = from;
        this.to = to;
    }

    public void setTo(float to) {
        this.to = to;
    }

    public void setFrom(float from) {
        this.from = from;
    }

    @Override
    public void update(float progress) {
        updateValue(from + (to - from) * progress);
    }

    public abstract void updateValue(float value);
}
