package com.example.coronaalertpakistan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.coronaalertpakistan.R;

public class MainActivity extends AppCompatActivity {

    private static int SplashTimeOut = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            startActivity(new Intent(MainActivity.this,MainPage.class));
            finish();
            }
        },SplashTimeOut);
    }
}
