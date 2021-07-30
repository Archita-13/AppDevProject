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

public class BtsActivity extends AppCompatActivity {
TextView question;
Button confirm;
RadioGroup radio_g;
RadioButton op1,op2,op3,op4;


String[] questions = {"What is the name of BTS's debut album?","Which was BTS's first show?","On which Award show did BTS make their US TV performance debut?","Which date is ARMY's birthday?","Who is the youngest member of the band?"};

String[] answers = {"2 Cool 4 Skool","Rookie King: Channel Bangtan","American Music Awards","July 9","Jungkook"};

String[] opt ={"2 Cool 4 Skool","We are Bulletproof","Skool Luv Affair","O!RUL8,2?","Run BTS","BTS Gayo","Rookie King: Channel Bangtan","American Hustle Life","American Music Awards","Billboard Music Awards","The Grammys","Teen Choice Awards","June 12","June 13","July 13","July 9","Jungkook","Suga","Jin","V"};

int flag=0;
public static int marks=0,correct=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bts);

        question = findViewById(R.id.question);
        question.setText(questions[flag]);
        confirm = findViewById(R.id.confirm);
        radio_g = findViewById(R.id.radioGroup);
        op1 = findViewById(R.id.option1);
        op1.setText(opt[flag]);
        op2 = findViewById(R.id.option2);
        op2.setText(opt[flag+1]);
        op3 = findViewById(R.id.option3);
        op3.setText(opt[flag+2]);
        op4 = findViewById(R.id.option4);
        op4.setText(opt[flag+3]);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1){
                    Toast.makeText(BtsActivity.this, "Please select one option", Toast.LENGTH_SHORT).show();
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
                    Intent intent = new Intent(BtsActivity.this,BTSResultActivity.class);

                    startActivity(intent);
                }
                radio_g.clearCheck();
            }
        });
    }
}