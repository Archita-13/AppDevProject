//Aditi Agarwal
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

public class CurrentAffairs extends AppCompatActivity {
    TextView question;
    Button confirm;
    RadioGroup radio_g;
    RadioButton op1,op2,op3,op4;


    String[] questions = {"FIDE is International Federation of which game?","Which Ministry is associated with National Logistics Excellence Awards?","Which institution has launched a new Scheme named \'FASTER\' or \'FAST and Secure Transmission of Electronic Records\'?","Where is Sohra town located?","Bhartiya Prakritic Krishi Paddhati is a sub-Scheme of which programme?"};

    String[] answers = {"Chess","Ministry of Commerce and Industry","Supreme Court of India","Madhya Pradesh","Paramparagat Krishi Vikas Yojna"};

    String[] opt ={"Football","Chess","Basketball","Hockey","Ministry of Commerce and Industry","Ministry of MSMC","Ministry of roads Transport and Highways","Ministry of Power","Reserve Bank of India","Supreme Court of India","Election Commission of India","Central Bureau of Investigation","Madhya Pradesh","Haryana","Rajasthan","Uttar Pradesh","Paramparagat Krishi Vikas Yojna","Pradhan Mantri Fazal Bima Yojna","Pradhan Mantri Matru Vardana Yojna","Pradhan Mantri KISAN"};

    int flag=0;
    public static int marks=0,correct=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_affairs);

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
                    Toast.makeText(CurrentAffairs.this, "Please select one option", Toast.LENGTH_SHORT).show();
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
                    Intent intent = new Intent(CurrentAffairs.this,currentAffairsResult.class);

                    startActivity(intent);
                }
                radio_g.clearCheck();
            }
        });
    }

}
