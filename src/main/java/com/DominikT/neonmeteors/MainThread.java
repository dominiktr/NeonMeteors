package com.DominikT.neonmeteors;

import android.content.Intent;
import android.graphics.Canvas;

public class MainThread extends Thread {

    private MainView mainView;
    public static Canvas c;
    private GameObjectsManager gom;
    private GameActivity gameActivity;


    public MainThread(MainView mainView, GameActivity gameActivity, BitmapResources bitmapResources) {
        super();
        this.mainView = mainView;
        gom = new GameObjectsManager(mainView, bitmapResources);
        this.gameActivity = gameActivity;
    }

    public void run() {

            long targetTime = (long) 1 / 60 * 1000;

            while (!GameActivity.gameOver) {
                long startTime = System.currentTimeMillis();

                try {
                    c = mainView.getHolder().lockCanvas();

                    gom.draw(c);
                    gom.update();

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    mainView.getHolder().unlockCanvasAndPost(c);
                }

                long lastTime = System.currentTimeMillis();
                long waitTime = targetTime - (lastTime - startTime);

                if (waitTime > 0) {
                    try {
                        sleep(waitTime);
                    } catch (Exception e) {
                    }
                }

            }

        if (gameActivity.getPoints() > MenuActivity.getHighScore())
            MenuActivity.setHighScore(gameActivity.getPoints());

        gameActivity.changeActivityToGameOver();

    }

    public GameObjectsManager getGom() {
        return gom;
    }


}
