package com.example.myntra.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.example.myntra.Model.PopulateRecommendation;
import com.example.myntra.Model.ProductType;
import com.example.myntra.R;
import com.example.myntra.Views.AddToQueueDialog;
import com.example.myntra.Views.ProdDesc;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<ProductType> productItem;
    private final Context context;
//    ArrayList<PopulateRecommendation> recCart;
//    ArrayList<PopulateRecommendation> recWish;
    ArrayList<String> fcart;
    ArrayList<String> fwish;
    private static final String TAG = "ProductFeedAdapter";

    public ProductAdapter(ArrayList<ProductType> productItem, Context context, ArrayList<String> fcart, ArrayList<String> fwish) {
        this.productItem = productItem;
        this.context = context;
        this.fcart = fcart;
        this.fwish = fwish;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.content_product_feed, parent, false);
        return new ProductAdapter.MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, final int position) {


        String rating,brand,pid;
        rating = String.valueOf(productItem.get(position).getRating());
        pid = productItem.get(position).getProductId();

        Log.d(TAG, "pid:"+ pid);
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


        if(position%2!=0) {

            Log.d(TAG, "onBindViewHolder: Entered the condition");
//            for (int i = 0; i < recCart.size(); i++) {
//                Log.d(TAG, "cartlistitem: "+recCart.get(i));
//                for (int j = 0; j < recCart.get(i).getPid().size(); j++) {
//                    Log.d(TAG, "cartlist item id: "+recCart.get(i).getPid());
//                    if (recCart.get(i).getPid().equals(pid)) {
//                        holder.recommendation.setText(recCart.get(i).getName() + "added it to cart");
//                        Log.d(TAG, "match condn: item matched"+recCart.get(i).getName());
//                    }
//                }
//            }

//            for (int i = 0; i < recWish.size(); i++) {
//                for (int j = 0; j < recWish.get(i).getPid().size(); j++) {
//                    if (String.valueOf(recWish.get(i).getPid()).equals(pid))
//                        holder.recommendation.setText("Suggested by" + recWish.get(i).getName());
//                }
//            }

            for (int i=0;i<fcart.size();i++) {
                Log.d(TAG, "loop cart: entered loop");
                if (fcart.get(i).equals(pid)) {
                    Log.d(TAG, "match found");
                    holder.recommendation.setText("Your friend added it to cart");
                    Log.d(TAG, "added rec");
                }
            }


            for (int i=0;i<fwish.size();i++) {
                Log.d(TAG, "loop wish: entered loop");
                if (fwish.get(i).equals(pid)) {
                    Log.d(TAG, "match found");
                    holder.recommendation.setText("Suggested by your friend");
                    Log.d(TAG, "added rec");
                }
            }

            if(holder.recommendation.getText().length()==0)
                holder.recommendation.setText("Your friend rated this as " + rating);

        }




        brand = productItem.get(position).getBrand();
        holder.brand.setText(brand);

        holder.productLayout.setOnClickListener(view -> {
            Intent intent=new Intent(context, ProdDesc.class);
            intent.putExtra("brand", brand);
            intent.putExtra("rating", rating);
            context.startActivity(intent);
        });

        holder.productLayout.setOnLongClickListener(view -> {
            AddToQueueDialog addToQueueDialog = new AddToQueueDialog((Activity) context);
            addToQueueDialog.show();
            return true;
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


