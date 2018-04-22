package com.example.konversisuhu;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView teks1,teks2;
    EditText edit1,edit2;
    RadioButton celsius,fahrenheit;
    RadioGroup radiosuhu;
    Button konversi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        teks1 = (TextView) findViewById(R.id.text1);
        teks2 = (TextView) findViewById(R.id.text2);
        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        celsius = (RadioButton) findViewById(R.id.celsius);
        fahrenheit = (RadioButton) findViewById(R.id.fahrenheit);
        radiosuhu = (RadioGroup) findViewById(R.id.radiosuhu);
        konversi = (Button)findViewById(R.id.konversi);

        radiosuhu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (celsius.isChecked()){
                    teks1.setText("Celsius");
                    teks2.setText("Fahrenheit");
                    Toast.makeText(MainActivity.this, "Celsius Ke Fahrenheit", Toast.LENGTH_SHORT).show();
                }
                else{
                    teks1.setText("Fahrenheit");
                    teks2.setText("Celsius");
                    Toast.makeText(MainActivity.this, "Fahrenheit Ke Celsius", Toast.LENGTH_SHORT).show();
                }
            }
        });
        konversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (celsius.isChecked()){
                    double cel = Double.parseDouble(edit1.getText().toString());
                    double rumus = (cel*9/5)+32;
                    edit2.setText(String.valueOf(rumus));
                }
                else {
                    double fah = Double.parseDouble(edit1.getText().toString());
                    double rumus = (fah-32)*5/9;
                    edit2.setText(String.valueOf(rumus));

                }
            }
        });
    }
}
