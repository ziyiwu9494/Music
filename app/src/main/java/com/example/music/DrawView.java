package com.example.music;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.music.generator.Generator;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import javax.net.ssl.SSLEngineResult;


public class DrawView extends View {
    public static int MIDDLE_C_FREQUENCY = 440;
    Paint paint = new Paint();
    Map<Integer, Pointer> pointers = new Hashtable<Integer, Pointer>();
    float[] hsv = {0,0,1};
    private void init() {
        paint.setColor(Color.RED);
    }
    float scaling;
    Generator g;


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
        scaling = this.getWidth()/1080f;
        super.onDraw(canvas);
        canvas.drawLine(0, MIDDLE_C_FREQUENCY*scaling, this.getWidth(), MIDDLE_C_FREQUENCY *scaling, paint);
        for(Pointer p : pointers.values()) {
            p.draw(canvas);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        float y = (int) event.getY();
        float x = (int) event.getX();
        //normalize x and y for frequency and amplitude
        float mx = x/scaling;
        float my = y/scaling;
        int pointerId;
        switch(event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                pointerId = event.getPointerId(0);
                pointers.put(pointerId, new Pointer(this.getHeight(),this.getWidth()));
                pointers.get(pointerId).setCircle(event.getX(),event.getY(),scaling);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                //changeTune(mx,my, genThreads.get(actionIndex));
                //genThreads.get(actionIndex).playTune();
                for(int i = 0; i < event.getPointerCount(); i++){
                    pointers.get(event.getPointerId(i)).setCircle(event.getX(),event.getY(),scaling);
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                //genThreads.get(actionIndex).stopTune();
                //genThreads.remove(actionIndex);
                pointers.remove(event.getPointerId(0));
                invalidate();
                break;

        }
        return true;
    }

    private void changeTune(float mx, float my, Generator perfectTune){
        perfectTune.setTuneFreq(20*Math.pow(2,my/232));
        perfectTune.setTuneAmp((mx/1080));
    }
}