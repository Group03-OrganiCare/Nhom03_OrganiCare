package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.ItemOrderAdapter;
import com.example.adapter.ItemOrderTrackingAdapter;
import com.example.model.ItemOrderTracking;

import java.util.ArrayList;

public class TrackingOrder extends AppCompatActivity {

    RecyclerView rcvOrderTracking;
    ItemOrderTrackingAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_order);
        linkViews();
        configRecyclerView();
        initData();
    }

    private void linkViews()
    {
        rcvOrderTracking = findViewById(R.id.rcvOrderTracking);
    }

    private void configRecyclerView()
    {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcvOrderTracking.setLayoutManager(manager);

        rcvOrderTracking.setHasFixedSize(true);
        rcvOrderTracking.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData()
    {
        ArrayList<ItemOrderTracking> trackingOrders = new ArrayList<>();
        trackingOrders.add(new ItemOrderTracking(R.drawable.apple_rose, "Táo Rose", 150000, "x5", "Đang giao" ));
        trackingOrders.add(new ItemOrderTracking(R.drawable.carrot , "Cà rốt hữu cơ", 50000, "x3", "Đang giao" ));


        adapter = new ItemOrderTrackingAdapter(getApplicationContext(), trackingOrders);
        rcvOrderTracking.setAdapter(adapter);

    }


}

