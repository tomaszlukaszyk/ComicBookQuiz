package com.example.adnroid.comicbookquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;


public class Question3Fragment extends Fragment {

    CheckBox mQuestion3Answer1;
    CheckBox mQuestion3Answer2;
    CheckBox mQuestion3Answer3;
    CheckBox mQuestion3Answer4;
    MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mQuestion3Answer1 = getView().findViewById(R.id.q3_answer_1);
        mQuestion3Answer2 = getView().findViewById(R.id.q3_answer_2);
        mQuestion3Answer3 = getView().findViewById(R.id.q3_answer_3);
        mQuestion3Answer4 = getView().findViewById(R.id.q3_answer_4);
        mainActivity = (MainActivity) getActivity();
    }

    //Checks if the right answer was given and updates score accordingly
    public void checkAnswerQ3() {
        if (mQuestion3Answer1.isChecked() && mQuestion3Answer2.isChecked() && !mQuestion3Answer3.isChecked() && !mQuestion3Answer4.isChecked()) {
            mainActivity.score += 1;
        }
    }
}
