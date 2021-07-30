package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AnimeActivity extends AppCompatActivity {
    TextView question;
    Button confirm;
    RadioGroup radio_g;
    RadioButton op1,op2,op3,op4;


    String[] questions = {"What is the name of strongest move in jujutsu Kaisen?","Which is the longest Anime series ever?","Which anime character is famous for defeating all his opponents in one punch?","Who commanded the survey corps in Attack on Titan?","Which is the highest-grossing anime film worldwide?"};
                                                                                                                          //Questions given by Sachetan
    String[] answers = {"Domain Expansin","Sazae-san","Saitama","Erwin Smith","Demon Slayer: Mugen Train"};

    String[] opt ={"kamehameha","Domain Expansin","Serious Punch","Rasengan","One Piece","Dragon Ball Z","Sazae-san","Naruto","Goku","Saitama","All Might","Gajo Satoru","Hange Zoe","Erwin Smith","Levi Ackerman","Keith Shadis","Your name","Spirited Away","Demon Slayer: Mugen Train","Weathering with you"};

    int flag=0;
    public static int marks=0,correct=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        question = findViewById(R.id.question_anime);
        question.setText(questions[flag]);
        confirm = findViewById(R.id.confirm_anime);
        radio_g = findViewById(R.id.radioGroup_anime);
        op1 = findViewById(R.id.option1_anime);
        op1.setText(opt[flag]);
        op2 = findViewById(R.id.option2_anime);
        op2.setText(opt[flag+1]);
        op3 = findViewById(R.id.option3_anime);
        op3.setText(opt[flag+2]);
        op4 = findViewById(R.id.option4_anime);
        op4.setText(opt[flag+3]);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1){
                    Toast.makeText(AnimeActivity.this, "Please select one option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton)findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if(ansText==answers[flag]){
                    correct=correct+10;
                }
                ++flag;

                if(flag<questions.length){
                    question.setText(questions[flag]);
                    op1.setText(opt[flag*4]);
                    op2.setText(opt[flag*4 +1]);
                    op3.setText(opt[flag*4 +2]);
                    op4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks = correct;
                    Intent anime_result = new Intent(AnimeActivity.this,AnimeResult.class);

                    startActivity(anime_result);
                }
                radio_g.clearCheck();
            }
        });
    }
}
