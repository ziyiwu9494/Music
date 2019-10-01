package com.example.music;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;

import com.karlotoy.perfectune.instance.PerfectTune;

public class PlayerActivity extends Activity {
    final PerfectTune perfectTune = new PerfectTune();
    DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
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
                System.out.println(y);
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
