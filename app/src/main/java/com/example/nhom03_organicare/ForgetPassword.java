package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ForgetPassword extends AppCompatActivity {
    ImageButton imbBackLoginPass;
    Button btnSendOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        imbBackLoginPass = findViewById(R.id.imbBackLoginPass);
        btnSendOTP = findViewById(R.id.btnSendOTP);
    }

    private void addEvents() {
        imbBackLoginPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPassword.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPassword.this, OTPActivity.class);
                startActivity(intent);
            }
        });
    }
}