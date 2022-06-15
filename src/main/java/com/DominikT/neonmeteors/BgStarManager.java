package com.DominikT.neonmeteors;

import android.graphics.Canvas;

import java.util.ArrayList;

public class BgStarManager {
    private ArrayList<BgStar> bgStars = new ArrayList<>();
    private float lastX, lastY;

    public BgStarManager(MainView mainView) {

        for (int i = 0; i < GameActivity.dm.heightPixels/20; i++){
            bgStars.add(new BgStar());
        }
    }

    public void draw(Canvas c){

        for (BgStar bgStar : bgStars){
            bgStar.draw(c);
        }
    }

    public void update(){
        for (BgStar bgStar : bgStars){
            bgStar.update();
        }
    }
}
