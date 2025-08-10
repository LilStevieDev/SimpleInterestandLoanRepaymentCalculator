package com.example.simpleinterestandloanrepaymentcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPrincipal, editTextRate, editTextTime;
    private Button buttonSimpleInterest, buttonLoanRepayment, buttonQuit;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrincipal = findViewById(R.id.editTextPrincipal);
        editTextRate = findViewById(R.id.editTextRate);
        editTextTime = findViewById(R.id.editTextTime);
        buttonSimpleInterest = findViewById(R.id.buttonSimpleInterest);
        buttonLoanRepayment = findViewById(R.id.buttonLoanRepayment);
        buttonQuit = findViewById(R.id.buttonQuit);
        textViewResult = findViewById(R.id.textViewResult);

        buttonSimpleInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSimpleInterest();
            }
        });

        buttonLoanRepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateLoanRepayment();
            }
        });

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Exit the app
            }
        });
    }

    private void calculateSimpleInterest() {
        if (validateInputs()) {
            double principal = Double.parseDouble(editTextPrincipal.getText().toString());
            double rate = Double.parseDouble(editTextRate.getText().toString());
            double time = Double.parseDouble(editTextTime.getText().toString());

            double simpleInterest = (principal * rate * time) / 100;
            textViewResult.setText(String.format("Simple Interest: R%.2f", simpleInterest));
        }
    }

    private void calculateLoanRepayment() {
        if (validateInputs()) {
            double principal = Double.parseDouble(editTextPrincipal.getText().toString());
            double rate = Double.parseDouble(editTextRate.getText().toString());
            double time = Double.parseDouble(editTextTime.getText().toString());

            double totalRepayment = principal + (principal * rate * time) / 100;
            double monthlyRepayment = totalRepayment / (time * 12);
            textViewResult.setText(String.format("Monthly Repayment: R%.2f", monthlyRepayment));
        }
    }

    private boolean validateInputs() {
        if (editTextPrincipal.getText().toString().isEmpty() ||
                editTextRate.getText().toString().isEmpty() ||
                editTextTime.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
