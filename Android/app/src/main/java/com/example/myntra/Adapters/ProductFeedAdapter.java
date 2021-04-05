package com.example.myntra.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.R;

import java.util.ArrayList;

public class ProductFeedAdapter extends RecyclerView.Adapter<ProductFeedAdapter.MyViewHolder> {

    private final ArrayList products;
    private Context context;

    public ProductFeedAdapter(ArrayList products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.content_product_feed, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.brand.setText((CharSequence) products.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, products.get(position)+" selected", Toast.LENGTH_SHORT).show();
            }
        });
//        holder.speak.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
////                    Toast.makeText(context, "Feature Not Support in your Device", Toast.LENGTH_SHORT).show();
////                }else {
////                    mTTS.speak(String.valueOf(numbers.get(position)), TextToSpeech.QUEUE_FLUSH, null);
////                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView brand,price,recommendation;
        ImageView product;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            brand = itemView.findViewById(R.id.product_brand);
            price = itemView.findViewById(R.id.product_price);
            recommendation = itemView.findViewById(R.id.product_recommendation);
            product = itemView.findViewById(R.id.product_img);



        }
    }
}


