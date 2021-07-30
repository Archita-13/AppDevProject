package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Instructions extends AppCompatActivity {
    private EditText EmailID;
    private EditText dob;
    private EditText place;
    private Button submit;
    private Button proceed;
    DMManager DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        EmailID=findViewById(R.id.EmailID);
        dob=findViewById(R.id.dob);
        place=findViewById(R.id.place);
        submit=findViewById(R.id.submit);
        proceed=findViewById(R.id.proceed);
        DB=new DMManager(this);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Instructions.this,SelectCategoryActivity.class);
                startActivity(intent);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EmailIDTXT = EmailID.getText().toString();
                String dobTXT=dob.getText().toString();
                String placeTXT=place.getText().toString();
                Boolean checkinsertdata=DB.insertuserdata(EmailIDTXT,dobTXT,placeTXT);
                Toast.makeText(Instructions.this,"Submitted successfully !",Toast.LENGTH_SHORT).show();
            }

        });


    }
}