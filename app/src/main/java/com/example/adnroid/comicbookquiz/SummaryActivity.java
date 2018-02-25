package com.example.adnroid.comicbookquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class SummaryActivity extends AppCompatActivity {

    //Displays the final score of the quiz
    TextView mFinalScoreView;
    //Displays an icon depending on users performance
    ImageView mScoreIcon;
    //Holds the value of final score
    int mFinalScore;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        mFinalScoreView = findViewById(R.id.final_score);
        mScoreIcon = findViewById(R.id.score_icon);
        //get the score value from main activity
        mFinalScore = getIntent().getIntExtra("score", 0);
        //display the given score
        mFinalScoreView.setText(mFinalScore + "/6");
        //display icon depending o the score value
        if (mFinalScore < 2) {
            mScoreIcon.setImageResource(R.mipmap.bad);
        } else if (mFinalScore < 5) {
            mScoreIcon.setImageResource(R.mipmap.neutral);
        }
    }

    public void shareScore(View view) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text, mFinalScore));
        shareIntent.setType("text/plain");
        String title = getString(R.string.share_with);
        Intent chooser = Intent.createChooser(shareIntent, title);
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }
}
