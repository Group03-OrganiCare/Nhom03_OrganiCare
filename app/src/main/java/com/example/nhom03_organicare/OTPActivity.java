package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OTPActivity extends AppCompatActivity {
    ImageButton imbBack;
    Button btnconfirmOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        imbBack = findViewById(R.id.imbBackForgetPass);
        btnconfirmOTP = findViewById(R.id.btnConfirmOTP);

    }

    private void addEvents() {

        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OTPActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        btnconfirmOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OTPActivity.this, ChangePassword.class);
                startActivity(intent);
            }
        });
    }
}