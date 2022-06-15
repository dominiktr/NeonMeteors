package com.DominikT.neonmeteors;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;

import java.util.ArrayList;

public class GameObjectsManager {

    private ArrayList<BgStar> bgStars = new ArrayList<>();
    public PlayerShip ship;
    private BgStarManager bgStarManager;
    private MeteorManager meteorManager;
    private float lastX, lastY;
    public static AmmuManager ammuManager;
    private PointsDrawer pointsDrawer;


    public GameObjectsManager(MainView mainView, BitmapResources bitmapResources) {

        for (int i = 0; i < GameActivity.dm.heightPixels/20; i++){
            bgStars.add(new BgStar());
        }

        bgStarManager = new BgStarManager(mainView);
        meteorManager = new MeteorManager(mainView, this);
        ship = new PlayerShip(mainView, bitmapResources);
        ammuManager = new AmmuManager(mainView, meteorManager, this, bitmapResources);
        pointsDrawer = new PointsDrawer();
        ammuManager.addAmmu();
    }

    public void draw(Canvas c){
        c.drawColor(Color.parseColor("#000015"));
        bgStarManager.draw(c);
        ship.draw(c);
        meteorManager.draw(c);
        ammuManager.draw(c);
        pointsDrawer.draw(c);
    }

    public void update(){
        bgStarManager.update();
        meteorManager.update();
        ammuManager.update();
    }

    public void touched (MotionEvent e){

        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            lastX = e.getX();
            //lastY = e.getY();
        }

        if(e.getAction() == MotionEvent.ACTION_MOVE){
            float dx = lastX - e.getX();
            //float dy = lastY - e.getY();
            lastX = e.getX();
            //lastY = e.getY();
            ship.update(dx,0);
        }

    }
}
