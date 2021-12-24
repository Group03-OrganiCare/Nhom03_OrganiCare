package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.adapter.SaleAdapter;
import com.example.model.Sale_Item;

import java.util.ArrayList;

public class FavoriteProducts extends AppCompatActivity {

    GridView gvFavoriteProduct;
    ArrayList<Sale_Item> fav_items;
    SaleAdapter adapter;
    ImageView imvBackAcc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_products);

        linkViews();
        loadData();
        initData();
        addEvents();
    }

    private void linkViews() {
        gvFavoriteProduct = findViewById(R.id.gvFavoriteProduct);
        imvBackAcc2 = findViewById(R.id.imvBackAcc2);
    }

    private void loadData() {
        adapter = new SaleAdapter(FavoriteProducts.this, R.layout.sale_item, initData());
        gvFavoriteProduct.setAdapter(adapter);
    }

    private ArrayList<Sale_Item> initData() {
        fav_items = new ArrayList<Sale_Item>();
        fav_items.add(new Sale_Item(100.000, R.drawable.red_cabbage,"Bắp cải tím"));
        fav_items.add(new Sale_Item(100.000, R.drawable.green_cabbage,"Bắp cải xanh"));
        fav_items.add(new Sale_Item(220.000, R.drawable.kiwi,"Kiwi Zespri vàng"));
        fav_items.add(new Sale_Item(95.000, R.drawable.corn,"Bắp ngọt"));
        fav_items.add(new Sale_Item(115.000, R.drawable.carrot,"Cà rốt hữu cơ"));
        fav_items.add(new Sale_Item(120.000, R.drawable.apple_fuji,"Táo Fuji S100"));
        fav_items.add(new Sale_Item(120.000, R.drawable.raspberry,"Raspberry"));
        fav_items.add(new Sale_Item(115.000, R.drawable.potato,"Khoai tây hữu cơ"));
        fav_items.add(new Sale_Item(70.000, R.drawable.sweet_potato,"Khoai lang Nhật"));
        fav_items.add(new Sale_Item(105.000, R.drawable.tomato,"Cà chua hữu cơ"));

        return fav_items;
    }

    private void addEvents() {
        imvBackAcc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        gvFavoriteProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FavoriteProducts.this, ProductDetails.class);
                startActivity(intent);
            }
        });
    }
}