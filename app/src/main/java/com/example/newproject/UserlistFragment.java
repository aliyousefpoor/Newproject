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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class UserlistFragment extends Fragment {

    private RecyclerViewAdapter adapter;
    private RecyclerView recycleview;
    //  List<Data> data = fill_with_data();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mianfragment, container, false);


        RecyclerView recycleview = (RecyclerView) view.findViewById(R.id.rcview);
        // RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, getContext());
        //recycleview.setAdapter(adapter);
        //recycleview.setLayoutManager(new LinearLayoutManager(getContext()));
        //return view;
        fetchJson();


    }

    private void fetchJson() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(RecyclerInterface.JSONURL)
                .addConverterFactory(ScalarsConverterFactory.create()).build();


        RecyclerInterface api = retrofit.create(RecyclerInterface.class);
        Call<String> call = api.getString();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("ResponseString", response.body().toString());
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSucces", response.body().toString());
                        String jsonresponse = response.body().toString();
                        writeRecycler(jsonresponse);

                    } else {

                        Log.i("onEmptyResponse", "Return empty response");
                    }
                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    private void writeRecycler(String response) {

        try {
            JSONObject obj = new JSONObject(response);
            if (obj.optString("Status").equals("true")) {
                List<Data> datalist = new List<>();
                JSONArray dataArray = obj.getJSONArray(dataa);

                for (int i = 0; i < dataArray.length(); i++) {

                    Data data = new Data();
                    JSONObject dataobj = dataArray.getJSONObject(i);

                    data.setImguRL(dataobj.getString("imguRL"));
                    data.setFirstname(dataobj.getString("firstname"));
                    data.setLastname(dataobj.getString("lastname"));
                    data.setEmail(dataobj.getString("email"));

                    datalist.add(data);
                }
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(datalist, getContext());
                recycleview.setAdapter(adapter);
                recycleview.setLayoutManager(new LinearLayoutManager(getContext()));


            } else {

                Toast.makeText(UserlistFragment.this, obj.optString("message") + "", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}





//public List<Data> fill_with_data() {

//     List<Data> data = new ArrayList<>();
//     data.add(new Data("ali","yousefpoor","asajsd@sd.com",R.drawable.gray));
//   data.add(new Data("mehdi","delavar","asajsd@sd.com",R.drawable.gray));
//  data.add(new Data("alireza","delavar","asajsd@sd.com",R.drawable.gray));
//data.add(new Data("ali","yousefpoor","asajsd@sd.com",R.drawable.gray));
//     data.add(new Data("ali","yousefpoor","asajsd@sd.com",R.drawable.gray));
//   data.add(new Data("ali","yousefpoor","asajsd@sd.com",R.drawable.gray));

//  return data;

// }
//}