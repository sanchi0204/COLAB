package com.example.myntra.Views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.Adapters.UserAdapter;
import com.example.myntra.Model.Constants;
import com.example.myntra.Model.User;
import com.example.myntra.R;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Friends extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "Friends";
//   ArrayList<String> friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

//        User user = new User(Constants.NAME, Constants.EMAIL,Constants.CartList, Constants.WishList);
//        DocumentReference newUser = db.collection("Users").document();
//        newUser.set(user);

        recyclerView = findViewById(R.id.recycler_friend);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(Constants.friendList,this);
        recyclerView.setAdapter(userAdapter);

    }
}