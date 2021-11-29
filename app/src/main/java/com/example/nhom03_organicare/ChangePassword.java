package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ChangePassword extends AppCompatActivity {
    ImageButton imbBackOTP;
    Button btnConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        imbBackOTP = findViewById(R.id.imbBackOTP);
        btnConfirmPass = findViewById(R.id.btnConfirmPass);
    }

    private void addEvents() {
        imbBackOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePassword.this, OTPActivity.class);
                startActivity(intent);
            }
        });
        btnConfirmPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePassword.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}