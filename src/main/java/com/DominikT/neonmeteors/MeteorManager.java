package com.DominikT.neonmeteors;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Random;

public class MeteorManager implements GameObject{

    public ArrayList<Meteor> meteors = new ArrayList<>();
    private int meteorAmount = 1;
    private MainView mainView;
    private Random random = new Random();
    private GameObjectsManager gom;
    private BitmapMeteorResources bitmapMeteorResources;
    private ArrayList<Integer> last = new ArrayList<>(2);

    public MeteorManager(MainView mainView, GameObjectsManager gom){
        bitmapMeteorResources = new BitmapMeteorResources(mainView);
        this.gom = gom;
        this.mainView = mainView;
        last.add(random.nextInt(15));
        last.add(random.nextInt(15));
            addMeteor();
    }

    @Override
    public void draw(Canvas c) {
        if (!meteors.isEmpty()) {
            for (Meteor m : meteors) {
                m.draw(c);
            }
        }
    }

    @Override
    public void update() {

        if (!meteors.isEmpty()) {

            for (Meteor m : meteors) {
                m.update(0, GameActivity.meteorStep);

                if (gom.ship.getShipRect().contains(m.getrect())) {
                    System.out.println("ELO!!!");
                    GameActivity.gameOver = true;
                }

                if (m.getY() + m.getHeight() > GameActivity.dm.heightPixels) {
                    meteors.remove(m);
                    GameActivity.gameOver = true;
                }
            }
            if (meteors.get(meteors.size() - 1).getY() > meteors.get(meteors.size() - 1).getHeight())
                addMeteor();
        }else addMeteor();
    }

    public void addMeteor(){
        int id = 0;

        do {
            id = genId();
        }while (id == last.get(0) || id == last.get(1));

        meteors.add( new Meteor(mainView, bitmapMeteorResources.meteorsBitmap.get(id + random.nextInt(3))));

        last.remove(0);
        last.add(id);
    }

    public int genId(){
        return random.nextInt(5)*3;
    }
}
