package com.rainbowCryptoCoder.spacex.database;

import android.content.Context;
import android.provider.SyncStateContract;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.rainbowCryptoCoder.spacex.dao.RecentItemDao;
import com.rainbowCryptoCoder.spacex.model.RecentItem;

@Database(entities = {RecentItem.class }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
            if (null == sInstance) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "DB_NAME")
                        .allowMainThreadQueries()
                        .build();
            }
            return sInstance;
        }

    public abstract RecentItemDao recentItemDao();
}
