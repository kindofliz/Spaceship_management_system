package com.example.spaceshipmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit1 = findViewById(R.id.username);
        edit2 = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LOGIN
                logIn();
            }
        });
    }

    public void logIn() {
        String username = edit1.getText().toString();
        String password = edit2.getText().toString();

        //Validation of the username and password
        if (username.equals("") || password.equals("")) {
            Toast.makeText(this, "Username or Password is empty!", Toast.LENGTH_SHORT).show();
        } else if (username.equals("Liza") && password.equals("qwerty")) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent welcome = new Intent(LoginActivity.this, WelcomeActivity.class);
            welcome.putExtra("USERNAME", username);
            startActivity(welcome);
        } else {
            Toast.makeText(this, "Username or Password is incorrect!", Toast.LENGTH_SHORT).show();
        }
    }
}