package com.example.myapplicationtomcar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST_LOCATION = 1;

    private ShapeableImageView header_t;
    private ShapeableImageView car_icon;
    private MaterialButton start_button;
    private MaterialButton start_button_Sensor;
    private MaterialButton start_button_RecordTable;
    private static Switch switch_mode;
    private static String type;

    //private static Switch switch_fast;
//    Boolean switchStateSlow;
//    Boolean switchStateFast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        checkLocationPermissions();
//        switchStateSlow = switch_slow.isChecked();
//        switchStateFast = switch_fast.isChecked();
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(),GameActivity.class);
                setType("b");
                //type = "button";
//                i.putExtra("Type",type);
////                i.putExtra("switchStateFast",switchStateFast);
//                startActivity(i);
                goToGameActivity(type);
            }
        });
        start_button_Sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setType("s");
                //type = "sensor";
//                Intent i = new Intent(getApplicationContext(),GameActivity.class);
//                i.putExtra("Type",type);
////                i.putExtra("switchStateFast",switchStateFast);
//                startActivity(i);
                goToGameActivity(type);
            }
        });
        start_button_RecordTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),RecordTableActivity.class);
                startActivity(i);
            }
        });
    }
    public void goToGameActivity(String type){
        Intent i = new Intent(getApplicationContext(),GameActivity.class);
//        i.putExtra("Type",type);
        startActivity(i);
    }
    private void findViews(){
        header_t = findViewById(R.id.header_t);
        car_icon = findViewById(R.id.car_icon);
        start_button = findViewById(R.id.start_button);
        start_button_Sensor = findViewById(R.id.start_button_Sensor);
        start_button_RecordTable = findViewById(R.id.start_button_RecordTable);
        switch_mode = findViewById(R.id.switch_mode);
        //switch_fast = findViewById(R.id.switch_fast);
    }
    public static Switch getSwitchMode(){ return switch_mode;}
//    public static Switch getSwitchFast(){ return switch_fast;}


    public static String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    private void checkLocationPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
        // Check if the app has permission to access location
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_LOCATION);
        } else {
            // Permission has already been granted, continue with using location
            // ...
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSIONS_REQUEST_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted, continue with using location
                // ...
            } else {
                // Permission has been denied, handle accordingly
                // ...
            }
        }
    }
}