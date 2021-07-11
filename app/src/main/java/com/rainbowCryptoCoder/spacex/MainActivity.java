package com.rainbowCryptoCoder.spacex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.rainbowCryptoCoder.spacex.Retrofit.RetrofitInstance;
import com.rainbowCryptoCoder.spacex.Retrofit.RetrofitInterface;
import com.rainbowCryptoCoder.spacex.adapter.RecyclerViewAdapter;
import com.rainbowCryptoCoder.spacex.model.CrewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rv);

        rvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        RetrofitInterface retrofitInterface = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<CrewModel>> listCall =  retrofitInterface.getCrew();
        listCall.enqueue(new Callback<List<CrewModel>>() {
            @Override
            public void onResponse(Call<List<CrewModel>> call, Response<List<CrewModel>> response) {
                parseData (response.body());
            }

            @Override
            public void onFailure(Call<List<CrewModel>> call, Throwable t) {

            }
        });
    }

    private void parseData(List<CrewModel> body) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(body);
        rvMain.setAdapter(recyclerViewAdapter);
    }
}