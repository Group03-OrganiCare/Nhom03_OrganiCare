package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    Button btnRegister2;
    ImageButton imbBackLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeraccount);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnRegister2 = findViewById(R.id.btnRegister2);
        imbBackLogin = findViewById(R.id.imbBackLogin);
    }

    private void addEvents() {
        imbBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btnRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText(RegisterActivity.this, "Bạn đã đăng ký thành công", Toast.LENGTH_SHORT);
                t.show();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}