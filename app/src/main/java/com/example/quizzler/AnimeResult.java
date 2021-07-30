package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnimeResult extends AppCompatActivity {
    TextView result,state;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_result);

        result = findViewById(R.id.anime_result_text);
        state = findViewById(R.id.anime_statement);
        button2=findViewById(R.id.button2);

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
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}