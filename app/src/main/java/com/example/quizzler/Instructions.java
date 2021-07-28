package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instructions extends AppCompatActivity {
Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        proceed = findViewById(R.id.button3);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Instructions.this, SelectCategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}