package com.example.newproject;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout,new UserlistFragment());
        transaction.commit();

        final SharedPreferences shared = getSharedPreferences("PrefActivity", MODE_PRIVATE);
        final SharedPreferences.Editor editor = shared.edit();
        boolean isFirstRun = shared.getBoolean("FIRSTRUN", true);
        if (isFirstRun){
            startActivity(new Intent(MainActivity.this,SharedPrefrence.class));
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }


    }
}
