package com.example.myapplicationtomcar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public class MainActivity extends AppCompatActivity {

    private ShapeableImageView header_t;
    private ShapeableImageView car_icon;
    private MaterialButton start_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),GameActivity.class);
                startActivity(i);
            }
        });
    }
    private void findViews(){
        header_t = findViewById(R.id.header_t);
        car_icon = findViewById(R.id.car_icon);
        start_button = findViewById(R.id.start_button);

    }
}