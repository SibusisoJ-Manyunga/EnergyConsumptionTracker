package com.example.energyconsumptiontracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnStart;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnExit = findViewById(R.id.btnExit);

        btnStart.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            InputActivity.class);

            startActivity(intent);
        });

        btnExit.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}