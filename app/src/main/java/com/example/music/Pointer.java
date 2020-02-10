package com.example.music;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.music.generator.Generator;

public class Pointer {
    private Paint color = new Paint();
    private float x;
    private float y;
    private int rad;
    private int dispHeight;
    private int dispWidth;

    public int getDispHeight() {
        return dispHeight;
    }

    public void setDispHeight(int dispHeight) {
        this.dispHeight = dispHeight;
    }

    public int getDispWidth() {
        return dispWidth;
    }

    public void setDispWidth(int dispWidth) {
        this.dispWidth = dispWidth;
    }

    public Pointer(int dispHeight, int dispWidth) {
        this.dispHeight = dispHeight;
        this.dispWidth = dispWidth;
    }

    public Pointer(){}
    public Pointer(Paint color, float x, float y, int rad) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.rad = rad;
    }

    public Paint getColor() {
        return color;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }
    public void setCircle(float x, float y, float scaling){
        this.x = x;
        this.y = y;
        this.rad = (int)(5*Math.log(x)*scaling);
        float[] hsv = new float[3];
        hsv[0] = y*360/dispHeight;
        hsv[1] = x/dispWidth;
        hsv[2] = 1;
        color.setStyle(Paint.Style.FILL);
        color.setColor(Color.HSVToColor(hsv));
    }
    public void draw(Canvas canvas){
        canvas.drawCircle(x,y,rad,color);
    }

}
