package com.DominikT.neonmeteors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class PointsDrawer {

    private Paint p;
    private int textSize = 80;

    public PointsDrawer(){
        p = new Paint();
        p.setTextSize(textSize);
        p.setColor(Color.WHITE);
        p.setTextAlign(Paint.Align.CENTER);
    }


    public void draw(Canvas c){
        c.drawText(GameActivity.getPoints()+"", GameActivity.dm.widthPixels / 2 - p.getStrokeWidth(), textSize * 2, p);
    }

}
