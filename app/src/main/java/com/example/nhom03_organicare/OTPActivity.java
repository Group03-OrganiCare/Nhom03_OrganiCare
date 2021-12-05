package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class OTPActivity extends AppCompatActivity {
    ImageButton imbBack;
    EditText edtOTP;
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
        edtOTP = findViewById(R.id.edtOTP);
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
                if (edtOTP.getText().length() == 0) {
                    Toast.makeText(OTPActivity.this, "Bạn phải nhập mã OTP", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(OTPActivity.this, ChangePassword.class);
                    startActivity(intent);
                }
            }
        });
    }
}