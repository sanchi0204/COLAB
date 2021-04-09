package com.example.myntra.Views;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myntra.Model.Constants;
import com.example.myntra.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity {

    MaterialButton  btnSignUp;
    TextInputEditText username;
    TextInputEditText pswrd;
    TextInputEditText fname;
    private FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "Register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        btnSignUp = findViewById(R.id.sign_up_btn);
        username = findViewById(R.id.username_edit_text);
        pswrd = findViewById(R.id.password_edit_text);
        fname = findViewById(R.id.name_edit_text);

        btnSignUp.setOnClickListener(view -> registerNewUser());}

            private void registerNewUser() {

                String email;
                String password;
                String name;

                name = fname.getText().toString();
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

                                Constants.NAME = name;
                                Constants.EMAIL = email;

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
                                Log.d(TAG, "registerNewUser: Registration failed");
                            }
                        });


            }
        }

