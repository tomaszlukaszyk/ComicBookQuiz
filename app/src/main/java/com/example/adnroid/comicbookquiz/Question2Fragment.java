package com.example.adnroid.comicbookquiz;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class Question2Fragment extends Fragment {

    public MainActivity mainActivity;
    EditText mQuestion2Answer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_2, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mQuestion2Answer = getView().findViewById(R.id.q2_answer);
        mainActivity = (MainActivity) getActivity();
    }

    //Checks if the right answer was given and updates score accordingly
    public void checkAnswerQ2() {
        String answer = (mQuestion2Answer).getText().toString();
        if (answer.equals("Parker")) {
            mainActivity.score += 1;
        }
    }
}
