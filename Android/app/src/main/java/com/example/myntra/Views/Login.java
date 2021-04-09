package com.example.myntra.Views;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myntra.Model.Constants;
import com.example.myntra.Model.PopulateRecommendation;
import com.example.myntra.Model.User;
import com.example.myntra.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    MaterialButton btnSignIn;
    TextInputEditText username, pswrd, name;
    private FirebaseAuth mAuth;
    private static final String TAG = "Login";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        btnSignIn = findViewById(R.id.sign_in_btn);
        username = findViewById(R.id.username_edit_text);
        pswrd = findViewById(R.id.password_edit_text);
        name = findViewById(R.id.name_edit_text);
        btnSignIn.setOnClickListener(v -> loginUserAccount());
    }

    private void loginUserAccount() {

        String email, password,user_name;
        email = username.getText().toString();
        password = pswrd.getText().toString();
        user_name = name.getText().toString();

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

                                Constants.NAME = user_name;
                                Constants.EMAIL = email;

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

//
//        Intent i = new Intent(Login.this, Friends.class);
//        i.putExtra("name", name);
//        i.putExtra("email",email);

        db.collection("Users")
                .whereNotEqualTo("name", Constants.NAME)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        for (@NonNull QueryDocumentSnapshot document : task.getResult()) {

                            if (document.exists()) {
                                Log.d(TAG, "onCreate: " + document);
                                User userDet = document.toObject(User.class);
                                Log.d(TAG, "userDet: " + userDet);
                                Constants.friendList.add(userDet.getName());
//                                ArrayList<String> cartList = new ArrayList<>();
//                                ArrayList<String> wishList = new ArrayList<>();

                                for (String item : userDet.getCart()) {
                                    //cartList.add(item);
                                    Constants.friendCart.add(item);
                                    Log.d(TAG, "Added item: " + item);
                                    Log.d(TAG, "list status:" + Constants.friendCart);

                                }

                                for (String item : userDet.getWish()) {
                                  //  cartList.add(item);
                                    Constants.friendWish.add(item);
                                    Log.d(TAG, "Added item: " + item);
                                    Log.d(TAG, "list status:" + Constants.friendWish);
                                }


//                                PopulateRecommendation populateRecommendationCart = new PopulateRecommendation(userDet.getName(), cartList);
//                                Log.d(TAG, "poprecCart: Added all cart items");
//                                Log.d(TAG, "cartrec status"+ populateRecommendationCart);
//                                PopulateRecommendation populateRecommendationWish = new PopulateRecommendation(userDet.getName(), wishList);
//                                Log.d(TAG, "poprecwISH: Added all WISH items");
//                                Log.d(TAG, "wishrec status"+ populateRecommendationWish);
//
//                                Constants.recommendCart.add(populateRecommendationCart);
//                                Log.d(TAG, "final cart: "+ Constants.recommendCart);
//                                Constants.recommendWish.add(populateRecommendationWish);
//                                Log.d(TAG, "final wish: "+ Constants.recommendWish);
//                                Log.d(TAG, "onCreate: Added friend");
                            }
                        }
                    } else {
                        Log.d(TAG, "Error getting documents: ", task.getException());
                    }
                });
    }
    }
