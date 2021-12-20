package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.example.adapter.DiscountAdapter;
import com.example.model.Discount;

import java.util.ArrayList;
import java.util.List;

public class DiscountActivity extends AppCompatActivity {

    private RecyclerView rcvDiscount;
    private DiscountAdapter discountAdapter;
    ImageButton imbBackDiscount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        rcvDiscount = findViewById(R.id.rcvDiscount);
        imbBackDiscount = findViewById(R.id.imbBackDiscount);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvDiscount.setLayoutManager(linearLayoutManager);

        discountAdapter = new DiscountAdapter(getListDiscounts());
        rcvDiscount.setAdapter(discountAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvDiscount.addItemDecoration(itemDecoration);

        imbBackDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DiscountActivity.this, Account2Fragment.class);
                startActivity(intent);
            }
        });
    }

    private List<Discount> getListDiscounts() {
        List<Discount> list = new ArrayList<>();
        list.add(new Discount(R.drawable.discount01, "[SALE01]", "Giảm 5% cho đơn hàng từ 200.000đ", "Hạn sử dụng: 30/12/2021"));
        list.add(new Discount(R.drawable.discount01, "[SALE02]", "Giảm 10% cho đơn hàng từ 500.000đ", "Hạn sử dụng: 11/12/2021"));
        list.add(new Discount(R.drawable.discount11, "[SALE03]", "Giảm 15% cho đơn hàng từ 2.000.000đ", "Hạn sử dụng: 12/12/2021"));
        list.add(new Discount(R.drawable.discount12, "[SALE04]", "Miễn phí vận chuyển địa bàn TP.HCM", "Hạn sử dụng: 15/12/2021"));
        list.add(new Discount(R.drawable.discount11, "[SALE05]", "Miễn phí vận chuyển cho đơn hàng từ 300.000đ", "Hạn sử dụng: 20/12/2021"));
        list.add(new Discount(R.drawable.discount12, "[SALE06]", "Giảm 15% cho đơn hàng từ 800.000đ", "Hạn sử dụng: 24/12/2021"));
        list.add(new Discount(R.drawable.discount01, "[SALE07]", "Giảm 10.000đ cho đơn hàng từ 200.000đ", "Hạn sử dụng: 25/12/2021"));
        list.add(new Discount(R.drawable.discount11, "[SALE08]", "Miễn phí vận chuyển cho đơn hàng từ 500.000đ", "Hạn sử dụng: 26/12/2021"));
        list.add(new Discount(R.drawable.discount12, "[SALE09]", "Giảm 20.000đ cho đơn hàng từ 500.000đ", "Hạn sử dụng: 30/12/2021"));

        return list;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_search_discount, menu);
//
//        return true;
//    }
}