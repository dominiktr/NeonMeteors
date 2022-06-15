package com.DominikT.neonmeteors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class BitmapMeteorResources {

    public ArrayList<Bitmap> meteorsBitmap = new ArrayList<>();

    public BitmapMeteorResources(MainView mainView) {
        ArrayList<Bitmap> BITMAPMETEOR = new ArrayList<>();
        BITMAPMETEOR.add(BitmapFactory.decodeResource(mainView.getResources(), R.drawable.meteor1));
        BITMAPMETEOR.add(BitmapFactory.decodeResource(mainView.getResources(), R.drawable.meteor2));
        BITMAPMETEOR.add(BitmapFactory.decodeResource(mainView.getResources(), R.drawable.meteor3));
        BITMAPMETEOR.add(BitmapFactory.decodeResource(mainView.getResources(), R.drawable.meteor4));
        BITMAPMETEOR.add(BitmapFactory.decodeResource(mainView.getResources(), R.drawable.meteor5));

        float newX;
        for (Bitmap b : BITMAPMETEOR){
            for (int i = 3; i < 6; i++){
                newX = GameActivity.dm.widthPixels/i;
                meteorsBitmap.add(Bitmap.createScaledBitmap(b, (int)newX, (int)(b.getHeight()/(b.getWidth()/newX)), false));
            }
        }
    }
}
