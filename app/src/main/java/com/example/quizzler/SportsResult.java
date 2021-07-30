package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SportsResult extends AppCompatActivity {
    TextView result,state;
    Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_result);
        result = findViewById(R.id.sports_result);
        state = findViewById(R.id.sports_statement);
        button7=findViewById(R.id.button7);
        StringBuffer sb = new StringBuffer();
        sb.append("Your Score is : " + SportsActivity.correct);
        result.setText(sb);
        int val = SportsActivity.correct;
        if (val<=50&&val>=40){
            state.setText("Wow! You really seem to be a sports enthusiast");
        }
        else if(val==30){
            state.setText("Not bad! Can do better");
        }
        else{
            state.setText("Sad! Better luck next time");
        }

        SportsActivity.correct=0;
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}