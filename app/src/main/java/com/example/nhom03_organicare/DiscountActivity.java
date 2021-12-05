package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.DiscountAdapter;
import com.example.model.Discount;

import java.util.ArrayList;
import java.util.List;

public class DiscountActivity extends AppCompatActivity {

    private RecyclerView rcvDiscount;
    private DiscountAdapter discountAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        rcvDiscount = findViewById(R.id.rcvDiscount);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvDiscount.setLayoutManager(linearLayoutManager);
    }

    private void addEvents() {
        discountAdapter = new DiscountAdapter(getListDiscount());
        rcvDiscount.setAdapter(discountAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvDiscount.addItemDecoration(itemDecoration);
    }

    private List<Discount> getListDiscount() {
        List<Discount> list = new ArrayList<>();
        list.add(new Discount(R.drawable.discount01, "[HNGG01]", "Giảm 5% cho đơn hàng từ 200.000đ", "Hạn sử dụng: 30/12/2021"));
        list.add(new Discount(R.drawable.discount01, "[HNGG02]", "Giảm 5% cho đơn hàng từ 300.000đ", "Hạn sử dụng: 20/12/2021"));
        list.add(new Discount(R.drawable.discount02, "[HNGG03]", "Giảm 10% cho đơn hàng từ 500.000đ", "Hạn sử dụng: 12/12/2021"));
        list.add(new Discount(R.drawable.discount02, "[HNGG04]", "Giảm 10% cho đơn hàng từ 1.000.000đ", "Hạn sử dụng: 12/12/2021"));
        list.add(new Discount(R.drawable.discount03, "[HNGG05]", "Miễn phí vận chuyển địa bàn TP. Hồ Chí Minh", "Hạn sử dụng: 12/12/2021"));
        list.add(new Discount(R.drawable.discount03, "[HNGG06]", "Miễn phí vận chuyển cho đơn hàng từ 500.000đ", "Hạn sử dụng: 12/12/2021"));
        list.add(new Discount(R.drawable.discount03, "[HNGG07]", "Giảm 20.000đ cho đơn hàng từ 500.000đ", "Hạn sử dụng: 20/12/2021"));

        return  list;
    }
}