package com.example.newproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import java.util.List;


public class SingleUserFragment extends Fragment {




 public static SingleUserFragment newInstance() {
        SingleUserFragment fragment = new SingleUserFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pref_layout, container, false);
        Toast.makeText(getContext(),"okey shod",Toast.LENGTH_LONG).show();




        return view;

    }

    public void setData() {




    }
}