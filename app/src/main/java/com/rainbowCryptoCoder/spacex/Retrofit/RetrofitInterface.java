package com.rainbowCryptoCoder.spacex.Retrofit;

import com.rainbowCryptoCoder.spacex.model.CrewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {
    @GET("crew")
    Call<List<CrewModel>> getCrew();
}
