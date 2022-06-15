package com.DominikT.neonmeteors;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

public class AmmuManager implements GameObject {

    private ArrayList<Ammu> ammus = new ArrayList<>();
    private MainView mainView;
    private Bitmap ammuBitmap;
    private MeteorManager meteorManager;
    private GameObjectsManager gom;
    
    public AmmuManager(MainView mainView, MeteorManager meteorManager, GameObjectsManager gom, BitmapResources r){
        this.gom = gom;
        this.meteorManager = meteorManager;
        this.mainView = mainView;

        ammuBitmap = r.ammuBitmap;
    }

    @Override
    public void draw(Canvas c) {
        for (Ammu a : ammus)
            a.draw(c);

    }

    @Override
    public void update() {
        /*
        if (ammus.isEmpty())
            addAmmu();
        else {
            for (Ammu a : ammus){
                a.update();
                boolean remove = false;

                for (Meteor m : MeteorManager.meteors) {
                    if (m.getrect().contains(a.getRect())) {
                        MainActivity.addPoints(1);
                        MeteorManager.meteors.remove(m);
                        remove = true;
                        continue;
                    }
                }
                if (remove) ammus.remove(a);;
                continue;
            }

            if (!ammus.isEmpty())
                if (ammus.get(ammus.size()-1).getY() <  MainActivity.dm.heightPixels - MainActivity.dm.heightPixels/2)
                    addAmmu();

        }
        */



        if (ammus.isEmpty())
        addAmmu();
        else {
            for (Ammu a : ammus){
                a.update();

                for (Meteor m : meteorManager.meteors) {
                    if (m.getrect().contains(a.getRect())) {
                        GameActivity.addPoints(1);
                        meteorManager.meteors.remove(m);
                        ammus.remove(a);
                    }
                }
            }

            if (!ammus.isEmpty())
                if (ammus.get(ammus.size()-1).getY() <  GameActivity.dm.heightPixels - GameActivity.dm.heightPixels/2)
                    addAmmu();

        }



    }

    public void addAmmu(){
        ammus.add(new Ammu(mainView, (int)gom.ship.getX() + gom.ship.getWidth()/95, (int)gom.ship.getShipRect().top - ammuBitmap.getHeight()/2, ammuBitmap));
        ammus.add(new Ammu(mainView, (int)gom.ship.getShipRect().right - gom.ship.getWidth()/13, (int)gom.ship.getShipRect().top - ammuBitmap.getHeight()/2, ammuBitmap));
    }

}
