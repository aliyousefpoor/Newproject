package com.example.newproject;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    CardView cv;
    ImageView avatar;
    TextView firstname;
    TextView lastname;
    TextView email;

    public ViewHolder(View itemView) {

        super(itemView);

        cv = (CardView) itemView.findViewById(R.id.cardview);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        firstname = (TextView) itemView.findViewById(R.id.firstname);
        lastname = (TextView) itemView.findViewById(R.id.lastname);
        email = (TextView)itemView.findViewById(R.id.email);
    }


}
