package com.DominikT.neonmeteors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Random;

public class Meteor {

    private Rect rect;
    private Bitmap bitmap;
    private int x, y;

    public Meteor(MainView mainView, Bitmap bitmap){

        this.bitmap = bitmap;

        x = generateX();
        y = -bitmap.getHeight();

        rect = new Rect();
        rect.set(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());
    }


    public void draw(Canvas c) {
        c.drawBitmap(bitmap, x, y, new Paint(Color.BLACK));
    }


    public void update(int dx, int dy) {
        x = x + dx;
        y = y + dy;
        rect.offset(dx,dy);
    }

    public Rect getrect() {
        return rect;
    }

    private int generateX(){
        int x = new Random().nextInt(GameActivity.dm.widthPixels - bitmap.getWidth());
        return x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight(){
        return bitmap.getHeight();
    }
}
