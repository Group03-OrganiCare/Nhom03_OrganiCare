package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.adapter.ItemOrderAdapter;
import com.example.model.ItemOrder;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {

    RecyclerView rcvOrderItem;
    TextView txtChoosePayment, txtChooseShipment;
    Button btnConfirm;
    ItemOrderAdapter adapter;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        linkViews();
        configRecyclerView();
        initData();
        addEvents();
        getData();
    }

    private void linkViews() {

        rcvOrderItem = findViewById(R.id.rcvOrderItem);
        txtChoosePayment =findViewById(R.id.txtChoosePayment);
        txtChooseShipment = findViewById(R.id.txtChooseShipment);
        btnConfirm = findViewById(R.id.btnConfirm);

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
        itemOrders.add(new ItemOrder(R.drawable.apple_rose,"Táo Rose Dazzle", 120000,5,600000));

        adapter = new ItemOrderAdapter(getApplicationContext(), itemOrders);
        rcvOrderItem.setAdapter(adapter);
    }

    private void addEvents() {
        txtChoosePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(OrderDetails.this, PaymentOptions.class);
                startActivity(intent);

            }
        });
        txtChooseShipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(OrderDetails.this, TabHostDelivery.class);
                startActivity(intent);
            }
        });
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(OrderDetails.this, ConfirmOrder.class);
                startActivity(intent);
            }
        });
    }

    private void getData() {


    }

}