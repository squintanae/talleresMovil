package com.example.taller1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taller1.databinding.ActivityCountriesBinding;
import com.example.taller1.databinding.ActivityMainBinding;

import android.widget.AdapterView;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class Countries extends AppCompatActivity{

    private ActivityCountriesBinding binding;
    private CountriesFromJson countriesFromJson = new CountriesFromJson();
    ListView listViewPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCountriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setContentView(R.layout.activity_countries);

        listViewPaises=findViewById(R.id.list_view_countries);
        ArrayList<String> listaNombres = new ArrayList<>();
        try {
            countriesFromJson.loadCountriesByJson(getAssets().open(CountriesFromJson.COUNTRIES_FILE));

            for (int i = 0; i < countriesFromJson.getCountries().length(); i++) {
                listaNombres.add(countriesFromJson.getCountries().getJSONObject(i).get("Name").toString());
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNombres);
            binding.listViewCountries.setAdapter(adapter);
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaNombres);

        listViewPaises.setAdapter(adapter);
        listViewPaises.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                Toast.makeText(getBaseContext(),String.format("Posicion en la lista: %s", pos),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Countries.this, CountryDetails.class);
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("name", countriesFromJson.getCountries().getJSONObject(pos).get("Name").toString());
                    bundle.putString("native_name", countriesFromJson.getCountries().getJSONObject(pos).get("NativeName").toString());
                    bundle.putString("region", countriesFromJson.getCountries().getJSONObject(pos).get("Region").toString());
                    bundle.putString("subregion", countriesFromJson.getCountries().getJSONObject(pos).get("SubRegion").toString());
                    bundle.putString("language", countriesFromJson.getCountries().getJSONObject(pos).get("Language").toString());
                    bundle.putString("latitude", countriesFromJson.getCountries().getJSONObject(pos).get("Latitude").toString());
                    bundle.putString("longitude", countriesFromJson.getCountries().getJSONObject(pos).get("Longitude").toString());
                    bundle.putString("flag", countriesFromJson.getCountries().getJSONObject(pos).get("FlagPng").toString());
                    intent.putExtra("bundle", bundle);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });


    }
}
