package com.DominikT.neonmeteors;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class BitmapResources {
    private MainView mainView;
    public Bitmap ammuBitmap;
    public Bitmap ship;
    public ArrayList<Bitmap> meteorsBitmap = new ArrayList<>();

    public BitmapResources(MainView mainView){
        this.mainView = mainView;
        float newX = GameActivity.dm.widthPixels/50;
        Bitmap bitmap = BitmapFactory.decodeResource(mainView.getResources(), R.drawable.amu);
        ammuBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(mainView.getResources(), R.drawable.amu), (int)newX, (int)(bitmap.getHeight()/(bitmap.getWidth()/newX)), false);
        ship = BitmapFactory.decodeResource(mainView.getResources(), R.drawable.ship);
        newX = GameActivity.dm.widthPixels/3;
        ship = Bitmap.createScaledBitmap(ship, (int)newX, (int)(ship.getHeight()/(ship.getWidth()/newX)), false);

    }

}
