package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ForgetPassword extends AppCompatActivity {
    ImageButton imbBackLoginPass;
    EditText edtEmail_Phone;
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
        edtEmail_Phone = findViewById(R.id.edtEmail_Phone);
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
                if(edtEmail_Phone.getText().length() == 0){
                    Toast.makeText(ForgetPassword.this, "Bạn phải nhập email hoặc số điện thoại", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(ForgetPassword.this, OTPActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}