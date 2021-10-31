package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.DeliveryAdapter;
import com.example.model.Delivery;

import java.util.ArrayList;

public class DeliveryActivity extends AppCompatActivity {

    ListView lvDelivery;
    ArrayList<Delivery> deliveries;
    DeliveryAdapter deliveryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        linkViews();
        initData();
        loadData();
    }

    private void linkViews() {
        lvDelivery = findViewById(R.id.lvDelivery);
    }

    private void initData() {
        deliveries = new ArrayList<Delivery>();
        deliveries.add(new Delivery(R.drawable.tulay,0));
        deliveries.add(new Delivery(R.drawable.ghtk,23000));
        deliveries.add(new Delivery(R.drawable.giaohangnhanh,13000));
        deliveries.add(new Delivery(R.drawable.viettelpost,15000));
    }

    private void loadData() {
       deliveryAdapter = new DeliveryAdapter(this,R.layout.item_payment_delivery,deliveries);
       lvDelivery.setAdapter(deliveryAdapter);
    }
}