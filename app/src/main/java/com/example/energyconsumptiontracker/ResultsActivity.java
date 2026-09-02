package com.example.energyconsumptiontracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView txtAppliance;
    TextView txtDaily;
    TextView txtMonthly;
    TextView txtCost;
    TextView txtRating;
    TextView txtRecommendation;

    Button btnAgain;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        txtAppliance = findViewById(R.id.txtAppliance);
        txtDaily = findViewById(R.id.txtDaily);
        txtMonthly = findViewById(R.id.txtMonthly);
        txtCost = findViewById(R.id.txtCost);
        txtRating = findViewById(R.id.txtRating);
        txtRecommendation = findViewById(R.id.txtRecommendation);

        btnAgain = findViewById(R.id.btnAgain);
        btnExit = findViewById(R.id.btnExit);

        Intent intent = getIntent();

        String appliance =
                intent.getStringExtra("appliance");

        double daily =
                intent.getDoubleExtra("daily", 0);

        double monthly =
                intent.getDoubleExtra("monthly", 0);

        double cost =
                intent.getDoubleExtra("cost", 0);

        txtAppliance.setText(
                "Appliance: " + appliance);

        txtDaily.setText(
                "Daily Consumption: " + daily + " kWh");

        txtMonthly.setText(
                "Monthly Consumption: " + monthly + " kWh");

        txtCost.setText(
                "Monthly Cost: R" + cost);

        Recommendation recommendation =
                new Recommendation();

        String rating =
                recommendation.getRating(monthly);

        String advice =
                recommendation.getRecommendation(rating);

        txtRating.setText(
                "Rating: " + rating);

        txtRecommendation.setText(
                "Recommendation: " + advice);

        btnAgain.setOnClickListener(v -> {

            Intent againIntent =
                    new Intent(
                            ResultsActivity.this,
                            InputActivity.class);

            startActivity(againIntent);
        });

        btnExit.setOnClickListener(v -> {
            finishAffinity();
        });
    }
}