package com.example.spaceshipmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CreateOrEditSpaceshipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_edit_spaceship);
        setTitle("Add new Spaceship");
    }
}