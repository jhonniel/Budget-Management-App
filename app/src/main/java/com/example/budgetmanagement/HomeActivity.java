package com.example.budgetmanagement;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView tvbalance, tvremarks, tvpbal, tvprem, tvebal, tverem, tvsbal, tvsrem;
    CheckBox cbe1, cbe2, cbe3, cbe4, cbs1, cbs2, cbs3, cbs4, cbp1, cbp2, cbp3, cbp4;
    Button btnsave, btncancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvbalance =(TextView)findViewById(R.id.tvbalance);
        tvremarks=(TextView)findViewById(R.id.tvremarks);
        tvpbal=(TextView)findViewById(R.id.tvpbal);
        tvprem=(TextView)findViewById(R.id.tvpremarks);
        tvebal=(TextView)findViewById(R.id.tvebal);
        tverem=(TextView)findViewById(R.id.tveremarks);
        tvsbal=(TextView)findViewById(R.id.tvsbal);
        tvsrem=(TextView)findViewById(R.id.tvsremarks);
        cbe1=(CheckBox)findViewById(R.id.cbe1);
        cbe2=(CheckBox)findViewById(R.id.cbe2);
        cbe3=(CheckBox)findViewById(R.id.cbe3);
        cbe4=(CheckBox)findViewById(R.id.cbe4);
        cbs1=(CheckBox)findViewById(R.id.cbs1);
        cbs2=(CheckBox)findViewById(R.id.cbs2);
        cbs3=(CheckBox)findViewById(R.id.cbs3);
        cbs4=(CheckBox)findViewById(R.id.cbs4);
        cbp1=(CheckBox)findViewById(R.id.cbp1);
        cbp2=(CheckBox)findViewById(R.id.cbp2);
        cbp3=(CheckBox)findViewById(R.id.cbp3);
        cbp4=(CheckBox)findViewById(R.id.cbp4);
        btnsave=(Button)findViewById(R.id.btnsave);
        btncancel=(Button)findViewById(R.id.btncancel);


        String balance = getIntent().getExtras().getString("income");
        tvbalance.setText("Balance: " + balance);

       /* String ess = getIntent().getExtras().getString("essbal");
        String sav = getIntent().getExtras().getString("personalbal");
        String per = getIntent().getExtras().getString("savingsbal");

        double essential = Double.parseDouble(ess.toString());
        double personal = Double.parseDouble(sav.toString());
        double savings = Double.parseDouble(per.toString()); */

        double bal = Double.parseDouble(balance.toString());
        double ebal= 0.50 * bal;
        double sbal= 0.20 * bal;
        double pbal= 0.30 * bal;


        tvebal.setText(String.valueOf(" Balance: " + ebal));
        tvpbal.setText(String.valueOf(" Balance: " + sbal));
        tvsbal.setText(String.valueOf(" Balance: " + pbal));


       // double partialbal= essential + personal + savings;
        //double avbal = partialbal - bal;

       // tvbalance.setText("Balance: " + avbal);
        btnsave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                double eb= ebal;
                double pb= pbal;
                double sb= sbal;

                //essential
                if(cbe1.isChecked()){
                    eb-=2000;
                }
                if(cbe2.isChecked()){
                    eb-=1000;
                }
                if(cbe3.isChecked()){
                    eb-=1000;
                }
                if(cbe4.isChecked()){
                    eb-=1000;
                }
                //savings
                if(cbs1.isChecked()){
                    sb-=1000;
                }
                if(cbs2.isChecked()){
                    sb-=500;
                }
                if(cbs3.isChecked()){
                    sb-=300;
                }
                if(cbs4.isChecked()){
                    sb-=500;
                }
                //personal
                if(cbp1.isChecked()){
                    pb-=1000;
                }
                if(cbp2.isChecked()){
                    pb-=500;
                }
                if(cbp3.isChecked()){
                    pb-=500;
                }
                if(cbp4.isChecked()){
                    pb-=0;
                }


                double res1 =eb, res2 =sb, res3 =pb;


                double ptotal= res1 + res2 + res3;


                tvbalance.setText(String.valueOf("Remaning: "+ ptotal));
                tvebal.setText(String.valueOf("Balance: "+ eb));
                tvsbal.setText(String.valueOf("Balance: "+ sb));
                tvpbal.setText(String.valueOf("Balance: "+ pb));

                String sremarks = getIntent().getExtras().getString("sremarks");
                tvsrem.setText(sremarks);

                if(sb<0){
                    tvsrem.setText("Deficit");
                    tvsrem.setTextColor(Color.RED);

                }
                else{

                    tvsrem.setText("On-Budget");
                    tvsrem.setTextColor(Color.BLUE);

                }

                String eremarks = getIntent().getExtras().getString("eremarks");
                tverem.setText(eremarks);

                if(eb<0){
                    tverem.setText("Deficit");
                    tverem.setTextColor(Color.RED);

                }
                else{

                    tverem.setText("On-Budget");
                    tverem.setTextColor(Color.BLUE);

                }
                String premarks = getIntent().getExtras().getString("premarks");
                tvprem.setText(premarks);

                if(pb<0){
                    tvprem.setText("Deficit");
                    tvprem.setTextColor(Color.RED);

                }
                else{

                    tvprem.setText("On-Budget");
                    tvprem.setTextColor(Color.BLUE);

                }
                String remarks = getIntent().getExtras().getString("remarks");
                tvremarks.setText(premarks);

                if(ptotal<0){
                    tvremarks.setText("Deficit");
                    tvremarks.setTextColor(Color.RED);

                }
                else{

                    tvremarks.setText("On-Budget");
                    tvremarks.setTextColor(Color.BLUE);

                }

            }

        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);

            }

        });







    }
}

