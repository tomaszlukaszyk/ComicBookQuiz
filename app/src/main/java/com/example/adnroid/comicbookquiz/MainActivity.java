package com.example.adnroid.comicbookquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Definition for keys to save important values
    private static final String QUESTION_NUMBER = "SavedStateOfQuestionNumber";
    private static final String SCORE = "SavedStateOfScore";

    //Keeps track of current score
    public int score;
    //TextView that displays current question number
    TextView mQuestionNumber;
    //Question 1 fragment
    Question1Fragment mQuestion1;
    //Question 2 fragment
    Question2Fragment mQuestion2;
    //Question 3 fragment
    Question3Fragment mQuestion3;
    //Question 4 fragment
    Question4Fragment mQuestion4;
    //Question 5 fragment
    Question5Fragment mQuestion5;
    //Question 5 fragment
    Question6Fragment mQuestion6;
    //Keeps track o current question number
    private int mQuestionCounter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionNumber = findViewById(R.id.question_number);
        mQuestion1 = new Question1Fragment();
        mQuestion2 = new Question2Fragment();
        mQuestion3 = new Question3Fragment();
        mQuestion4 = new Question4Fragment();
        mQuestion5 = new Question5Fragment();
        mQuestion6 = new Question6Fragment();
        //set the first question
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mQuestion1).commit();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //restore the number of current question
        mQuestionCounter = savedInstanceState.getInt(QUESTION_NUMBER);
        //restore the current score value
        score = savedInstanceState.getInt(SCORE);
        //change the displayed question to match current question number
        switch (mQuestionCounter) {
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion1).commit();
                return;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion2).commit();
                mQuestionNumber.setText(R.string.question_2_6);
                return;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion3).commit();
                mQuestionNumber.setText(R.string.question_3_6);
                return;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion4).commit();
                mQuestionNumber.setText(R.string.question_4_6);
                return;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion5).commit();
                mQuestionNumber.setText(R.string.question_5_6);
                return;
            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion6).commit();
                mQuestionNumber.setText(R.string.question_6_6);
                return;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        //save current question number
        savedInstanceState.putInt(QUESTION_NUMBER, mQuestionCounter);
        //save current score value
        savedInstanceState.putInt(SCORE, score);
        super.onSaveInstanceState(savedInstanceState);
    }

    //Is called whet the next button is clicked
    public void changeQuestion(View view) {
        switch (mQuestionCounter) {
            case 1:
                mQuestion1.checkAnswerQ1();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion2).commit();
                mQuestionCounter = 2;
                mQuestionNumber.setText(R.string.question_2_6);
                return;
            case 2:
                mQuestion2.checkAnswerQ2();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion3).commit();
                mQuestionCounter = 3;
                mQuestionNumber.setText(R.string.question_3_6);
                return;
            case 3:
                mQuestion3.checkAnswerQ3();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion4).commit();
                mQuestionCounter = 4;
                mQuestionNumber.setText(R.string.question_4_6);
                return;
            case 4:
                mQuestion4.checkAnswerQ4();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion5).commit();
                mQuestionCounter = 5;
                mQuestionNumber.setText(R.string.question_5_6);
                return;
            case 5:
                mQuestion5.checkAnswerQ5();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mQuestion6).commit();
                mQuestionCounter = 6;
                mQuestionNumber.setText(R.string.question_6_6);
                return;
            case 6:
                mQuestion6.checkAnswerQ6();
                Intent intent = new Intent(getApplicationContext(), SummaryActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
                return;
        }


    }

}
