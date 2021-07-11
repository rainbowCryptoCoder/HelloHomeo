package com.rainbowCryptoCoder.spacex.repositry;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.rainbowCryptoCoder.spacex.dao.RecentItemDao;
import com.rainbowCryptoCoder.spacex.database.AppDatabase;
import com.rainbowCryptoCoder.spacex.model.RecentItem;

import java.util.List;

public class RecentRepositry {
    private final RecentItemDao dao;
    Application application;

    public RecentRepositry(Application application) {
        this.application=application;
        AppDatabase appDatabase = AppDatabase.getInstance(application);
        dao = appDatabase.recentItemDao();
    }


//    public LiveData<List<RecentItem>> getAllRecentsLiveData() {
//        return (LiveData<List<RecentItem>>) dao.getAllRecent();
//    }
//    public void deleteAllRecentsLiveData() {
//        return dao.delete();
//    }
}
