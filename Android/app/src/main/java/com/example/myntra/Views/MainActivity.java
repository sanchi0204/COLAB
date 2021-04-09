package com.example.myntra.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myntra.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.sign_in_btn);
        btnSignUp = findViewById(R.id.sign_up_btn);

        btnSignIn.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, Login.class);
            startActivity(i);
        });


        btnSignUp.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, Register.class);
            startActivity(i);
        });

    }
}