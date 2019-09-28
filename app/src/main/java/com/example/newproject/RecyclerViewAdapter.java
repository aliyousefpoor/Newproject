package com.example.newproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<Data> list = Collections.emptyList();
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

        holder.firstname.setText(list.get(position).firstname);
        holder.lastname.setText(list.get(position).lastname);
        holder.email.setText(list.get(position).email);
        holder.avatar.setImageResource(list.get(position).imageId);

        holder.firstname.setOnClickListener(new View.OnClickListener() {
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