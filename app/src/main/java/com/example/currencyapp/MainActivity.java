package com.example.currencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spnr;
    EditText numberinput;
    Button convertButton;
    TextView result1;
    TextView result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnr = findViewById(R.id.currencySpinner);
        numberinput = findViewById(R.id.currencyEditInput);
        convertButton = findViewById(R.id.buttonConvert);
        result1 = findViewById(R.id.textResult1);
        result2 = findViewById(R.id.textResult2);

        result1.setText("");
        result2.setText("");

        List<String> categories = new ArrayList<String>();
        categories.add("MAD");
        categories.add("USD");
        categories.add("EUR");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnr.setAdapter(dataAdapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cur = spnr.getSelectedItem().toString();
                double amount = Float.parseFloat(numberinput.getText().toString());
                DecimalFormat f = new DecimalFormat("#####################.##");

                if (cur.equals("MAD")){

                    double madToUsd = amount * 0.097;
                    double madToEur = amount * 0.091;
                    result1.setText("USD : " + f.format(madToUsd));
                    result2.setText("EUR : " + f.format(madToEur));
                } else if (cur.equals("USD")){

                    double usdToMad = amount * 10.34;
                    double usdToEur = amount * 0.94;
                    result1.setText("MAD : " + f.format(usdToMad));
                    result2.setText("EUR : " + f.format(usdToEur));
                } else if (cur.equals("EUR")){

                    double eurToUsd = amount * 1.06;
                    double eurToMad = amount * 11.01;
                    result1.setText("MAD : " + f.format(eurToMad));
                    result2.setText("USD : " + f.format(eurToUsd));
                }


            }
        });
    }
}