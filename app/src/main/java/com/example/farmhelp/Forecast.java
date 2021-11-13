package com.example.farmhelp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Forecast extends AppCompatActivity {


    double Lat, Lon;
    TextView tv;
    FusedLocationProviderClient mFusedLocationClient;
    int REQUEST_LOCATION = 1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        tv = findViewById(R.id.textView);


        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://api.openweathermap.org/data/2.5/forecast?lat="+Lat+"&lon="+Lon+"&appid=1e7d18ccc2a3c91bef18cbd807abba5a";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray array = (JSONArray)response.get("list");

                    JSONObject obj = (JSONObject)array.get(0);
                    String s1 = obj.getString("dt_txt");
                    JSONArray wobj = obj.getJSONArray("weather");
                    JSONObject array1 = wobj.getJSONObject(0);

                    String ws1=array1.getString("description");



                    JSONObject obj1 = (JSONObject)array.get(2);
                    String s2 = obj1.getString("dt_txt");
                    JSONArray wobj1 = obj1.getJSONArray("weather");
                    JSONObject array2 = wobj1.getJSONObject(0);

                    String ws2=array2.getString("description");




                    JSONObject obj2 = (JSONObject)array.get(4);
                    String s3 = obj2.getString("dt_txt");
                    JSONArray wobj2 = obj2.getJSONArray("weather");
                    JSONObject array3 = wobj2.getJSONObject(0);

                    String ws3=array3.getString("description");




                    JSONObject obj3 = (JSONObject)array.get(6);
                    String s4 = obj3.getString("dt_txt");
                    JSONArray wobj3 = obj3.getJSONArray("weather");
                    JSONObject array4 = wobj3.getJSONObject(0);

                    String ws4=array1.getString("description");




                    JSONObject obj4 = (JSONObject)array.get(8);
                    String s5 = obj4.getString("dt_txt");
                    JSONArray wobj4 = obj4.getJSONArray("weather");
                    JSONObject array5 = wobj4.getJSONObject(0);

                    String ws5=array1.getString("description");




                    JSONObject obj5 = (JSONObject)array.get(10);
                    String s6 = obj5.getString("dt_txt");
                    JSONArray wobj5 = obj5.getJSONArray("weather");
                    JSONObject array6 = wobj5.getJSONObject(0);

                    String ws6=array1.getString("description");




                    JSONObject obj6 = (JSONObject)array.get(12);
                    String s7 = obj6.getString("dt_txt");
                    JSONArray wobj6 = obj6.getJSONArray("weather");
                    JSONObject array7 = wobj6.getJSONObject(0);

                    String ws7=array1.getString("description");




                    JSONObject obj7 = (JSONObject)array.get(14);
                    String s8 = obj7.getString("dt_txt");
                    JSONArray wobj7 = obj7.getJSONArray("weather");
                    JSONObject array8 = wobj7.getJSONObject(0);

                    String ws8=array1.getString("description");




                    JSONObject obj8 = (JSONObject)array.get(16);
                    String s9 = obj8.getString("dt_txt");
                    JSONArray wobj8 = obj8.getJSONArray("weather");
                    JSONObject array9 = wobj8.getJSONObject(0);

                    String ws9=array1.getString("description");




                    JSONObject obj9 = (JSONObject)array.get(18);
                    String s10 = obj9.getString("dt_txt");
                    JSONArray wobj9 = obj9.getJSONArray("weather");
                    JSONObject array10 = wobj9.getJSONObject(0);

                    String ws10=array1.getString("description");




                    JSONObject obj10 = (JSONObject)array.get(20);
                    String s11 = obj10.getString("dt_txt");
                    JSONArray wobj10 = obj10.getJSONArray("weather");
                    JSONObject array11 = wobj10.getJSONObject(0);

                    String ws11=array1.getString("description");




                    tv.setText(s1+" :- "+ ws1+"\n"+s2+" :- "+ ws2+"\n"+ s3+" :- "+ ws3+"\n"+ s4+" :- "+ ws4+"\n"+ s5+" :- "+ ws5+"\n"+ s6+" :- "+ ws6+"\n"+ s7+" :- "+ ws7+"\n"+ s8+" :- "+ ws8+"\n"+ s9+" :- "+ ws9+"\n"+ s10+" :- "+ ws10+"\n"+ s11+" :- "+ ws11+"\n"

                    );

                    //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                } catch (JSONException e) {


                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);

    }


    private void getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                            Lat = location.getLatitude();
                            Lon = location.getLongitude();
                        }
                    }
                });
                } else {
                    Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            } else {
                requestPermissions();
            }
        }

        @SuppressLint("MissingPermission")
        private void requestNewLocationData () {
            LocationRequest mLocationRequest = new LocationRequest();
            mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            mLocationRequest.setInterval(5);
            mLocationRequest.setFastestInterval(0);
            mLocationRequest.setNumUpdates(1);

            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        }

        private LocationCallback mLocationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {
                Location mLastLocation = locationResult.getLastLocation();
                Lat = mLastLocation.getLatitude();
                Lon = mLastLocation.getLongitude();
            }
        };

        private boolean checkPermissions () {
            return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        }

        private void requestPermissions () {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }

        private boolean isLocationEnabled () {
            LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }

        @Override
        public void
        onRequestPermissionsResult( int requestCode, @NonNull String[] permissions,
        @NonNull int[] grantResults){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == REQUEST_LOCATION) {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLastLocation();
                } else {
                    Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
                }
            }


        }

        @Override
        public void onResume () {
            super.onResume();
            if (checkPermissions()) {
                getLastLocation();
            }
        }
    }
