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

public class Login extends AppCompatActivity {

    MaterialButton btnSignIn;
    TextInputEditText username, pswrd;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        btnSignIn = findViewById(R.id.sign_in_btn);
        username = findViewById(R.id.username_edit_text);
        pswrd = findViewById(R.id.password_edit_text);

        btnSignIn.setOnClickListener(v -> loginUserAccount());
    }

    private void loginUserAccount() {

        String email, password;
        email = username.getText().toString();
        password = pswrd.getText().toString();

        // validations for input email and password
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

        // signin existing user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()) {

                                String userId = mAuth.getCurrentUser().getUid();

                                Toast.makeText(getApplicationContext(),
                                        "Login successful!!",
                                        Toast.LENGTH_LONG)
                                        .show();


                                // if sign-in is successful
                                // intent to home activity
                                Intent intent
                                        = new Intent(Login.this,
                                        ProductFeed.class);
                                startActivity(intent);
                            }

                            else {

                                // sign-in failed
                                Toast.makeText(getApplicationContext(),
                                        "Login failed!!",
                                        Toast.LENGTH_LONG)
                                        .show();

                            }
                        });
    }
    }
