package com.example.music;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.music.generator.Generator;


public class PlayerActivity extends Activity {
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

      return false;

    }
}
