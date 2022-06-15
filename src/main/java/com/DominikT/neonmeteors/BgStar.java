package com.DominikT.neonmeteors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class BgStar implements GameObject{

    private int size, x, y;

    public BgStar() {
        generateAll();
    }

    @Override
    public void draw(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.WHITE);

        c.drawRect((float) x, (float) y, (float) x+size, (float) y+size, p);
    }

    @Override
    public void update() {
        y+=GameActivity.ammuStep;
        if (y > GameActivity.dm.heightPixels + size) generate();
    }

    private void generateAll(){
        generate();
        y = new Random().nextInt(GameActivity.dm.heightPixels);
    }

    private void generate(){
        Random random = new Random();
        size = random.nextInt(4);
        x = random.nextInt(GameActivity.dm.widthPixels);
        y = 0;
    }
}
