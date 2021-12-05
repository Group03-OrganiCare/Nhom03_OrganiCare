package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Account2 extends AppCompatActivity {
    Button btnPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account2);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnPoint = findViewById(R.id.btnPoint);
    }

    private void addEvents() {
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account2.this, Point.class);
                startActivity(intent);
            }
        });
    }
}