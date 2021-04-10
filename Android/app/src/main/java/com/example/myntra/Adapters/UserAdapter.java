package com.example.myntra.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.Model.ImageInterface;
import com.example.myntra.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    ArrayList<String> friends;
    Context context;
    ImageInterface imageInterface;

    public UserAdapter(ArrayList<String> friends, Context context) {
        this.friends = friends;
        this.context = context;
    }

    public UserAdapter(ImageInterface imageInterface) {
        this.imageInterface = imageInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.content_friend, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        String name = friends.get(position);
        holder.name.setText(name);

        holder.share.setOnClickListener(view -> {

//            imageInterface.SelectImage();

            holder.share.setVisibility(View.GONE);
//            holder.share.setBackgroundResource(R.drawable.ic_done);
            holder.done.setVisibility(View.VISIBLE);
            Toast.makeText(context, "Image shared successfully!", Toast.LENGTH_SHORT).show();

        });
    }



    @Override
    public int getItemCount() {
        return friends == null ? 0 : friends.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        Button share;
        GifImageView done;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_text);
            share = itemView.findViewById(R.id.btn_share);
            done = itemView.findViewById(R.id.anim);
        }
    }
}


