package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectCategoryActivity extends AppCompatActivity {
Button bts;
Button currentAffairs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        bts = findViewById(R.id.bts);
        currentAffairs = findViewById(R.id.currentAffairs);
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCategoryActivity.this, BtsActivity.class);
                startActivity(intent);
            }
        });
        currentAffairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent curr = new Intent(SelectCategoryActivity.this,CurrentAffairs.class);
                startActivity(curr);
            }
        });
    }
}