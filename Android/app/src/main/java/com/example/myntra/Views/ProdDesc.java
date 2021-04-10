package com.example.myntra.Views;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myntra.R;

public class ProdDesc extends AppCompatActivity {

    TextView brand,title;
    RatingBar ratingBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prod_desc);

        brand = findViewById(R.id.prod_brand);
        title = findViewById(R.id.title_content);
        ratingBar = findViewById(R.id.prod_rating);
        button = findViewById(R.id.btn_ar);

        float Rating = Float.parseFloat((String) getIntent().getExtras().get("rating"));

        ratingBar.setRating(Rating);
        brand.setText((CharSequence) getIntent().getExtras().get("brand"));
        title.setText((CharSequence) getIntent().getExtras().get("title"));
    }
}