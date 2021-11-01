package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.adapter.SaleAdapter;
import com.example.model.Sale_Item;

import java.util.ArrayList;

public class Sale extends AppCompatActivity {
    GridView gvSaleProduct;
    ArrayList<Sale_Item> sale_items;
    SaleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale);
        linkViews();
        initData();
        loadData();
    }
    private void linkViews() {
        gvSaleProduct = findViewById(R.id.gvSaleProduct);
    }
    private void initData() {
        sale_items = new ArrayList<Sale_Item>();
        sale_items.add(new Sale_Item("100.000đ/kg", R.drawable.red_cabbage,"Bắp cải tím hữu cơ"));
        sale_items.add(new Sale_Item("100.000đ/kg", R.drawable.green_cabbage,"Bắp cải xanh hữu cơ"));
        sale_items.add(new Sale_Item("220.000đ/kg", R.drawable.kiwi,"Kiwi Zespri vàng"));
        sale_items.add(new Sale_Item("95.000đ/kg", R.drawable.corn,"Bắp ngọt tím hữu cơ"));
        sale_items.add(new Sale_Item("115.000đ/kg", R.drawable.carrot,"Cà rốt tím hữu cơ"));
        sale_items.add(new Sale_Item("120.000đ/kg", R.drawable.apple_fuji,"Táo Fuji S100"));
        sale_items.add(new Sale_Item("120.000đ/kg", R.drawable.apple_dazzle,"Bắp cải tím hữu cơ"));
        sale_items.add(new Sale_Item("115.000đ/kg", R.drawable.potato,"Khoai tây hữu cơ"));
        sale_items.add(new Sale_Item("70.000đ/kg", R.drawable.sweet_potato,"Khoai lang Nhật hữu cơ"));
        sale_items.add(new Sale_Item("105.000đ/kg", R.drawable.tomato,"Cà chua hữu cơ"));

    }
    private void loadData() {
        adapter = new SaleAdapter(Sale.this, R.layout.item_layout, sale_items);
        gvSaleProduct.setAdapter(adapter);

    }
}