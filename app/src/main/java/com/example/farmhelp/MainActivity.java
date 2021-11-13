package com.example.farmhelp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         
    }

    public void MoveOn(View view) {
        Intent intent = new Intent(this, MainLanding.class);
        startActivity(intent);
    }

    public void getWeather(View view){
        startActivity(new Intent(this,Weather.class));
    }
}