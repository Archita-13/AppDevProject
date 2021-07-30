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

public class EntertainmentActivity extends AppCompatActivity {
    TextView question;
    Button confirm;
    RadioGroup radio_g;
    RadioButton op1,op2,op3,op4;


    String[] questions = {"Who said this dialogue?\n\nShut up Anderson! You lower the IQ of the whole street","Which is the highest grossing film in India?","Who became the Female artist of the decade 2010-2020?","Which of these animated films have never won an oscar?","What's inside Harry Potters's wand?"};

    String[] answers = {"Sherlock Holmes","Baahubali 2: The Conclusion","Taylor Swift","Tangled","Phoenix feather"};

    String[] opt ={"Sheldon Cooper","Harvey Specter","Sherlock Holmes","Tyrion Lannister","Baahubali 2: The Conclusion","Dangal","Baahubali: The Beginning","Bajrangi Bhaijaan","Ariana Grande","Lady Gaga","Taylor Swift","Rihanna","Soul","Frozen","Spider-Man: Into the Spider-Verse","Tangled","Unicorn Hair","Dragon Heartstrings","Phoenix feather","None of these"};

    int flag=0;
    public static int marks=0,correct=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment);

        question = findViewById(R.id.question_tv);
        question.setText(questions[flag]);
        confirm = findViewById(R.id.confirm_tv);
        radio_g = findViewById(R.id.radioGroup_tv);
        op1 = findViewById(R.id.option1_tv);
        op1.setText(opt[flag]);
        op2 = findViewById(R.id.option2_tv);
        op2.setText(opt[flag+1]);
        op3 = findViewById(R.id.option3_tv);
        op3.setText(opt[flag+2]);
        op4 = findViewById(R.id.option4_tv);
        op4.setText(opt[flag+3]);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1){
                    Toast.makeText(EntertainmentActivity.this, "Please select one option", Toast.LENGTH_SHORT).show();
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
                    Intent entertainment_result = new Intent(EntertainmentActivity.this,EntertainmentResult.class);

                    startActivity(entertainment_result);
                }
                radio_g.clearCheck();
            }
        });
    }
}