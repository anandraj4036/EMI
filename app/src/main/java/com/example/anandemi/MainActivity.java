package com.example.anandemi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText loanamount1;
    private EditText interest1;
    private EditText year1;
    private EditText month1;
    private TextView Emi2;

    private TextView tenure2;
    private TextView loanamount2;
    private TextView interstpayable2;
    private TextView totalpayment2;
    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loanamount1 = (EditText) findViewById(R.id.el);
        interest1 = (EditText) findViewById(R.id.interest);
        year1 = (EditText) findViewById(R.id.year);
        month1 = (EditText) findViewById(R.id.month);
        Emi2 = (TextView) findViewById(R.id.lemi);
        tenure2 = (TextView) findViewById(R.id.tenure);
        loanamount2 = (TextView) findViewById(R.id.loanAmount);
        interstpayable2 = (TextView) findViewById(R.id.interstpayable);
        totalpayment2 = (TextView) findViewById(R.id.totalpayment);
        btn1 = (Button) findViewById(R.id.btntotal);
        btn2 = (Button) findViewById(R.id.btnclear);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {double loanamount3 = Integer.parseInt(loanamount1.getText().toString());
                double interest3 = Integer.parseInt(interest1.getText().toString());
                int month3 = Integer.parseInt(month1.getText().toString());
                int year3 = Integer.parseInt(year1.getText().toString());

                int yearexchange = (year3 * 12) + month3;

                double principle = loanamount3 * (interest3 / 100);
                double power = Math.pow(interest3 / 100 + 1, yearexchange);
                double sum = principle / (1 - (1 / power));

                double totalinterest = sum + yearexchange - loanamount3;
                double totalpayment3 = loanamount3 + totalinterest;
                Emi2.setText(String.valueOf(sum));
                loanamount2.setText(String.valueOf(loanamount3));
                interstpayable2.setText(String.valueOf(totalinterest));

                totalpayment2.setText(String.valueOf(totalpayment3));


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText loanamount5 = (EditText) findViewById(R.id.el);
                EditText interest5 = (EditText) findViewById(R.id.interest);
                EditText year5 = (EditText) findViewById(R.id.year);
                EditText month5 = (EditText) findViewById(R.id.month);
                loanamount5.getText().clear();
                interest5.getText().clear();
                year5.getText().clear();
                month5.getText().clear();

            }
        });


    }}
