package com.example.spaceshipmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spaceshipmanagementsystem.db.SqliteHelper;

public class CreateOrEditSpaceshipActivity extends AppCompatActivity {

    private String title;
    private String myColor;
    private String mass;
    private String location;
    private String image = ""; //empty for now

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_edit_spaceship);
        setTitle("Add new Spaceship");

    }

    public void addSpaceshipDetails(View view) {

        SqliteHelper dbHelper = new SqliteHelper(this);

        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SqliteHelper.SpaceshipEntry.COLUMN_NAME_TITLE, title = ((EditText)findViewById(R.id.name)).getText().toString());
        values.put(SqliteHelper.SpaceshipEntry.COLUMN_NAME_MASS, mass = ((EditText)findViewById(R.id.mass)).getText().toString());
        values.put(SqliteHelper.SpaceshipEntry.COLUMN_NAME_COLOR, myColor = ((EditText)findViewById(R.id.color)).getText().toString());
        values.put(SqliteHelper.SpaceshipEntry.COLUMN_NAME_LOCATION, location = ((EditText)findViewById(R.id.location)).getText().toString());
        values.put(SqliteHelper.SpaceshipEntry.COLUMN_NAME_IMAGE_URL, image);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(SqliteHelper.SpaceshipEntry.TABLE_NAME, null, values);


        Toast.makeText(this, "Spaceship successfully added!", Toast.LENGTH_SHORT).show();
        backToMain(view);
    }

    public void backToMain(View view) {
        Intent back = new Intent(this, WelcomeActivity.class);
        startActivity(back);
    }
}