package com.rainbowCryptoCoder.spacex.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rainbowCryptoCoder.spacex.dao.RecentItemDao;
import com.rainbowCryptoCoder.spacex.model.RecentItem;

@Database(entities = {RecentItem.class }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "recents";
    private static final String LOG_TAG ="AppDatabase" ;
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract RecentItemDao recentItemDao();
}
