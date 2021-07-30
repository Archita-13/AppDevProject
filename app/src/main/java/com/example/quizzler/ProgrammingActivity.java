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

public class ProgrammingActivity extends AppCompatActivity {
    TextView question;
    Button confirm;
    RadioGroup radio_g;
    RadioButton op1, op2, op3, op4;


    String[] questions = {"Consider the 32 bit compiler. We need to store address of integer variable to integer pointer. What will be the size of integer pointer ?","Choose the correct statement:\nint a = 3.5 + 4.5;","What are Nibble, Word and Byte in computer language?","What is the value of an array element which is not initialized?","Which loop is faster in C Language, for, while or Do While?"};

    String[] answers = {"2 bytes","a = 7","Byte = 8 bits, Word= 2 Bytes, Nibble= 4 Bytes","Depends on Storage Class","All work at the same speed"};

    String[] opt= {"10 bytes", "2 bytes", "4 bytes", "6 bytes","a = 0","a = 7","a = 8","a = 8.0","Byte = 8 bits, Word= 4 Bytes, Nibble= 8 Bytes","Byte = 8 bits, Word= 2 Bytes, Nibble= 4 Bytes","Byte = 8 bits, Word= 12 Bits, Nibble= 32 Bits","Byte = 8 bits, Word= 24 Bits, Nibble= 40 Bits","By default 0","1","Depends on Storage Class","None of the above","for","while","do while","All work at the same speed"};
    int flag = 0;
    public static int marks = 0, correct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programming);

        question = findViewById(R.id.question_prog);
        question.setText(questions[flag]);
        confirm = findViewById(R.id.confirm_prog);
        radio_g = findViewById(R.id.radioGroup_prog);
        op1 = findViewById(R.id.option1_prog);
        op1.setText(opt[flag]);
        op2 = findViewById(R.id.option2_prog);
        op2.setText(opt[flag + 1]);
        op3 = findViewById(R.id.option3_prog);
        op3.setText(opt[flag + 2]);
        op4 = findViewById(R.id.option4_prog);
        op4.setText(opt[flag + 3]);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (radio_g.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(ProgrammingActivity.this, "Please select one option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();

                if (ansText == answers[flag]) {
                    correct = correct + 10;
                }
                ++flag;

                if (flag < questions.length) {
                    question.setText(questions[flag]);
                    op1.setText(opt[flag * 4]);
                    op2.setText(opt[flag * 4 + 1]);
                    op3.setText(opt[flag * 4 + 2]);
                    op4.setText(opt[flag * 4 + 3]);
                } else {
                    marks = correct;
                    Intent pro = new Intent(ProgrammingActivity.this,ProgrammingResult.class);

                    startActivity(pro);
                }
                radio_g.clearCheck();
            }
        });
    }
}