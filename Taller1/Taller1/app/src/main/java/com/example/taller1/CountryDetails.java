package com.example.taller1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1.databinding.ActivityCountriesBinding;
import com.example.taller1.databinding.ActivityCountryDetailsBinding;
import com.example.taller1.databinding.ActivityMainBinding;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class CountryDetails extends AppCompatActivity{
    private ActivityCountryDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountryDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getBundleExtra("bundle");
        binding.textViewName.setText(bundle.getString("name"));
        binding.textViewNativeName.setText(bundle.getString("native_name"));
        binding.textViewRegion.setText("Region: " + bundle.getString("region"));
        binding.textViewSubregion.setText("Sub Region: " + bundle.getString("subregion"));
        binding.textViewRegion.setText("Region: " + bundle.getString("region"));
        binding.textViewRegion.setText("Idioma: " + bundle.getString("language"));
        binding.textViewRegion.setText("Latitud: " + bundle.getString("latitude"));
        binding.textViewRegion.setText("Longitud: " + bundle.getString("longitude"));
        binding.webViewFlag.loadUrl(bundle.getString("flag"));

    }
}




