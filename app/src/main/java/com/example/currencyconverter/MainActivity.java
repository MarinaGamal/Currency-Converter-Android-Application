package com.example.currencyconverter;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText usd;
    EditText egp;
    boolean usdDot=false;
    boolean egpDot=false;
    char egpArray[];
    char usdArray[];

    DecimalFormat df = new DecimalFormat("#.##########");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usd = findViewById(R.id.usd);
        egp = findViewById(R.id.egp);

        usd.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(usd.isFocused())
                {
                    if(usd.getText().toString().length() > 0) {
                        usdArray=usd.getText().toString().toCharArray();
                        if(usdArray[0]=='.' )
                        {

                            usdDot=true;
                            usd.setText(0+".");
                            usd.setSelection(2);

                        }
                        float Usd = Float.parseFloat(usd.getText().toString());
                        float converted = Usd * (float) 16.3;
                        String conv = df.format(converted);
                        egp.setText(conv);
                    }
                    else if(usd.getText().toString().length()==0)
                    {
                        egp.getText().clear();
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });


        egp.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                float converted;
                if(egp.isFocused()){
                        if(egp.getText().toString().length() > 0) {
                            egpArray=egp.getText().toString().toCharArray();
                        if(egpArray[0]=='.')
                        {
                            egpDot=true;
                            egp.setText(0+".");
                            egp.setSelection(2);
                        }
                            float Egp = Float.parseFloat(egp.getText().toString());
                            converted = Egp / (float) 16.3;
                            String conv = df.format(converted);
                            usd.setText(conv);
                        }
                        else if(egp.getText().toString().length()==0)
                        {
                            usd.setText("");
                        }
                    }
                }

                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                public void afterTextChanged(Editable s) {

                }
        });
    }
}

