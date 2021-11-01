package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.adapter.ItemPayAndShipAdapter;
import com.example.model.ItemPaymentAndShipment;

import java.io.Serializable;
import java.util.ArrayList;

public class DeliveryActivity extends AppCompatActivity {

    ListView lvDelivery;
    ArrayList<ItemPaymentAndShipment> deliveries;
    ItemPayAndShipAdapter adapter;

    Button btnBack, btnXacNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        lvDelivery = findViewById(R.id.lvDelivery);
        btnBack =findViewById(R.id.btnBack);
        btnXacNhan = findViewById(R.id.btnXacNhan);
    }

    private void initData() {
        deliveries = new ArrayList<ItemPaymentAndShipment>();
        deliveries.add(new ItemPaymentAndShipment(R.drawable.tulay,"Tự lấy",0));
        deliveries.add(new ItemPaymentAndShipment(R.drawable.ghtk,"Giao Hàng Tiết Kiệm",23000));
        deliveries.add(new ItemPaymentAndShipment(R.drawable.giaohangnhanh,"Giao Hàng Nhanh",13000));
        deliveries.add(new ItemPaymentAndShipment(R.drawable.viettelpost,"ViettelPost",15000));
    }

    private void loadData() {
       adapter = new ItemPayAndShipAdapter(this,R.layout.item_payment_delivery,deliveries);
       lvDelivery.setAdapter(adapter);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveryActivity.this,OrderDetails.class);
                startActivity(intent);
            }
        });



            }



    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Delivery","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Delivery","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Delivery","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Delivery","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Delivery","onResume");
    }
}