package com.example.music;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.karlotoy.perfectune.instance.PerfectTune;

public class MainActivity extends AppCompatActivity {
    final PerfectTune perfectTune = new PerfectTune();
    DrawView drawView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                perfectTune.setTuneFreq(y);
                perfectTune.playTune();
            case MotionEvent.ACTION_MOVE:
                perfectTune.setTuneFreq(y);
                perfectTune.playTune();
                break;
            case MotionEvent.ACTION_UP:
                perfectTune.stopTune();
                break;
        }
        return false;
    }

}
