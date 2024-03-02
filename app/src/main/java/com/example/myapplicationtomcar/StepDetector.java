package com.example.myapplicationtomcar;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class StepDetector {
    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;

    private int stepCountX = 0;
    private int stepCountY = 0;
    private long timestamp = 0l;

    private StepCallback stepCallback;

    public StepDetector(Context context, StepCallback stepCallback) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        this.stepCallback = stepCallback;
        initEventListener();
    }

    public int getStepCountX() {
        return stepCountX;
    }

    public int getStepCountY() {
        return stepCountY;
    }

    private void initEventListener() {
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0];
                float y = event.values[1];
                calculateStep(x, y);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // pass
            }
        };
    }

    private void calculateStep(float x, float y) {
        if (System.currentTimeMillis() - timestamp > 500) {
            timestamp = System.currentTimeMillis();
            if (x > 3.0) {
                stepCountX++;
                stepCallback.moveLeft();
            } else if (x < -3.0) {
                stepCountX++;
                stepCallback.moveRight();
            }
            if (y > 3.0) {
                stepCountY++;
                stepCallback.increaseSpeed();
            } else if (y < -3.0) {
                stepCountY++;
                stepCallback.decreaseSpeed();
            } else {
            }
        }
    }

    public void start(){
        sensorManager.registerListener(
                sensorEventListener,
                sensor,
                SensorManager.SENSOR_DELAY_NORMAL
        );
    }
    public void stop(){
        sensorManager.unregisterListener(
                sensorEventListener,
                sensor
        );
    }
}
