package com.example.budgetmanagement;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnenter;
    EditText tincome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnenter=(Button)findViewById(R.id.btnenter);
        tincome=(EditText)findViewById(R.id.tincome);





        //Button Enter
        btnenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(tincome.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please enter your Income/Salary.",Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    String income = tincome.getText().toString();
                    intent.putExtra("income", income );
                    startActivity(intent);
                    finish();
                }
            }
        });

    }
}