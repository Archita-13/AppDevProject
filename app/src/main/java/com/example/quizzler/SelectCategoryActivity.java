package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectCategoryActivity extends AppCompatActivity {
Button bts;
Button currentAffairs;
Button programming;
Button entertainment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        bts = findViewById(R.id.bts);
        currentAffairs = findViewById(R.id.currentAffairs);
        programming = findViewById(R.id.programming);
        entertainment = findViewById(R.id.entertainment);

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
        programming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent programming_page = new Intent(SelectCategoryActivity.this,ProgrammingActivity.class);
                startActivity(programming_page);
            }
        });
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entertainment_page = new Intent(SelectCategoryActivity.this,EntertainmentActivity.class);
                startActivity(entertainment_page);
            }
        });

    }
}