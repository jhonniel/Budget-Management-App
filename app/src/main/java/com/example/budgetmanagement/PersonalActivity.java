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

public class PersonalActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3,cb4;
    Button btnpsave, btnpcancel;
    TextView tvpbal, tvpremarks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        addListenerOnButtonClick();
    }

    private void addListenerOnButtonClick() {

        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox4);
        btnpsave=(Button)findViewById(R.id.btnssave);
        btnpcancel=(Button)findViewById(R.id.btnsback);
        tvpbal=(TextView)findViewById(R.id.tvsbal);
        tvpremarks=(TextView)findViewById(R.id.tvsremarks);

        String sbal = getIntent().getExtras().getString("personal");
        double bal = Double.parseDouble(sbal.toString());
        double fbal= 0.30 * bal;
        tvpbal.setText(String.valueOf(" Balance: " + fbal));


        btnpsave.setOnClickListener(new View.OnClickListener(){
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
                    eb-=0;
                }
                if(cb4.isChecked()){
                    eb-=500;
                }

                tvpbal.setText(String.valueOf("Balance: "+ eb));


                String remarks = getIntent().getExtras().getString("remarks");
                tvpremarks.setText(remarks);

                if(eb<0){
                    tvpremarks.setText("Deficit");
                    tvpremarks.setTextColor(Color.RED);

                }
                else{
                    tvpremarks.setText("On-Budget");
                }

            }

        });

        btnpcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent pbal = new Intent(getApplicationContext(), HomeActivity.class);
                double personalbal = fbal;
                pbal.putExtra("personalbal", personalbal );
                startActivity(pbal);

            }

        });
    }
}