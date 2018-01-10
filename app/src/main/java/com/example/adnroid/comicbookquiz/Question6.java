package com.example.adnroid.comicbookquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


public class Question6 extends Fragment {

    CheckBox q6Answer1;
    CheckBox q6Answer2;
    CheckBox q6Answer3;
    CheckBox q6Answer4;
    MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_6, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        q6Answer1 = getView().findViewById(R.id.q6_answer_1);
        q6Answer2 = getView().findViewById(R.id.q6_answer_2);
        q6Answer3 = getView().findViewById(R.id.q6_answer_3);
        q6Answer4 = getView().findViewById(R.id.q6_answer_4);
        mainActivity = (MainActivity) getActivity();
    }

    //Checks if the right answer was given and updates score accordingly
    public void checkAnswerQ6 () {
        if (q6Answer1.isChecked() && q6Answer2.isChecked() && !q6Answer3.isChecked() && q6Answer4.isChecked()) {mainActivity.score += 1;}
    }
}
