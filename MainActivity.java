package com.example.bmicalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText edtweight, edtheightft, edtheightin;
    Button edtbtn;
    TextView edtresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtweight = findViewById(R.id.edtwt);
        edtheightft = findViewById(R.id.edthtft);
        edtheightin = findViewById(R.id.edthtin);
        edtbtn = findViewById(R.id.edtbtn);
        edtresult = findViewById(R.id.edtresult);

        edtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int wt = Integer.parseInt(edtweight.getText().toString());
                int htft = Integer.parseInt(edtheightft.getText().toString());
                int htin = Integer.parseInt(edtheightin.getText().toString());

                int totalIn = htft * 12 + htin;
                double totalcm = totalIn * 2.54;
                double totalM = totalcm / 100;

                double BMI = wt / Math.pow(totalM, 2);

                if (BMI > 25) {
                    edtresult.setText("You are Over Weight");
                } else if (BMI < 18) {
                    edtresult.setText("You are Under Weight");
                } else {
                    edtresult.setText("Woohoo! You are Fine");
                }
            }
        });
    }
}