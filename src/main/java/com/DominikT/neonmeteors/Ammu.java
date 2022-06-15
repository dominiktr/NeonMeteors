package com.DominikT.neonmeteors;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Ammu implements GameObject {

    private MainView mainView;
    private Bitmap bitmap;
    private Rect rect;
    private int x,y;

    public Ammu(MainView mainView, int x, int y, Bitmap bitmap){
        this.mainView = mainView;
        this.bitmap = bitmap;

        this.x = x;
        this.y = y;

        this.x = x;
        this.y = y;

        rect = new Rect();
        rect.set(this.x, this.y, x + bitmap.getWidth(), y + bitmap.getHeight());
    }


    @Override
    public void draw(Canvas c) {
        c.drawBitmap(bitmap,x,y,new Paint(Color.BLACK));
    }

    @Override
    public void update() {
        y -= GameActivity.ammuStep;
        rect.offset(0,-GameActivity.ammuStep);
    }

    public Rect getRect() {
        return rect;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
