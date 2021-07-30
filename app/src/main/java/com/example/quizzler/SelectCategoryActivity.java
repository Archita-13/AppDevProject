package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SelectCategoryActivity extends AppCompatActivity {
<<<<<<< Updated upstream

=======
Button bts;
Button sports;
>>>>>>> Stashed changes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
<<<<<<< Updated upstream
=======
        bts = findViewById(R.id.bts);
        sports=findViewById(R.id.sports);
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectCategoryActivity.this, Sports.class);
                startActivity(intent);
            }
        });
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectCategoryActivity.this, BtsActivity.class);
                startActivity(intent);
            }
        });
>>>>>>> Stashed changes
    }
}