package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Setting extends AppCompatActivity {
    LinearLayout ChangePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        ChangePassword = findViewById(R.id.ChangePassword);
    }

    private void addEvents() {
        ChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this,ForgetPassword.class);
                startActivity(intent);
            }
        });
    }
}