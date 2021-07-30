package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class currentAffairsResult extends AppCompatActivity {
    TextView result,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_affairs_result);
        result = findViewById(R.id.a);
        state = findViewById(R.id.b);

        StringBuffer c= new StringBuffer();
        c.append("Your Score is : " + CurrentAffairs.correct);
        result.setText(c);
        int v = CurrentAffairs.correct;
        if (v<=50&&v>=40){
            state.setText("Excellent Job!");
        }
        else if(v==30){
            state.setText("You need just a little more practice");
        }
        else{
            state.setText("You need a lot of practice");
        }

        CurrentAffairs.correct=0;
    }
}