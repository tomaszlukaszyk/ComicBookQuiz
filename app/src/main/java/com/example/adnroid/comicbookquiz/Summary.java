package com.example.adnroid.comicbookquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Summary extends AppCompatActivity {

    //Displays the final score of the quiz
    TextView finalScoreView;
    //Displays an icon depending on users performance
    ImageView scoreIcon;
    //Holds the value of final score
    int finalScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);
        finalScoreView = findViewById(R.id.final_score);
        scoreIcon = findViewById(R.id.score_icon);
        //get the score value from main activity
        finalScore = getIntent().getIntExtra("score", 0);
        //display the given score
        finalScoreView.setText(finalScore + "/6");
        //display icon depending o the score value
        if (finalScore < 2) {
            scoreIcon.setImageResource(R.mipmap.bad);
        } else if (finalScore < 5) {
            scoreIcon.setImageResource(R.mipmap.neutral);
        }
    }

    public void shareScore (View view) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text, finalScore));
        shareIntent.setType("text/plain");
        String title = getString(R.string.share_with);
        Intent chooser = Intent.createChooser(shareIntent, title);
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
