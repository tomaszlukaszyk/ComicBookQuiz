package com.example.adnroid.comicbookquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;


public class Summary extends AppCompatActivity {

    //Displays the final score of the quiz
    TextView finalScoreView;
    //Displays an icon depending on users performance
    ImageView scoreIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);
        finalScoreView = findViewById(R.id.final_score);
        scoreIcon = findViewById(R.id.score_icon);
        //get the score value from main activity
        int finalScore = getIntent().getIntExtra("score", 0);
        //display the given score
        finalScoreView.setText(finalScore + "/6");
        //display icon depending o the score value
        if (finalScore < 2) {
            scoreIcon.setImageResource(R.mipmap.bad);
        } else if (finalScore < 5) {
            scoreIcon.setImageResource(R.mipmap.neutral);
        }
    }
}
