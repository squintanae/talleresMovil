package com.example.taller1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taller1.databinding.ActivityMainBinding;
import androidx.annotation.RequiresApi;
import android.os.Build;
import android.os.Bundle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    int fibonacci_calls, factorial_calls;
    String fibonacci_hour, factorial_hour;
    TextView txtFibo_Calls, txtFac_Calls, txtFibo_Hour, txtFac_Hour;

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("idfibonacci_calls", fibonacci_calls);
        bundle.putString("idfibonacci_hour", fibonacci_hour);
        bundle.putInt("idfactorial_calls", factorial_calls);
        bundle.putString("idfactorial_hour", factorial_hour);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fibonacci_calls = savedInstanceState.getInt("idfibonacci_calls");
        fibonacci_hour = savedInstanceState.getString("idfibonacci_hour");
        factorial_calls = savedInstanceState.getInt("idfactorial_calls");
        factorial_hour = savedInstanceState.getString("idfactorial_hour");
        txtFibo_Calls.setText( fibonacci_calls);
        txtFibo_Hour.setText( fibonacci_hour);
        txtFac_Calls.setText( factorial_calls);
        txtFac_Hour.setText( factorial_hour);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*
        txtFibo_Calls=findViewById(R.id.idfibonacci_calls);
        txtFibo_Hour=findViewById(R.id.idfibonacci_hour);

        txtFac_Calls =findViewById(R.id.idfactorial_calls);
        txtFac_Hour =findViewById(R.id.idfactorial_hour);
*/
        binding.botonFibonacci.setOnClickListener(view->{
            fibonacci_calls++;
            fibonacci_hour = current_time();
            binding.textViewFibonacciCalls.setText("Número de llamadas a la función: " + fibonacci_calls);
            binding.textViewFibonacciDate.setText("Ultima vez que se utilizó: " + fibonacci_hour);
            String number_for_fibonacci = binding.textFibonacci.getText().toString();
            Intent intent = new Intent(MainActivity.this,Fibonacci.class);
            intent.putExtra("number", Integer.parseInt(number_for_fibonacci));
            startActivity(intent);
        } );

        binding.botonFactorial.setOnClickListener(view -> {
            factorial_calls++;
            factorial_hour = current_time();
            binding.textViewFactorialCalls.setText("Número de llamadas a la función: " + factorial_calls);
            binding.textViewFactorialDate.setText("Ultima vez que se utilizó: " + factorial_hour);
            String factorial = binding.numeroSpinner.getSelectedItem().toString();
            Intent intent = new Intent(MainActivity.this, Factorial.class);
            intent.putExtra("number", Integer.parseInt(factorial));
            startActivity(intent);
        });

        binding.botonPaises.setOnClickListener(view->
            startActivity(new Intent(this,Countries.class)));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    String current_time(){
        DateTimeFormatter hour = DateTimeFormatter.ofPattern("HH:mm:ss");
        return hour.format(LocalDateTime.now());
    }
}