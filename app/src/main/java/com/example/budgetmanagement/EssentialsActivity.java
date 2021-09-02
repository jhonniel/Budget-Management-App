package com.example.budgetmanagement;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EssentialsActivity extends AppCompatActivity {

    CheckBox cb1,cb2,cb3,cb4;
    Button btnsave, btncancel;
    TextView tvbal, tvremarks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essentials);
        addListenerOnButtonClick();

    }

    private void addListenerOnButtonClick() {

        cb1=(CheckBox)findViewById(R.id.checkBox);
        cb2=(CheckBox)findViewById(R.id.checkBox2);
        cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb4=(CheckBox)findViewById(R.id.checkBox4);
        btnsave=(Button)findViewById(R.id.btnesave);
        btncancel=(Button)findViewById(R.id.btneback);
        tvbal=(TextView)findViewById(R.id.tvebal);
        tvremarks=(TextView)findViewById(R.id.tveremarks);

        String ebal = getIntent().getExtras().getString("essentials");
        double bal = Double.parseDouble(ebal.toString());
        double fbal= 0.50 * bal;
        tvbal.setText(String.valueOf(" Balance: " + fbal));


        btnsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                double eb= fbal;

                if(cb1.isChecked()){
                    eb-=2000;
                }
                if(cb2.isChecked()){
                    eb-=1000;
                }
                if(cb3.isChecked()){
                    eb-=1000;
                }
                if(cb4.isChecked()){
                    eb-=1000;
                }

                tvbal.setText(String.valueOf("Balance: "+ eb));


                String remarks = getIntent().getExtras().getString("remarks");
                tvremarks.setText(remarks);

                if(eb<0){
                    tvremarks.setText("Deficit");
                    tvremarks.setTextColor(Color.RED);

                }
                else{
                    tvremarks.setText("On-Budget");
                }

            }

        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                double essbal = fbal;
                Intent ebal = new Intent(getApplicationContext(), HomeActivity.class);
                ebal.putExtra("essbal", essbal );
                startActivity(ebal);

            }

        });


    }
}
