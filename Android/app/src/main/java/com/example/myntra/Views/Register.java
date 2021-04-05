package com.example.myntra.Views;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myntra.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    MaterialButton  btnSignUp;
    TextInputEditText username, pswrd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        btnSignUp = findViewById(R.id.sign_up_btn);
        username = findViewById(R.id.username_edit_text);
        pswrd = findViewById(R.id.password_edit_text);

        btnSignUp.setOnClickListener(view -> registerNewUser());}

            private void registerNewUser() {

                String email, password;
                email = username.getText().toString();
                password = pswrd.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter email!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(),
                            "Please enter password!!",
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {

                                String userId = mAuth.getCurrentUser().getUid();

                                Toast.makeText(getApplicationContext(),
                                        "Registration successful!",
                                        Toast.LENGTH_LONG)
                                        .show();

                                // if the user created intent to login activity
                                Intent intent
                                        = new Intent(Register.this,
                                        ProductFeed.class);
                                startActivity(intent);
                            } else {

                                // Registration failed
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Registration failed!!"
                                                + " Please try again later",
                                        Toast.LENGTH_LONG)
                                        .show(); }
                        });
            }
        }

