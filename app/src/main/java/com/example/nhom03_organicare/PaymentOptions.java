package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import com.example.adapter.PaymentAdapter;
import com.example.model.ItemPayment;
import java.util.ArrayList;
public class PaymentOptions extends AppCompatActivity {

    ListView lvPaymentOptions;
    ArrayList<ItemPayment> payments;
    PaymentAdapter adapter;
    Button btnBack;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_options);
        linkViews();
        initData();
        loadData();
        addEvents();
    }

    private void linkViews() {
        lvPaymentOptions = findViewById(R.id.lvPaymentOptions);
        btnBack=findViewById(R.id.btnBack);
    }

    private void initData() {
        payments = new ArrayList<ItemPayment>();
        payments.add(new ItemPayment(R.drawable.cash,"COD (Mặc định)"));
        payments.add(new ItemPayment(R.drawable.visa,"Thẻ ATM/Visa/Mastercard"));
        payments.add(new ItemPayment(R.drawable.ewallet,"Ví điện tử"));
    }

    private void loadData() {
        adapter = new PaymentAdapter(this,R.layout.item_payment,payments);
        lvPaymentOptions.setAdapter(adapter);
    }

    private void addEvents() {
        lvPaymentOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                switch (i){
                    case 0:
                        intent =new Intent(PaymentOptions.this,OrderDetails.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent =new Intent(PaymentOptions.this,PaymentCard.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent =new Intent(PaymentOptions.this,PaymentWallet.class);
                        startActivity(intent);
                        break;

                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent =new Intent(PaymentOptions.this,OrderDetails.class);
                startActivity(intent);
            }
        });
    }
}