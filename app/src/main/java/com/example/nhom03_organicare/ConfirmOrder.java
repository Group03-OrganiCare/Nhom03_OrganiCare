package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adapter.ItemOrderAdapter;
import com.example.model.ItemOrder;

import java.util.ArrayList;

public class ConfirmOrder extends AppCompatActivity {
    RecyclerView rcvOrderItem1;
    ItemOrderAdapter adapter1;
    Button btnBackHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        linkViews();
        configRecyclerView();
        initData();
        addEvents();
    }

    private void linkViews() { rcvOrderItem1 = findViewById(R.id.rcvOrderItem1);
    btnBackHome = findViewById(R.id.btnBackHome);
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
        itemOrders.add(new ItemOrder(R.drawable.apple_rose,"Táo Rose Dazzle", 120000,5,600000));

        adapter1 = new ItemOrderAdapter(getApplicationContext(), itemOrders);
        rcvOrderItem1.setAdapter(adapter1);
    }

    private void addEvents() {
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmOrder.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}