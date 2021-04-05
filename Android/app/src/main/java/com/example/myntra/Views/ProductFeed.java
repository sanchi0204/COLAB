package com.example.myntra.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myntra.Adapters.ProductFeedAdapter;
import com.example.myntra.R;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductFeed extends AppCompatActivity {

    RecyclerView recyclerViewProductFeed;
    LikeButton like, dislike, cart, wishlist;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_feed);

        like = findViewById(R.id.like);
        dislike = findViewById(R.id.dislike);
        cart = findViewById(R.id.cart_ic);
        wishlist = findViewById(R.id.wishlist_ic);

        //ButtonAction();

        ArrayList products = new ArrayList<>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));

        recyclerViewProductFeed = findViewById(R.id.recycler_product_feed);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerViewProductFeed.setLayoutManager(gridLayoutManager);

        ProductFeedAdapter productFeedAdapter = new ProductFeedAdapter(products,ProductFeed.this);
        recyclerViewProductFeed.setAdapter(productFeedAdapter);
    }

//    private void ButtonAction() {
//
//        like.setOnLikeListener(new OnLikeListener() {
//            @Override
//            public void liked(LikeButton likeButton) {
//
//            }
//
//            @Override
//            public void unLiked(LikeButton likeButton) {
//
//            }
//        });
//
//        dislike.setOnLikeListener(new OnLikeListener() {
//            @Override
//            public void liked(LikeButton likeButton) {
//
//            }
//
//            @Override
//            public void unLiked(LikeButton likeButton) {
//
//            }
//        });
//
//        cart.setOnLikeListener(new OnLikeListener() {
//            @Override
//            public void liked(LikeButton likeButton) {
//
//            }
//
//            @Override
//            public void unLiked(LikeButton likeButton) {
//
//            }
//        });
//        wishlist.setOnLikeListener(new OnLikeListener() {
//            @Override
//            public void liked(LikeButton likeButton) {
//
//            }
//
//            @Override
//            public void unLiked(LikeButton likeButton) {
//
//            }
//        });
//    }
}