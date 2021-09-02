package com.example.budgetmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;

public class SavingsActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3,cb4;
    Button btnsave, btnscancel;
    TextView tvsbal, tvsremarks, tvsmpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savings);
        addListenerOnButtonClick();
    }

    private void addListenerOnButtonClick() {

        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox4);
        btnsave=(Button)findViewById(R.id.btnssave);
        btnscancel=(Button)findViewById(R.id.btnsback);
        tvsbal=(TextView)findViewById(R.id.tvsbal);
        tvsremarks=(TextView)findViewById(R.id.tvsremarks);

        String sbal = getIntent().getExtras().getString("savings");
        double bal = Double.parseDouble(sbal.toString());
        double fbal= 0.20 * bal;
        tvsbal.setText(String.valueOf(" Balance: " + fbal));


        btnsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                double eb= fbal;

                if(cb1.isChecked()){
                    eb-=1000;
                }
                if(cb2.isChecked()){
                    eb-=500;
                }
                if(cb3.isChecked()){
                    eb-=500;
                }
                if(cb4.isChecked()){
                    eb-=300;
                }

                tvsbal.setText(String.valueOf("Balance: "+ eb));


                String remarks = getIntent().getExtras().getString("remarks");
                tvsremarks.setText(remarks);

                if(eb<0){
                    tvsremarks.setText("Deficit");
                    tvsremarks.setTextColor(Color.RED);


                }
                else{
                    tvsremarks.setText("On-Budget");
                }

            }

        });

        btnscancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent sbal = new Intent(getApplicationContext(), HomeActivity.class);
                double savingsbal = fbal;
                sbal.putExtra("savingsbal", savingsbal );
                startActivity(sbal);

            }

        });
    }
  }
