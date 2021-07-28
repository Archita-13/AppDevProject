package com.example.quizzler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etname;
    private EditText etpassword;
    private TextView textView;
    private Button button;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=(EditText)findViewById(R.id.etname);
        etpassword=(EditText)findViewById(R.id.etpassword);
        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);
        textView.setText("No. of attempts remaining : 5");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(etname.getText().toString(),etpassword.getText().toString());
            }
        });
    }
    private void validate(String username,String password){
        if((username.equals("Quiz"))&&(password.equals("Hello123"))){
            Intent intent=new Intent(MainActivity.this,Instructions.class);
            startActivity(intent);
        }else{
            counter--;
            textView.setText("No. of attempts remaining :"+String.valueOf(counter));
            if(counter==0){
                button.setEnabled(false);
            }
        }
    }
}