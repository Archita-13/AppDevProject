package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProgrammingResult extends AppCompatActivity {
    TextView result,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_result);

        result = findViewById(R.id.prog_result_box);
        state = findViewById(R.id.prog_result_statement);

        StringBuffer sb = new StringBuffer();
        sb.append("Your Score is : " + ProgrammingActivity.correct);
        result.setText(sb);
        int val = ProgrammingActivity.correct;
        if (val<=50&&val>=40){
            state.setText("Congratulations!");
        }
        else if(val==30){
            state.setText("You need just a little more practice");
        }
        else{
            state.setText("You need a lot more practice");
        }

        ProgrammingActivity.correct=0;
    }

}