package com.example.coronaalertpakistan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.coronaalertpakistan.HelperClasses.InternetChecker;
import com.example.coronaalertpakistan.R;

public class NoInternetActivity extends AppCompatActivity {

    TextView tryagain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_internet);


        tryagain = findViewById(R.id.tryagain);
        tryagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (InternetChecker.isInternetEnabled(getApplicationContext())){
               startActivity(new Intent(NoInternetActivity.this,MainPage.class));
               finish();
             }
            }
        });
    }
}
