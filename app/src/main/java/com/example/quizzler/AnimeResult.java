package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AnimeResult extends AppCompatActivity {
    TextView result,state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_result);

        result = findViewById(R.id.anime_result_text);
        state = findViewById(R.id.anime_statement);

        StringBuffer sb = new StringBuffer();
        sb.append("Your Score is : " + AnimeActivity.correct);
        result.setText(sb);
        int val = AnimeActivity.correct;
        if (val<=50&&val>=40){
            state.setText("You are a certified Weeb!");
        }
        else if(val==30){
            state.setText("You need just a little more practice");
        }
        else{
            state.setText("Do you even watch anime?");
        }

        AnimeActivity.correct=0;
    }
}