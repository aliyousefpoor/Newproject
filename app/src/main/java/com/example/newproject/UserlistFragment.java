package com.example.newproject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class UserlistFragment extends Fragment {

    RecyclerView recycleview;
    List<Data> data = fill_with_data();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mianfragment, container, false);


        RecyclerView recycleview = (RecyclerView) view.findViewById(R.id.rcview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, getContext());
        recycleview.setAdapter(adapter);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;

    }


    public List<Data> fill_with_data() {

        List<Data> data = new ArrayList<>();
        data.add(new Data("ali","yousefpoor","asajsd@sd.com",R.drawable.gray));
        data.add(new Data("mehdi","delavar","asajsd@sd.com",R.drawable.gray));
        data.add(new Data("alireza","delavar","asajsd@sd.com",R.drawable.gray));
        data.add(new Data("ali","yousefpoor","asajsd@sd.com",R.drawable.gray));
        data.add(new Data("ali","yousefpoor","asajsd@sd.com",R.drawable.gray));
        data.add(new Data("ali","yousefpoor","asajsd@sd.com",R.drawable.gray));

        return data;

    }
}