package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Account2 extends AppCompatActivity {
    Button btnPoint, btnHistory, btnDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account2);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnPoint = findViewById(R.id.btnPoint);
        btnHistory = findViewById(R.id.btnHistory);
        btnDiscount = findViewById(R.id.btnDiscount);
    }

    private void addEvents() {
        btnDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account2.this, DiscountActivity.class);
                startActivity(intent);
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account2.this, Point.class);
                startActivity(intent);
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Account2.this, TabHostDelivery.class);
                startActivity(intent);
            }
        });
    }
}