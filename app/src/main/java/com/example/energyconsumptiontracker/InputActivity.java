package com.example.energyconsumptiontracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    EditText edtAppliance;
    EditText edtPower;
    EditText edtHours;
    EditText edtTariff;

    Spinner spCategory;

    Button btnCalculate;
    Button btnClear;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        edtAppliance = findViewById(R.id.edtAppliance);
        edtPower = findViewById(R.id.edtPower);
        edtHours = findViewById(R.id.edtHours);
        edtTariff = findViewById(R.id.edtTariff);

        spCategory = findViewById(R.id.spCategory);

        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);

        dbHelper = new DatabaseHelper(this);

        String[] categories = {
                "Kitchen",
                "Entertainment",
                "Lighting",
                "Heating",
                "Cooling"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        categories);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spCategory.setAdapter(adapter);

        btnClear.setOnClickListener(v -> {
            edtAppliance.setText("");
            edtPower.setText("");
            edtHours.setText("");
            edtTariff.setText("");
            spCategory.setSelection(0);
        });

        btnCalculate.setOnClickListener(v -> {

            String appliance =
                    edtAppliance.getText().toString().trim();

            String powerText =
                    edtPower.getText().toString().trim();

            String hoursText =
                    edtHours.getText().toString().trim();

            String tariffText =
                    edtTariff.getText().toString().trim();

            if (appliance.isEmpty()
                    || powerText.isEmpty()
                    || hoursText.isEmpty()
                    || tariffText.isEmpty()) {

                Toast.makeText(
                        InputActivity.this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT).show();

                return;
            }

            try {

                double power =
                        Double.parseDouble(powerText);

                double hours =
                        Double.parseDouble(hoursText);

                double tariff =
                        Double.parseDouble(tariffText);

                String category =
                        spCategory.getSelectedItem().toString();

                ElectricityCalculator calculator =
                        new ElectricityCalculator();

                double daily =
                        calculator.calculateDailyConsumption(
                                power, hours);

                double monthly =
                        calculator.calculateMonthlyConsumption(
                                daily);

                double cost =
                        calculator.calculateMonthlyCost(
                                monthly, tariff);

                SQLiteDatabase db =
                        dbHelper.getWritableDatabase();

                ContentValues values =
                        new ContentValues();

                values.put("appliance", appliance);
                values.put("category", category);
                values.put("daily", daily);
                values.put("monthly", monthly);
                values.put("cost", cost);

                db.insert("reports", null, values);

                Intent intent =
                        new Intent(
                                InputActivity.this,
                                ResultsActivity.class);

                intent.putExtra("appliance", appliance);
                intent.putExtra("category", category);
                intent.putExtra("daily", daily);
                intent.putExtra("monthly", monthly);
                intent.putExtra("cost", cost);

                startActivity(intent);

            } catch (NumberFormatException e) {

                Toast.makeText(
                        InputActivity.this,
                        "Please enter valid numbers",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}