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
import retrofit2.converter.gson.GsonConverterFactory;
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
            public void onFailure(Call<JsonClass> call, Throwable t) {
                t.printStackTrace();

            }
        });

    }

    private void writeRecycler(String response) {

        try {
            JSONObject obj = new JSONObject(response);
            Log.d("object", obj.toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

           /* if (obj.optString("Status").equals("true")) {
                List<Data> list = new ArrayList<Data>();
                JSONArray dataList = obj.getJSONArray(data);

                for (int i = 0; i < dataList.length(); i++) {

                    Data data = new Data();
                    JSONObject dataobj = dataList.getJSONObject(i);

                    data.setImguRL(dataobj.getString("imguRL"));
                    data.setFirstname(dataobj.getString("first_name"));
                    data.setLastname(dataobj.getString("last_name"));
                    data.setEmail(dataobj.getString("email"));

                    list.add(data);
                }
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(list, getContext());
                recycleview.setAdapter(adapter);
                recycleview.setLayoutManager(new LinearLayoutManager(getContext()));


            } else {

                Toast.makeText(getContext(), obj.optString("message") + "", Toast.LENGTH_SHORT).show();

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}*/


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
//