package org.luke.animapp.animation;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public abstract class Animation {
    private static final float FPS = 60.0f;
    private long duration;
    private Interpolator interpolator;

    public Animation(long duration, Interpolator interpolator) {
        this.duration = duration;
        this.interpolator = interpolator;
    }

    public Animation(Interpolator interpolator) {
        this(300, interpolator);
    }

    public Animation(long duration) {
        this(duration, new DecelerateInterpolator());
    }

    public Animation() {
        this(300, new DecelerateInterpolator());
    }

    private boolean running = false;
    private boolean reverse = false;
    public void start() {
        running = true;
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            long now = startTime;
            long lastUpdated = -1;
            while (now - startTime < duration && running) {
                now = System.currentTimeMillis();
                if(now - lastUpdated >= 1000 / FPS) {
                    long passed = now - startTime;
                    float progress = interpolator.getInterpolation(passed / (float) duration);
                    update(reverse ? 1 - progress : progress);
                    lastUpdated = now;
                }
            }
            if(running) update(reverse ? 0 : 1.0f);
            running = false;
        }).start();
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        running = false;
    }

    public void setReverse(boolean reverse) {
        this.reverse = reverse;
    }

    public boolean isReverse() {
        return reverse;
    }

    public abstract void update(float progress);

    @SuppressWarnings("unchecked")
    public <T extends Animation> T setDuration(long duration) {
        this.duration = duration;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <T extends Animation> T setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        return (T) this;
    }
}
