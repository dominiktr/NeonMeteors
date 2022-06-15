package com.DominikT.neonmeteors;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MenuActivity extends AppCompatActivity {

    private static int highScore;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedPreferencesEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        sharedPreferences = getSharedPreferences("neonmeteorsdata", Context.MODE_PRIVATE);

        highScore = getHighScoreFromPref();
        sharedPreferencesEditor = sharedPreferences.edit();

    }

    private int getHighScoreFromPref(){
        int highscore;
        try {
            highscore = Integer.parseInt(sharedPreferences.getString("highscore", "0"));
        }catch (Exception e){
            return 0;
        }

        if (highscore < 0)
            return 0;

        return highscore;
    }

    public static int getHighScore(){
        return highScore;
    }

    public static void setHighScore(int newHighScore){
        if (newHighScore <= 0)
            return;

        highScore = newHighScore;

        try {
            sharedPreferencesEditor.putString("highscore", highScore+"");
            sharedPreferencesEditor.apply();
        }catch (Exception e){}
    }


    public void playClicked(View view) {
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }

}
