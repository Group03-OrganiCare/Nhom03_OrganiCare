package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.PaymentAdapter;
import com.example.model.Payment;

import java.util.ArrayList;

public class PaymentOptions extends AppCompatActivity {

    ListView lvPaymentOptions;
    ArrayList<Payment> payments;
    PaymentAdapter paymentAdapter;
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
        payments = new ArrayList<Payment>();
        payments.add(new Payment(R.drawable.zalopay,"Thanh toán bằng ZaloPay"));
        payments.add(new Payment(R.drawable.momo,"Thanh toán bằng MoMo"));
        payments.add(new Payment(R.drawable.airpay,"Thanh toán bằng Airpay"));
    }

    private void loadData() {
        paymentAdapter = new PaymentAdapter(this,R.layout.item_payment_delivery,payments);
        lvPaymentOptions.setAdapter(paymentAdapter);
    }
}