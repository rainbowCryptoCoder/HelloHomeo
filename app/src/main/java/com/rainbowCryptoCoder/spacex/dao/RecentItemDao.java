package com.rainbowCryptoCoder.spacex.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.rainbowCryptoCoder.spacex.model.RecentItem;

import java.util.List;

@Dao
public interface RecentItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRecent(RecentItem recentItem);


    @Query("SELECT * FROM RecentItem")
    LiveData<List<RecentItem>> getAllRecents();


    // todo .. add buttom for clear all recent and use this
    @Query("DELETE FROM RecentItem")
    void DeleteAllRecents();
}
