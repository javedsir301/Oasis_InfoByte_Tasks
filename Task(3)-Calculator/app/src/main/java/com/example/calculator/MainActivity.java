package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char currentSymbol;

    private double firstValue = Double.NaN;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        decimalFormat = new DecimalFormat("#.##########");

        inputDisplay = findViewById(R.id.result_tv);
        outputDisplay = findViewById(R.id.solution_tv);

        MaterialButton button0 = findViewById(R.id.button_0);
        MaterialButton button1 = findViewById(R.id.button_1);
        MaterialButton button2 = findViewById(R.id.button_2);
        MaterialButton button3 = findViewById(R.id.button_3);
        MaterialButton button4 = findViewById(R.id.button_4);
        MaterialButton button5 = findViewById(R.id.button_5);
        MaterialButton button6 = findViewById(R.id.button_6);
        MaterialButton button7 = findViewById(R.id.button_7);
        MaterialButton button8 = findViewById(R.id.button_8);
        MaterialButton button9 = findViewById(R.id.button_9);
        MaterialButton buttonAdd = findViewById(R.id.button_plus);
        MaterialButton buttonSub = findViewById(R.id.button_minus);
        MaterialButton buttonDivide = findViewById(R.id.button_divide);
        MaterialButton buttonDot = findViewById(R.id.button_dot);
        MaterialButton buttonMultiply = findViewById(R.id.button_multiply);
        MaterialButton buttonClear = findViewById(R.id.button_c);
        MaterialButton buttonAC = findViewById(R.id.button_ac);
        MaterialButton buttonEqual = findViewById(R.id.button_equals);
        MaterialButton buttonOpenParentheses = findViewById(R.id.button_open_bracket);
        MaterialButton buttonCloseParentheses = findViewById(R.id.button_close_bracket);

        button0.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "0"));

        button1.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "1"));

        button2.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "2"));

        button3.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "3"));

        button4.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "4"));

        button5.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "5"));

        button6.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "6"));

        button7.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "7"));

        button8.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "8"));

        button9.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "9"));

        buttonOpenParentheses.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "("));

        buttonCloseParentheses.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + ")"));


        buttonAdd.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = ADDITION;
            outputDisplay.setText(decimalFormat.format(firstValue) + "+");
            inputDisplay.setText(null);
        });

        buttonSub.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = SUBTRACTION;
            outputDisplay.setText(decimalFormat.format(firstValue) + "-");
            inputDisplay.setText(null);
        });

        buttonMultiply.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = MULTIPLICATION;
            outputDisplay.setText(decimalFormat.format(firstValue) + "*");
            inputDisplay.setText(null);
        });

        buttonDivide.setOnClickListener(view -> {
            allCalculations();
            currentSymbol = DIVISION;
            outputDisplay.setText(decimalFormat.format(firstValue) + "/");
            inputDisplay.setText(null);
        });



        buttonDot.setOnClickListener(view -> inputDisplay.setText(inputDisplay.getText() + "."));

        buttonClear.setOnClickListener(view -> {
            if (inputDisplay.getText().length() > 0) {
                CharSequence currentText = inputDisplay.getText();
                inputDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
            } else {
                firstValue = Double.NaN;
                secondValue = Double.NaN;
                inputDisplay.setText("");
                outputDisplay.setText("");
            }
        });

        buttonAC.setOnClickListener(v -> clearInput());

        buttonEqual.setOnClickListener(view -> {
            allCalculations();
            outputDisplay.setText(decimalFormat.format(firstValue));
            firstValue = Double.NaN;
            currentSymbol = '0';
        });
    }

    private void clearInput() {
        firstValue = Double.NaN;
        secondValue = Double.NaN;
        inputDisplay.setText("");
        outputDisplay.setText("");
    }



    private void allCalculations(){
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);

            if (currentSymbol == ADDITION)
                firstValue = this.firstValue + secondValue;
            else if (currentSymbol == SUBTRACTION)
                firstValue = this.firstValue - secondValue;
            else if (currentSymbol == MULTIPLICATION)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == DIVISION)
                firstValue = this.firstValue / secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            } catch (Exception ignored) {

            }
        }
    }
}