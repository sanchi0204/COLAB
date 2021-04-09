package com.example.myntra.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.myntra.R;

public class ProdDesc extends AppCompatActivity {

    TextView brand;
    RatingBar ratingBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_desc);

        brand = findViewById(R.id.prod_brand);
        ratingBar = findViewById(R.id.prod_rating);
        button = findViewById(R.id.btn_ar);

        float Rating = Float.parseFloat((String) getIntent().getExtras().get("rating"));

        ratingBar.setRating(Rating);
        brand.setText((CharSequence) getIntent().getExtras().get("brand"));
    }
}