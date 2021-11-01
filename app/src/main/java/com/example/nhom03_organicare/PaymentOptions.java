package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.ItemPayAndShipAdapter;
import com.example.model.ItemPaymentAndShipment;

import java.util.ArrayList;

public class PaymentOptions extends AppCompatActivity {

    ListView lvPaymentOptions;
    ArrayList<ItemPaymentAndShipment> payments;
    ItemPayAndShipAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
        linkViews();
        initData();
        loadData();
    }

    private void linkViews() {
        lvPaymentOptions = findViewById(R.id.lvPaymentOptions);
    }

    private void initData() {
        payments = new ArrayList<ItemPaymentAndShipment>();
        payments.add(new ItemPaymentAndShipment(R.drawable.zalopay,"Thanh toán bằng ZaloPay",0));
        payments.add(new ItemPaymentAndShipment(R.drawable.momo,"Thanh toán bằng MoMo",0));
        payments.add(new ItemPaymentAndShipment(R.drawable.airpay,"Thanh toán bằng Airpay",0));
    }

    private void loadData() {
        adapter = new ItemPayAndShipAdapter(this,R.layout.item_payment_delivery,payments);
        lvPaymentOptions.setAdapter(adapter);
    }
}