package com.DominikT.neonmeteors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    TextView highScoreTextView, scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game_over);

        highScoreTextView = findViewById(R.id.highscoreTextView);
        highScoreTextView.setText("Highscore: " + MenuActivity.getHighScore());

        scoreTextView = findViewById(R.id.scoreTextView);
        scoreTextView.setText("Score: " + GameActivity.getPoints());

    }

    public void menuClicked(View view) {
        GameActivity.gameOver = false;
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    public void playAgainClicked(View view) {
        GameActivity.gameOver = false;
        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}
