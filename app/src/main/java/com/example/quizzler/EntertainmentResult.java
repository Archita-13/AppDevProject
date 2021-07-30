package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EntertainmentResult extends AppCompatActivity {
    TextView result,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment_result);
        result = findViewById(R.id.result_text_tv);
        state = findViewById(R.id.result_statement_tv);

        StringBuffer sb = new StringBuffer();
        sb.append("Your Score is : " + EntertainmentActivity.correct);
        result.setText(sb);
        int val = EntertainmentActivity.correct;
        if (val<=50&&val>=40){
            state.setText("Congratulations for your Oscar worthy performance!");
        }
        else if(val==30){
            state.setText("You need just a little more practice");
        }
        else{
            state.setText("So you don't watch movies?");
        }

        EntertainmentActivity.correct=0;
    }
}