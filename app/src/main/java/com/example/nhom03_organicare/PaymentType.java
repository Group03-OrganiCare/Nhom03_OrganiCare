package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.PaymentAdapter;
import com.example.model.Payment;

import java.util.ArrayList;

public class PaymentType extends AppCompatActivity {

    ListView lvPaymentOptions;
    ArrayList<Payment> payments;
    PaymentAdapter paymentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_type);
        linkViews();
        initData();
        loadData();

    }




    private void linkViews() {
        lvPaymentOptions = findViewById(R.id.lvPaymentOptions);
    }

    private void initData() {
        payments = new ArrayList<Payment>();
        payments.add(new Payment(R.drawable.cash,"Thanh toán bằng tiền mặt"));
        payments.add(new Payment(R.drawable.card,"Thanh toán bằng thẻ VISA/Card"));
        payments.add(new Payment(R.drawable.ewallet,"Thanh toán bằng MoMo/ZaloPay"));
    }

    private void loadData() {
        paymentAdapter = new PaymentAdapter(this,R.layout.item_payment,payments);
        lvPaymentOptions.setAdapter(paymentAdapter);
    }
}