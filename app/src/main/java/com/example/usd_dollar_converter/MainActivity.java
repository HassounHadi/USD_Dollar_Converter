package com.example.usd_dollar_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usd_amount;
    EditText lbp_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usd_amount = (EditText) findViewById(R.id.usd);
        lbp_amount = (EditText) findViewById(R.id.lbp);
    }

    public void convert(View v) {
        String usd_string = usd_amount.getText().toString();
        String lbp_string = lbp_amount.getText().toString();
        if (usd_string.isEmpty() && lbp_string.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please fill atleast one field.", Toast.LENGTH_LONG).show();
        }
        else if (!usd_string.isEmpty() && !lbp_string.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter only ONE field!", Toast.LENGTH_LONG).show();
        } else {
            if (usd_string.isEmpty()) {
                double lbp_d = Double.parseDouble(lbp_string);
                double usd_d = lbp_d / 22000;

                Toast.makeText(getApplicationContext(), String.format("%.2f$",usd_d), Toast.LENGTH_LONG).show();
            }

            else if (lbp_string.isEmpty()) {
                double usd_d = Double.parseDouble(usd_string);
                double lbp_d = usd_d / 22000;
                Toast.makeText(getApplicationContext(), String.format("%.2fL.L",lbp_d), Toast.LENGTH_LONG).show();
            }
        }
    }

}