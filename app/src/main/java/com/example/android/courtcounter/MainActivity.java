package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ScoreTeamA = 0;
    int ScoreTeamB = 0;
    int foulA = 0;
    int foulB = 0;
    TextView resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultMessage = (TextView) findViewById(R.id.resultMessage);
    }


    private void displayA() {
        displayForTeamA(ScoreTeamA);
    }

    public void addThreeForTeamA(View v) {
        ScoreTeamA = ScoreTeamA + 3;
        displayA();
    }

    public void addTwoForTeamA(View v) {
        ScoreTeamA = ScoreTeamA + 2;
        displayA();
    }

    public void addOneForTeamA(View v) {
        ScoreTeamA = ScoreTeamA + 1;
        displayA();
    }


    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamB(View v) {
        ScoreTeamB = ScoreTeamB + 3;
        displayB();
    }

    public void addTwoForTeamB(View v) {
        ScoreTeamB = ScoreTeamB + 2;
        displayB();
    }

    public void addOneForTeamB(View v) {
        ScoreTeamB = ScoreTeamB + 1;
        displayB();
    }

    private void displayB() {
        displayForTeamB(ScoreTeamB);
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void reset(View view) {
        ScoreTeamA = 0;
        ScoreTeamB = 0;
        foulA = 0;
        foulB = 0;
        resultMessage.setText("");
        displayA();
        displayB();
        displayFoulA();
        displayFoulB();
    }

    private void displayFoulB() {
        displayFoulB(foulB);
    }

    private void displayFoulA() {
        displayFoulA(foulA);
    }

    public void foulA(View view) {
        foulA = foulA + 1;
        displayFoulA();


    }

    public void displayFoulA(int foulA) {
        TextView scoreView = (TextView) findViewById(R.id.foulA);
        scoreView.setText(String.valueOf(foulA));
    }

    public void displayFoulB(int foulB) {
        TextView scoreView = (TextView) findViewById(R.id.foulB);
        scoreView.setText(String.valueOf(foulB));
    }

    public void foulB(View view) {
        foulB = foulB + 1;
        displayFoulB();

    }


    public void displayResult(View view) {
        if (ScoreTeamA != 0 || ScoreTeamB != 0) {
            if (ScoreTeamA > ScoreTeamB) {
                resultMessage.setText("Orange Lions wins with " + String.valueOf(ScoreTeamA) + " points\nCongratulation !");
            } else if (ScoreTeamA < ScoreTeamB) {
                resultMessage.setText("Dragons wins with " + String.valueOf(ScoreTeamB) + " points\nCongratulation !");

            } else resultMessage.setText("Draw");


        } else
            resultMessage.setText("Start the game first!");
    }

}