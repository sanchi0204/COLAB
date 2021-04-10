package com.example.myntra.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myntra.R;

import java.util.ArrayList;

public class UserAdapterDialog extends RecyclerView.Adapter<UserAdapterDialog.MyViewHolder> {

    ArrayList<String> friends;
    Context context;

    public UserAdapterDialog(ArrayList<String> friends, Context context) {
        this.friends = friends;
        this.context = context;
    }

    @NonNull
    @Override
    public UserAdapterDialog.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.content_friend_dialog, parent, false);
        UserAdapterDialog.MyViewHolder myViewHolder = new UserAdapterDialog.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterDialog.MyViewHolder holder, final int position) {

        String name = friends.get(position);
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return friends == null ? 0 : friends.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_text);



        }
    }
}



