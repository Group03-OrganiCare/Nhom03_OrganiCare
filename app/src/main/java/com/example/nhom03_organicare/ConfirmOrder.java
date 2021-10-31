package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.ItemOrderAdapter;
import com.example.model.ItemOrder;

import java.util.ArrayList;

public class ConfirmOrder extends AppCompatActivity {
    RecyclerView rcvOrderItem1;
    ItemOrderAdapter adapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        linkViews();
        configRecyclerView();
        initData();
    }

    private void linkViews() { rcvOrderItem1 = findViewById(R.id.rcvOrderItem1);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvOrderItem1.setLayoutManager(manager);

        rcvOrderItem1.setHasFixedSize(true);
        rcvOrderItem1.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        ArrayList<ItemOrder> itemOrders = new ArrayList<>();
        itemOrders.add(new ItemOrder(R.drawable.red_cabbage, "Bắp cải tím",45000,5,225000));
        itemOrders.add(new ItemOrder(R.drawable.apple_rose,"Táo Rose Dazzle", 120000,5,750000));

        adapter1 = new ItemOrderAdapter(getApplicationContext(), itemOrders);
        rcvOrderItem1.setAdapter(adapter1);
    }
}