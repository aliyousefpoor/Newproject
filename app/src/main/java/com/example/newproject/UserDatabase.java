package com.example.newproject;

import android.content.Context;
import android.provider.SyncStateContract;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static UserDatabase INSTANCE;

    public static UserDatabase getInstance(Context context) {
        if (null == INSTANCE) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database")
                            .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }


    public static void destroyInstance(){

        INSTANCE=null;
    }


}
