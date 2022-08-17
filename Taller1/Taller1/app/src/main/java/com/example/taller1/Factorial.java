package com.example.taller1;

import android.os.Bundle;
import android.widget.TextView;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;


public class Factorial extends AppCompatActivity {
    TextView textViewOperation;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        textViewOperation = findViewById(R.id.text_view_operation);
        textViewResult = findViewById(R.id.text_view_result);

        factorial_function();
    }

    public void factorial_function(){
        int number = getIntent().getIntExtra("number",1);
        int result = 1;
        String operation = "Operación = ";
        for(int i = 1; i < number; i++){
            operation += String.valueOf(i) + " * ";
            result *= (i + 1);
        }
        textViewOperation.setText(operation + Integer.toString(number));
        textViewResult.setText("Resultado = " + Integer.toString(result));
    }
}
