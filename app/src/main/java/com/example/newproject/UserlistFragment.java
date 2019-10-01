package com.example.newproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class UserlistFragment extends Fragment {



    private RecyclerView recycleview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mianfragment, container, false);


        recycleview = view.findViewById(R.id.rcview);

        fetchJson();

        return view;
    }

    private void fetchJson() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();


        RecyclerInterface api = retrofit.create(RecyclerInterface.class);
        Call<JsonClass> call = api.getString();

        call.enqueue(new Callback<JsonClass>() {
            @Override
            public void onResponse(Call<JsonClass> call, Response<JsonClass> response) {
                Log.d("Response",response.body().toString());

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
                t.printStackTrace();

            }
        });

    }

    private void writeRecycler(JsonClass response) {

        Log.d("Response Writerecycler ",response.getData().toString());



        List<Datum>  dataList = response.getData();


      Log.d("Response before adapter",response.getData().toString());
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(dataList, getContext());
        recycleview.setAdapter(adapter);
        recycleview.setLayoutManager(new LinearLayoutManager(getContext()));


        }
}

