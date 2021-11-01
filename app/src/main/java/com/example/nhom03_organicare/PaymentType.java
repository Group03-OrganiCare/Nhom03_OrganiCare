package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;

import com.example.adapter.ItemPayAndShipAdapter;
import com.example.adapter.PaymentAdapter;
import com.example.model.ItemPaymentAndShipment;
import com.example.model.Payment;

import java.util.ArrayList;

public class PaymentType extends AppCompatActivity {

    ListView lvPaymentOptions;
    ArrayList<ItemPaymentAndShipment> payments;
    ItemPayAndShipAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_type);
        linkViews();
        initData();
        loadData();
        addEvents();

    }


    private void linkViews() {
        lvPaymentOptions = findViewById(R.id.lvPaymentOptions);
    }

    private void initData() {
        payments = new ArrayList<ItemPaymentAndShipment>();
        payments.add(new ItemPaymentAndShipment(R.drawable.cash,"Thanh toán bằng tiền mặt",0));
        payments.add(new ItemPaymentAndShipment(R.drawable.card,"Thanh toán bằng thẻ VISA/Card",0));
        payments.add(new ItemPaymentAndShipment(R.drawable.ewallet,"Thanh toán bằng MoMo/ZaloPay",0));
    }

    private void loadData() {
        adapter = new ItemPayAndShipAdapter(this,R.layout.item_payment_delivery,payments);
        lvPaymentOptions.setAdapter(adapter);
    }

    private void addEvents() {
        lvPaymentOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        Intent intent =new Intent(PaymentType.this,PaymentOptions.class);
                        startActivity(intent);
                        break;

                }
            }
        });
    }
}