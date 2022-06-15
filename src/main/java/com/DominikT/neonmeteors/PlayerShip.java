package com.DominikT.neonmeteors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class PlayerShip {

    private Bitmap ship;
    private float x, y;
    private Rect shipRect;



    public PlayerShip(MainView mainView, BitmapResources bitmapResources){

        ship = bitmapResources.ship;

        x = (int) (GameActivity.dm.widthPixels/2 - ship.getWidth()/2);
        y = (int) (GameActivity.dm.heightPixels - ship.getHeight() - ship.getHeight()/2);

        shipRect = new Rect();
        shipRect.set((int)x, (int)y, (int)x + ship.getWidth(), (int)y + ship.getHeight());
    }


    public void draw(Canvas c) {
        c.drawBitmap(ship, x, y, new Paint(Color.BLACK));
    }


    public void update(float dx, float dy) {
        this.x = this.x - dx;
        this.y = this.y - dy;

        if (this.x < 0)
            this.x = 0;
        else if(this.x > GameActivity.dm.widthPixels - ship.getWidth())
            this.x = GameActivity.dm.widthPixels - ship.getWidth();

        if (this.y < 0)
            this.y = 0;
        else if(this.y > GameActivity.dm.heightPixels - ship.getHeight())
            this.y = GameActivity.dm.heightPixels - ship.getHeight();

        int x = (int)this.x;
        int y = (int)this.y;

        shipRect.set(x, y, x + ship.getWidth(), y + ship.getHeight());

    }

    public Rect getShipRect() {
        return shipRect;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getHeight(){
        return ship.getHeight();
    }

    public int getWidth(){
        return ship.getWidth();
    }
}