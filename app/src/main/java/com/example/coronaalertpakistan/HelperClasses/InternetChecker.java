package com.example.coronaalertpakistan.HelperClasses;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

public class InternetChecker {
    public static boolean isInternetEnabled(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo!=null && networkInfo.isConnected());

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
