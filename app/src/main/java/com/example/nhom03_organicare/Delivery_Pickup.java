package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Delivery_Pickup extends AppCompatActivity {

    Button btnShipping, btnGetting, btnAccept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_pickup);

        linkViews();
        addEvents();
    }
    private void linkViews() {

        btnGetting = findViewById(R.id.btnGetting);
        btnShipping = findViewById(R.id.btnShipping);
        btnAccept = findViewById(R.id.btnAccept);
    }

    private void addEvents() {
        btnGetting.setOnClickListener(myClick);
        btnShipping.setOnClickListener(myClick);

    }
    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            Fragment fragment = null;
            if(view.getId() == R.id.btnShipping){
                fragment = new DeliveryFragment();
            }
            if(view.getId() == R.id.btnGetting){
                fragment = new PickupFragment();
            }
            transaction.replace(R.id.layoutContainer,fragment);
            transaction.commit();
        }
    };
}
