package com.example.myntra.Views;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.Adapters.UserAdapterDialog;
import com.example.myntra.Model.Constants;
import com.example.myntra.Model.PopulateRecommendation;
import com.example.myntra.Model.User;
import com.example.myntra.R;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class AddToQueueDialog extends Dialog {

    Activity mActivity;
    RecyclerView recyclerView;
    private Button save;
    private static final String TAG = "AddToQueueDialog";
   //ArrayList<String> friendList;
   FirebaseFirestore db = FirebaseFirestore.getInstance();

    public AddToQueueDialog(Activity activity){
        super(activity);
        mActivity = activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_to_queue);


        User user = new User(Constants.NAME, Constants.EMAIL,Constants.CartList, Constants.WishList);
        DocumentReference newUser = db.collection("Users").document();
        newUser.set(user);

        UserAdapterDialog userAdapterDialog = new UserAdapterDialog(Constants.friendList, getContext());

        recyclerView = findViewById(R.id.recycler_friend_dialog);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // friendList = new ArrayList<>();
//                db.collection("Users")
//                        .whereNotEqualTo("name", Constants.NAME)
//                .get()
//                .addOnCompleteListener(task -> {
//                    if (task.isSuccessful()) {
//                        for (@NonNull QueryDocumentSnapshot document : task.getResult()) {
//
//                            if (document.exists()) {
//                                Log.d(TAG, "onCreate: " + document);
//                                User userDet = document.toObject(User.class);
//                                Log.d(TAG, "userDet: " + userDet);
//                                Constants.friendList.add(userDet.getName());
//                                ArrayList<String> cartList = new ArrayList<>();
//                                ArrayList<String> wishList = new ArrayList<>();
//
//                                for (String item : userDet.getCart()) {
//                                    cartList.add(item);
//                                    Log.d(TAG, "Added item: " + item);
//                                    Log.d(TAG, "list status:" + cartList);
//
//                                }
//
//                                for (String item : userDet.getWish()) {
//                                    cartList.add(item);
//                                    Log.d(TAG, "Added item: " + item);
//                                    Log.d(TAG, "list status:" + cartList);
//                                }
//
//
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
//                            }
//                        }
//                    } else {
//                        Log.d(TAG, "Error getting documents: ", task.getException());
//                    }
//                });

//        ProductAdapter productAdapter = new ProductAdapter(productItemList,
//                getContext(),
//                Constants.recommendCart,
//                Constants.recommendWish);


        recyclerView.setAdapter(userAdapterDialog);

        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "Suggestions sent to your friends", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
}}