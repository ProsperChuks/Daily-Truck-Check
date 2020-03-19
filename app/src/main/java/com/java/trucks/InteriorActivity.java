package com.java.trucks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class InteriorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interior);
        setTitle(R.string.interior);
    }
}
