package com.example.music;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.music.generator.Generator;

public class DrawView extends View {
    Paint paint = new Paint();
    Paint circlePaint = new Paint();
    float x = 100;
    float y = 100;
    int rad = 0;
    float[] hsv = {0,0,1};
    private void init() {
        paint.setColor(Color.BLACK);
    }
    final Generator perfectTune = new Generator();

    public DrawView(Context context) {
        super(context);
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 440, 720, 440, paint);
        canvas.drawCircle(x,y,rad,circlePaint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float y = (int) event.getY();
        float x = (int) event.getX();
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                perfectTune.setTuneFreq(y);
                perfectTune.setTuneAmp((int)(x*30));
                perfectTune.playTune();
                setCircle(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                perfectTune.setTuneFreq(y);
                perfectTune.setTuneAmp((int)(x*30));
                setCircle(x,y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                perfectTune.stopTune();
                invalidate();
                break;
        }
        return true;
    }
    private void setCircle(float x, float y){
        this.x = x;
        this.y = y;
        this.rad = 5*(int)Math.log(x);
        hsv[0] = y*360/this.getHeight();
        hsv[1] = x*1/this.getWidth();
        circlePaint.setColor(Color.HSVToColor(hsv));
    }

}