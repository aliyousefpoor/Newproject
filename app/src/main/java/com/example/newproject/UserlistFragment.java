package com.example.newproject;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserlistFragment extends Fragment {


    private RecyclerView recycleview;
    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView pullDown;
    private ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mianfragment, container, false);


        recycleview = view.findViewById(R.id.rcview);
        pullDown = view.findViewById(R.id.pulldown);
        swipeRefreshLayout =view.findViewById(R.id.swiprefreshing);
        imageView = view.findViewById(R.id.imgarrow);

        pullDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJson();
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchJson();
            }
        });

        fetchJson();

        return view;
    }

    private void fetchJson() {

        pullDown.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(true);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        RecyclerInterface api = retrofit.create(RecyclerInterface.class);
        Call<JsonClass> call = api.getString();

        call.enqueue(new Callback<JsonClass>() {
            @Override
            public void onResponse(Call<JsonClass> call, Response<JsonClass> response) {

                pullDown.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
                recycleview.setVisibility(View.VISIBLE);
                Log.d("Response", response.body().toString());

                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        writeRecycler(response.body());


                    } else {

                        Log.i("onEmptyResponse", "Return empty response");
                    }
                }


            }

            @Override
            public void onFailure(Call<JsonClass> call, Throwable t) {

                pullDown.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setRefreshing(false);
                recycleview.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Checking your Connection ", Toast.LENGTH_LONG).show();

                t.printStackTrace();


            }
        });

    }

    private void writeRecycler(JsonClass response) {

        Log.d("Response Writerecycler ", response.getData().toString());


        List<Datum> dataList = response.getData();


        Log.d("Response before adapter", response.getData().toString());
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dataList, getContext(),getFragmentManager());
        recycleview.setAdapter(adapter);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));



    }
}

