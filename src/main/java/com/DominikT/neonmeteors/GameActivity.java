package com.DominikT.neonmeteors;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

public class GameActivity extends AppCompatActivity {

    public static boolean gameOver = false;
    public static DisplayMetrics dm = new DisplayMetrics();
    private MainView mainView;
    public static int meteorStep;
    public static int ammuStep;
    private static int maxStepMeteor;
    private static double currentMeteorStep, currentAmmuStep;
    private static int points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        meteorStep = 7;
        ammuStep = (int) (0.7 * meteorStep);
        maxStepMeteor = 20;
        currentMeteorStep = meteorStep;
        currentAmmuStep = ammuStep;
        points = 0;


        getWindowManager().getDefaultDisplay().getMetrics(dm);

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mainView = new MainView(this, this);
        setContentView(mainView);

    }

    public static int getPoints() {
        return points;
    }

    public static void addPoints(int dpoints) {
        points += dpoints*meteorStep;

        currentMeteorStep += 0.2;
        currentAmmuStep = 0.7 * currentMeteorStep;

        if(currentMeteorStep > maxStepMeteor) currentMeteorStep = maxStepMeteor;

        meteorStep = (int) Math.floor(currentMeteorStep * 100) / 100;
        ammuStep = (int) Math.floor(currentAmmuStep * 100) / 100;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        mainView.getMainThread().getGom().touched(event);

        return super.onTouchEvent(event);
    }

    public void changeActivityToGameOver(){
        Intent i = new Intent(this, GameOverActivity.class);
        startActivity(i);
    }
}
