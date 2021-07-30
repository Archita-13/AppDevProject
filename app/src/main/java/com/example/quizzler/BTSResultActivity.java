package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BTSResultActivity extends AppCompatActivity {
TextView result,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btsresult);
        result = findViewById(R.id.textView11);
        state = findViewById(R.id.textView15);

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
    }
}