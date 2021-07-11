package com.rainbowCryptoCoder.spacex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.rainbowCryptoCoder.spacex.Retrofit.RetrofitInstance;
import com.rainbowCryptoCoder.spacex.Retrofit.RetrofitInterface;
import com.rainbowCryptoCoder.spacex.adapter.RecyclerViewAdapter;
import com.rainbowCryptoCoder.spacex.model.CrewModel;
import com.rainbowCryptoCoder.spacex.utils.Common;
import com.rainbowCryptoCoder.spacex.utils.Connectivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvMain;
    LottieAnimationView reloadButton, deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rv);
        reloadButton = findViewById(R.id.reloadLottie);
        deleteButton = findViewById(R.id.deleteLottie);

        rvMain.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        Common.checkInternetAndHandelViewInternet(this);

        if (!Connectivity.isConnectedWifi(this)){
            //if he go to the noInternet activity and not connect to internet and just press back ..
            //so here check another one..
            finish();

            Toast.makeText(this, "Please check your connection ", Toast.LENGTH_SHORT).show();
        }
        else {
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

        reloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    reloadButton.setSpeed(3f);
                    reloadButton.playAnimation();
            }
        });


        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    deleteButton.setSpeed(3f);
                    deleteButton.playAnimation();
            }
        });
    }

    private void parseData(List<CrewModel> body) {
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, body);
        rvMain.setAdapter(recyclerViewAdapter);
    }
}