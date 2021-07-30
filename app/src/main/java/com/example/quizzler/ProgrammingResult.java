package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProgrammingResult extends AppCompatActivity {
    TextView result,state;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming_result);

        result = findViewById(R.id.prog_result_box);
        state = findViewById(R.id.prog_result_statement);
        exit = findViewById(R.id.prog_exit);

        StringBuffer sb = new StringBuffer();
        sb.append("Your Score is : " + ProgrammingActivity.correct);
        result.setText(sb);
        int val = ProgrammingActivity.correct;
        if (val<=50&&val>=40){
            state.setText("Damn! You are a Geek");
        }
        else if(val==30){
            state.setText("You need just a little more practice");
        }
        else{
            state.setText("Oops! You should code more");
        }

        ProgrammingActivity.correct=0;
        AnimeActivity.correct=0;
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }

}