package com.example.adnroid.comicbookquiz;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Keeps track of current score
    public int score = 0;
    //Kpees track o current question number
    private int questionCounter = 1;
    //TextView that displays current question number
    TextView questionNumber;
    //Question 1 fragment
    Question1 question1;
    //Question 2 fragment
    Question2 question2;
    //Question 3 fragment
    Question3 question3;
    //Question 4 fragment
    Question4 question4;
    //Question 5 fragment
    Question5 question5;
    //Question 5 fragment
    Question6 question6;

    //Definition for keys to save important values
    private static final String QUESTION_NUMBER = "SavedStateOfQuestionNumber";
    private static final String SCORE = "SavedStateOfScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionNumber = findViewById(R.id.question_number);
        question1 = new Question1();
        question2 = new Question2();
        question3 = new Question3();
        question4 = new Question4();
        question5 = new Question5();
        question6 = new Question6();
        //set the first question
        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, question1).commit();
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //restore the number of current question
        questionCounter = savedInstanceState.getInt(QUESTION_NUMBER);
        //restore the current score value
        score = savedInstanceState.getInt(SCORE);
        //change the displayed question to match current question number
        switch (questionCounter) {
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question1).commit();
                return;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question2).commit();
                questionNumber.setText(R.string.question_2_6);
                return;
            case 3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question3).commit();
                questionNumber.setText(R.string.question_3_6);
                return;
            case 4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question4).commit();
                questionNumber.setText(R.string.question_4_6);
                return;
            case 5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question5).commit();
                questionNumber.setText(R.string.question_5_6);
                return;
            case 6:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question6).commit();
                questionNumber.setText(R.string.question_6_6);
                return;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        //save current question number
        savedInstanceState.putInt(QUESTION_NUMBER, questionCounter);
        //save current scre value
        savedInstanceState.putInt(SCORE, score);
        super.onSaveInstanceState(savedInstanceState);
    }

    //Is called whet the next button is clicked
    public void changeQuestion(View view) {
        switch (questionCounter) {
            case 1:
                question1.checkAnswerQ1();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question2).commit();
                questionCounter = 2;
                questionNumber.setText(R.string.question_2_6);
                return;
            case 2:
                question2.checkAnswerQ2();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question3).commit();
                questionCounter = 3;
                questionNumber.setText(R.string.question_3_6);
                return;
            case 3:
                question3.checkAnswerQ3();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question4).commit();
                questionCounter = 4;
                questionNumber.setText(R.string.question_4_6);
                return;
            case 4:
                question4.checkAnswerQ4();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question5).commit();
                questionCounter = 5;
                questionNumber.setText(R.string.question_5_6);
                return;
            case 5:
                question5.checkAnswerQ5();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, question6).commit();
                questionCounter = 6;
                questionNumber.setText(R.string.question_6_6);
                return;
            case 6:
                question6.checkAnswerQ6();
                Intent intent = new Intent(getApplicationContext(), Summary.class);
                intent.putExtra("score", score);
                startActivity(intent);
                return;
        }


    }

}
