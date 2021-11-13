package com.example.farmhelp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class details_form extends AppCompatActivity {

    Spinner soil;
    Spinner labour;
    Spinner land;
    EditText water;

    String Water_Cap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_form);

        soil = findViewById(R.id.soil_spinner);
        labour = findViewById(R.id.labour_spinner);
        land = findViewById(R.id.land_spinner);
        water = findViewById(R.id.water_editText);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.soil_type_array, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        soil.setAdapter(adapter1);


        setContentView(R.layout.activity_details_form);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.labour_capacity_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        labour.setAdapter(adapter2);


        setContentView(R.layout.activity_details_form);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.land_size_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        land.setAdapter(adapter3);
    }

    public void find_crop(View view) {
        Water_Cap = water.getText().toString();
        Toast.makeText(this, "This Feature is under Development", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Extra.class);
        startActivity(intent);

    }
}