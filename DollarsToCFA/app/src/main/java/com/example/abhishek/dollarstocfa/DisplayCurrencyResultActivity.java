package com.example.abhishek.dollarstocfa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class DisplayCurrencyResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_currency_result);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);
        System.out.println("In Display"+message);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.result_textview);
        textView.setText(message);
    }
}
