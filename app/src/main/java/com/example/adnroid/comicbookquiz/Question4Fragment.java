package com.example.adnroid.comicbookquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;


public class Question4Fragment extends Fragment {
    public MainActivity mainActivity;
    RadioButton mQuestion4Answer1;
    RadioButton mQuestion4Answer2;
    RadioButton mQuestion4Answer3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_4, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mQuestion4Answer1 = getView().findViewById(R.id.q4_answer_1);
        mQuestion4Answer2 = getView().findViewById(R.id.q4_answer_2);
        mQuestion4Answer3 = getView().findViewById(R.id.q4_answer_3);
        mainActivity = (MainActivity) getActivity();
    }

    //Checks if the right answer was given and updates score accordingly
    public void checkAnswerQ4() {
        if (mQuestion4Answer2.isChecked()) {
            mainActivity.score += 1;
        }
    }
}
