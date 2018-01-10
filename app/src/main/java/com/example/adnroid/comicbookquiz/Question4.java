package com.example.adnroid.comicbookquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


public class Question4 extends Fragment {
    RadioButton q4Answer1;
    RadioButton q4Answer2;
    RadioButton q4Answer3;
    public MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.question_4, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        q4Answer1 = getView().findViewById(R.id.q4_answer_1);
        q4Answer2 = getView().findViewById(R.id.q4_answer_2);
        q4Answer3 = getView().findViewById(R.id.q4_answer_3);
        mainActivity = (MainActivity) getActivity();
    }

    //Checks if the right answer was given and updates score accordingly
    public void checkAnswerQ4 (){
        if (q4Answer2.isChecked()) {mainActivity.score += 1; }
    }
}
