package com.example.adnroid.comicbookquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


public class Question1 extends Fragment {

    RadioButton q1Answer1;
    RadioButton q1Answer2;
    RadioButton q1Answer3;
    public MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        q1Answer1 = getView().findViewById(R.id.q1_answer_1);
        q1Answer2 = getView().findViewById(R.id.q1_answer_2);
        q1Answer3 = getView().findViewById(R.id.q1_answer_3);
        mainActivity = (MainActivity) getActivity();
    }

    //Checks if the right answer was given and updates score accordingly
    public void checkAnswerQ1 (){
        if (q1Answer1.isChecked()) {mainActivity.score += 1; }
    }
}
