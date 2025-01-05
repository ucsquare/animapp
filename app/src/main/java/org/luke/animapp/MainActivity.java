package org.luke.animapp;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;

import org.luke.animapp.animation.ParallelAnimation;
import org.luke.animapp.animation.RotateAnimation;
import org.luke.animapp.animation.ScaleXYAnimation;
import org.luke.animapp.animation.TranslateYAnimation;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rect = new View(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(300, 300);
        params.gravity = Gravity.CENTER;
        rect.setLayoutParams(params);

        GradientDrawable background = new GradientDrawable();
        background.setCornerRadius(40);
        background.setColor(Color.WHITE);
        rect.setBackground(background);

        FrameLayout root = new FrameLayout(this);
        root.addView(rect);
        setContentView(root);

        ParallelAnimation test = new ParallelAnimation(500)
                .add(new TranslateYAnimation(rect, 0, 300))
                .add(new RotateAnimation(rect, 0, 135))
                .add(new ScaleXYAnimation(rect, 1, 1.5f));
        test.setReverse(true);
        rect.setOnClickListener(e -> {
            if (!test.isRunning()) {
                test.setReverse(!test.isReverse());
                test.start();
            }
        });
    }
}