package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.adapter.ItemOrderAdapter;
import com.example.model.ItemOrder;
import com.example.model.UserInfo;

import java.util.ArrayList;

public class OrderDetails extends AppCompatActivity {

    RecyclerView rcvOrderItem;
    TextView txtNewAddress, txtChoosePayment, txtChooseShipment, txtAddress, txtName, txtPhone;
    Button btnConfirm, btnClose;
    ImageButton imbBackCart;
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
        imbBackCart = findViewById(R.id.imbBackCart);
        rcvOrderItem = findViewById(R.id.rcvOrderItem);
        txtNewAddress = findViewById(R.id.txtNewAddress);
        txtChoosePayment = findViewById(R.id.txtChoosePayment);
        txtChooseShipment = findViewById(R.id.txtChooseShipment);
        txtAddress = findViewById(R.id.txtAddress);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnClose = findViewById(R.id.btnClose);
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
        imbBackCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txtNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(OrderDetails.this, EditInfo.class);
                startActivity(intent);
            }
        });

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

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(OrderDetails.this, MainActivity2.class);
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
        if (getIntent().getExtras() != null){
            UserInfo userInfo = (UserInfo) getIntent().getExtras().get("info");
            txtName.setText(userInfo.getName());
            txtAddress.setText(userInfo.getAddress() + ", " + userInfo.getWard() + ", " + userInfo.getDistrict());
            txtPhone.setText(userInfo.getPhone());
        }
    }
}