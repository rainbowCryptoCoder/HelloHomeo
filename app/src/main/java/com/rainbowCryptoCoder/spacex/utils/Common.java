package com.rainbowCryptoCoder.spacex.utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.rainbowCryptoCoder.spacex.NoInternetActivity;

public final class Common {

    public static void  checkInternetAndHandelViewInternet(Context context) {
        if (Connectivity.isConnected(context )&&Connectivity.isConnectedWifi(context)){}
        else {
            context.startActivity(new Intent(context, NoInternetActivity.class));
            Toast.makeText(context, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }
}