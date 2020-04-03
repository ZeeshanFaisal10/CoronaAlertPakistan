package com.example.coronaalertpakistan.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.coronaalertpakistan.HelperClasses.InternetChecker;
import com.example.coronaalertpakistan.fragments.DashBoardFragment;
import com.example.coronaalertpakistan.fragments.NewsFeedFragment;
import com.example.coronaalertpakistan.R;
import com.example.coronaalertpakistan.fragments.ResearchFragment;
import com.example.coronaalertpakistan.fragments.SafetyPrecautionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainPage extends AppCompatActivity {

    BottomNavigationView navigationView;
    ProgressBar progressBar;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment showFragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        getSupportActionBar().setTitle("Dashboard");
        fragmentManager = getSupportFragmentManager();
        progressBar = findViewById(R.id.my_progressbar);
        fragmentTransaction = fragmentManager.beginTransaction();
        navigationView = findViewById(R.id.myBottView);
        navigationView.setOnNavigationItemSelectedListener(bottomNavListener);

        initializeUI();
    }

    private void initializeUI() {

        if (showFragment == null){
            showFragment = new DashBoardFragment();
            fragmentTransaction.replace(R.id.fragment_container,showFragment).commit();
        }
    }


    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()){
                case R.id.mydashboard:
                    getSupportActionBar().setTitle("Dashboard");
                    showFragment  = new DashBoardFragment();
                   break;

                case R.id.myresearch:
                    getSupportActionBar().setTitle("News Feed");
                    showFragment = new NewsFeedFragment();
                    break;
                case R.id.mynews:
                    getSupportActionBar().setTitle("Research");
                    showFragment = new ResearchFragment();
                    break;
                case R.id.mysafetymeasures:
                    getSupportActionBar().setTitle("Safety Measures");
                    showFragment = new SafetyPrecautionFragment();
                    progressBar.setVisibility(View.INVISIBLE);
                    break;
            }
            getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container,showFragment).commit();
            return true;
        }
    };


    @Override
    protected void onStart() {
        super.onStart();

        if (!InternetChecker.isInternetEnabled(getApplicationContext())){
            startActivity(new Intent(MainPage.this, NoInternetActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure You wanted to exit?");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                           finish();
                            }
                        });

        alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             dialog.dismiss();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
