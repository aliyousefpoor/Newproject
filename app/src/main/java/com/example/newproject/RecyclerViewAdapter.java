package com.example.newproject;

import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Datum> list;
    Context context;
    FragmentManager fragmentManager;



    public RecyclerViewAdapter(List<Datum> list, Context context , FragmentManager fragmentManager) {

        this.list = list;
        this.context = context;
        this.fragmentManager=fragmentManager;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_row, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override

    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.first_name.setText(list.get(position).getFirstName());
        holder.last_name.setText(list.get(position).getLastName());
        holder.email.setText(list.get(position).getEmail());
        Glide.with(context).load(list.get(position).getAvatar()).into(holder.avatar);



        holder.cv.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                SingleUserFragment singleUserFragment =new SingleUserFragment();


                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_layout,singleUserFragment);
                transaction.commit();

                singleUserFragment.setData();



            }


        });


    }



    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }




}