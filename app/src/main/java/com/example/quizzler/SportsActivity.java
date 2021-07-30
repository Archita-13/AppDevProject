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

public class SportsActivity extends AppCompatActivity {
    TextView question;
    Button confirm;
    RadioGroup radio_g;
    RadioButton op1,op2,op3,op4;


    String[] questions = {"Usain bolt holds the world record of finishing the 100 m race in how many seconds?","Which Indian athlete was the first to win a medal in tokyo olympics 2020?","Michael Phelps holds the record for the most number of olympic gold medals. How many gold medals has he earned in the olympics till date?","Which football player holds the record for the most number of goals in Uefa Champions League history?","Roger Federer, Rafael Nadal, Novak Djokovic hold the record for the most number of grand slam titles. How many have they each won?"};

    String[] answers = {"9.58","Mirabai Chanu","23","Cristiano Ronaldo","20"};

    String[] opt ={"9.58", "9.89", "9.2","10.1","Manika Batra", "Mary Kom", "PV Sindhu", "Mirabai Chanu","20", "23", "34", "30","Lionel Messi", "Cristiano Ronaldo", "Robert Lewandowski", "Raul Gonzalez","21","20","18","22"};

    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        question = findViewById(R.id.question_sports);
        question.setText(questions[flag]);
        confirm = findViewById(R.id.confirm_sports);
        radio_g = findViewById(R.id.radioGroup_sports);
        op1 = findViewById(R.id.option1_sports);
        op1.setText(opt[flag]);
        op2 = findViewById(R.id.option2_sports);
        op2.setText(opt[flag+1]);
        op3 = findViewById(R.id.option3_sports);
        op3.setText(opt[flag+2]);
        op4 = findViewById(R.id.option4_sports);
        op4.setText(opt[flag+3]);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_g.getCheckedRadioButtonId()==-1){
                    Toast.makeText(SportsActivity.this, "Please select one option", Toast.LENGTH_SHORT).show();
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
                    Intent sports_result_page = new Intent(SportsActivity.this,SportsResult.class);

                    startActivity(sports_result_page);
                }
                radio_g.clearCheck();
            }
        });
    }
}