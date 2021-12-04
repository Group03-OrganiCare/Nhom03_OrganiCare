package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.adapter.PaymentAdapter;
import com.example.model.ItemPayment;
import java.util.ArrayList;
public class PaymentWallet extends AppCompatActivity {

    ListView lvPaymentOptions;
    ArrayList<ItemPayment> payments;
    PaymentAdapter adapter;
    Button btnBack;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_wallet);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        lvPaymentOptions = findViewById(R.id.lvPaymentOptions);
        btnBack =findViewById(R.id.btnBack);
    }

    private void initData() {
        payments = new ArrayList<ItemPayment>();
        payments.add(new ItemPayment(R.drawable.zalopay,"Thanh toán bằng ZaloPay"));
        payments.add(new ItemPayment(R.drawable.momo,"Thanh toán bằng MoMo"));
        payments.add(new ItemPayment(R.drawable.airpay,"Thanh toán bằng Airpay"));
    }

    private void loadData() {
        adapter = new PaymentAdapter(this,R.layout.item_payment,payments);
        lvPaymentOptions.setAdapter(adapter);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(PaymentWallet.this,PaymentOptions.class);
                startActivity(intent);
            }
        });
    }
}