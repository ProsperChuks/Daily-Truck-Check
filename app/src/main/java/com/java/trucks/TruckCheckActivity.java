package com.java.trucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TruckCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck_check);
        setTitle(R.string.truck_check);
    }
}
