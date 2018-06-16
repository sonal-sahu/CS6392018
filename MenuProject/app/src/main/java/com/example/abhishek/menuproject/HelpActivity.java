package com.example.abhishek.menuproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Intent intent = getIntent();
        String message = intent.getStringExtra("help_name");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.help_page_id);
        textView.setText(message);
    }
}
