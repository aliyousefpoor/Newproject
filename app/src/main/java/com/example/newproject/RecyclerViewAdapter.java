package com.example.newproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Data> list ;
    Context context;

    public RecyclerViewAdapter(List<Data> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_row, parent, false);

        ViewHolder holder =new ViewHolder(view);
        return holder;
    }

    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.first_name.setText(list.get(position).getFirstname());
        holder.last_name.setText(list.get(position).getLastname());
        holder.email.setText(list.get(position).getEmail());
        Glide.with(context).load(list.get(position).getImguRL()).into(holder.avatar);

        holder.first_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




    }
});


    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

}