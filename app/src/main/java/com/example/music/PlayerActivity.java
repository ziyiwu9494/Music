package com.example.music;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.music.generator.Generator;


public class PlayerActivity extends Activity {
    final Generator perfectTune = new Generator();
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
        int x = (int) event.getX();
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                perfectTune.setTuneFreq(y);
                perfectTune.setTuneAmp(x*30);
                System.out.println(x);
                perfectTune.playTune();
            case MotionEvent.ACTION_MOVE:
                perfectTune.setTuneFreq(y);
                perfectTune.setTuneAmp(x*30);
                perfectTune.playTune();
                break;
            case MotionEvent.ACTION_UP:
                perfectTune.stopTune();
                break;
        }
        return false;
    }
}
