package com.example.myntra.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.Model.Constants;
import com.example.myntra.Model.ProductType;
import com.example.myntra.R;
import com.example.myntra.Views.AddToQueueDialog;
import com.example.myntra.Views.ProdDesc;

import java.util.ArrayList;

public class ProductFeedAdapter extends RecyclerView.Adapter<ProductFeedAdapter.MyViewHolder> {

    ArrayList<ProductType> productItem;
    private final Context context;
    private static final String TAG = "ProductFeedAdapter";


    public ProductFeedAdapter(ArrayList<ProductType> productItem, Context context) {
        this.productItem = productItem;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.content_product_feed, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {



        holder.productLayout.setOnLongClickListener(view -> {
            AddToQueueDialog addToQueueDialog = new AddToQueueDialog((Activity) context);
            addToQueueDialog.show();
            return true;
        });


        holder.wishlist.setOnCheckedChangeListener((compoundButton, b) -> {
            if (holder.wishlist.isChecked() && position%2==0)
            {
                Constants.WishList.add(productItem.get(position).getProductId());
                holder.recommendation.setText("As you wished for it");
            }
        });

        holder.cart.setOnCheckedChangeListener((compoundButton, b) -> {
            if (holder.cart.isChecked() && position%2==0)
            {
                Constants.CartList.add(productItem.get(position).getProductId());
                holder.recommendation.setText("Suits your cart history");
            }
        });

        holder.like.setOnCheckedChangeListener((compoundButton, b) -> {
            if (holder.like.isChecked() && position%2==0)
            {
               // Constants.WishList.add(productItem.get(position).getProductId());
                holder.recommendation.setText("Trending");
            }
        });

        String rating,brand,pid;
        rating = String.valueOf(productItem.get(position).getRating());
        pid = productItem.get(position).getProductId();


        brand = productItem.get(position).getBrand();
        holder.brand.setText(brand);

        holder.productLayout.setOnClickListener(view -> {
            Intent intent=new Intent(context, ProdDesc.class);
            intent.putExtra("brand", brand);
            intent.putExtra("rating", rating);
            context.startActivity(intent);
        });



}

    @Override
    public int getItemCount() {
        return productItem == null ? 0 : productItem.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView brand,recommendation;
        ImageView productImg;
        CheckBox like, dislike, cart, wishlist;
        CardView productLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            brand = itemView.findViewById(R.id.product_brand);
            recommendation = itemView.findViewById(R.id.product_recommendation);
            productImg = itemView.findViewById(R.id.product_img);

            like = itemView.findViewById(R.id.like);
            dislike = itemView.findViewById(R.id.dislike);
            cart = itemView.findViewById(R.id.cart_ic);
            wishlist = itemView.findViewById(R.id.wishlist_ic);

            productLayout = itemView.findViewById(R.id.card_product);

        }
    }
}


