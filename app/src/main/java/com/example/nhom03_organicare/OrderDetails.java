package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.ItemOrderAdapter;
import com.example.model.ItemOrder;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {

    RecyclerView rcvOrderItem;
    ItemOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        linkViews();
        configRecyclerView();
        initData();
    }

    private void linkViews() {
        rcvOrderItem = findViewById(R.id.rcvOrderItem);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvOrderItem.setLayoutManager(manager);

        rcvOrderItem.setHasFixedSize(true);
        rcvOrderItem.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        ArrayList<ItemOrder> itemOrders = new ArrayList<>();
        itemOrders.add(new ItemOrder(R.drawable.red_cabbage, "Bắp cải tím",45000,5,225000));
        itemOrders.add(new ItemOrder(R.drawable.apple_rose,"Táo Rose Dazzle", 120000,5,750000));

        adapter = new ItemOrderAdapter(getApplicationContext(), itemOrders);
        rcvOrderItem.setAdapter(adapter);
    }
}