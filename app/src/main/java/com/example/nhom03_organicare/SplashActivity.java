package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.util.AppUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        loadData();
    }

    private void loadData() {
        if (AppUtil.isNetworkAvailable(this)) {
            //Network connected
            //Load data
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, OnboardingActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3000);
        }else{
            // Network disconnected
            Toast.makeText(this, "Network disconnected!", Toast.LENGTH_SHORT).show();
        }
    }
}