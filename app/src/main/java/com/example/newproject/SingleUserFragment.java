package com.example.newproject;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.bumptech.glide.Glide;

import java.util.List;


public class SingleUserFragment extends Fragment {
    private TextView Name;
    private TextView Family;
    private TextView Id;
    private ImageView Image;
    private TextView Email;


    public static SingleUserFragment newInstance() {
        SingleUserFragment fragment = new SingleUserFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.single_user, container, false);
        Bundle bundle = getArguments();

        String first_name = getArguments().getString("Firstname");
        String last_name = getArguments().getString("Lastname");
        String email = getArguments().getString("Email");
        String avatar = getArguments().getString("Avatar");

        Name = view.findViewById(R.id.name);
        Family = view.findViewById(R.id.family);
        Email = view.findViewById(R.id.email);
        Image = view.findViewById(R.id.avatar);
        Name.setText(first_name);
        Family.setText(last_name);
        Email.setText(email);
        Glide.with(getContext()).load(avatar).into(Image);

        Toast.makeText(getContext(), "Transaction Succesfull", Toast.LENGTH_LONG).show();


        return view;

    }


    public void onBackPressed() {

    }


}