package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BTSResultActivity extends AppCompatActivity {
TextView result,state;
Button button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btsresult);
        result = findViewById(R.id.textView11);
        state = findViewById(R.id.textView15);
        button3=findViewById(R.id.button3);

        StringBuffer sb = new StringBuffer();
        sb.append("Your Score is : " + BtsActivity.correct);
        result.setText(sb);
        int val = BtsActivity.correct;
        if (val<=50&&val>=40){
            state.setText("You are a certified ARMY!");
        }
        else if(val==30){
            state.setText("You need just a little more practice");
        }
        else{
            state.setText("So you're only a music fan?");
        }

        BtsActivity.correct=0;
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}