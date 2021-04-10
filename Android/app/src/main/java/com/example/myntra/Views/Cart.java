package com.example.myntra.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myntra.R;

public class Cart extends AppCompatActivity {

    ImageView chatBot_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        chatBot_btn = findViewById(R.id.chatbot_btn);
        chatBot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Cart.this, Chatbot.class);
                startActivity(i);
            }
        });
    }
}