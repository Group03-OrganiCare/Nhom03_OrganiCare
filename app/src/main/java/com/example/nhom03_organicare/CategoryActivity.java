package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.SaleAdapter;
import com.example.model.Category;
import com.example.model.Product;
import com.example.model.Sale_Item;

import java.util.ArrayList;
import java.util.Locale;

public class CategoryActivity extends AppCompatActivity {

    GridView gvCategoryProduct;
    ArrayList<Sale_Item> cat_items;
    SaleAdapter adapter;
    ImageView imvBackHome;
    TextView txtTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        linkViews();
        getData();
        loadData();
        initData();
        addEvents();
    }

    private void linkViews() {
        gvCategoryProduct = findViewById(R.id.gvCategoryProduct);
        imvBackHome = findViewById(R.id.imbBackHome);
        txtTitle = findViewById(R.id.txtTitle);
    }

    private void getData() {
        Intent intent = getIntent();
        if (intent != null){
            Category c = (Category) intent.getSerializableExtra("CatItem");
            if (c != null){
                txtTitle.setText("DANH MỤC " + c.getCategoryName().toUpperCase(Locale.ROOT));
            }
        }
    }

    private void loadData() {
        adapter = new SaleAdapter(CategoryActivity.this, R.layout.item_category, initData());
        gvCategoryProduct.setAdapter(adapter);
    }

    private ArrayList<Sale_Item> initData() {
        cat_items = new ArrayList<Sale_Item>();
        cat_items.add(new Sale_Item(115.000, R.drawable.potato,"Khoai tây hữu cơ"));
        cat_items.add(new Sale_Item(70.000, R.drawable.sweet_potato,"Khoai lang Nhật"));
        cat_items.add(new Sale_Item(105.000, R.drawable.tomato,"Cà chua hữu cơ"));
        cat_items.add(new Sale_Item(100.000, R.drawable.red_cabbage,"Bắp cải tím"));
        cat_items.add(new Sale_Item(95.000, R.drawable.corn,"Bắp ngọt"));
        cat_items.add(new Sale_Item(115.000, R.drawable.carrot,"Cà rốt hữu cơ"));
        cat_items.add(new Sale_Item(100.000, R.drawable.green_cabbage,"Bắp cải xanh"));
        cat_items.add(new Sale_Item(220.000, R.drawable.kiwi,"Kiwi Zespri vàng"));
        cat_items.add(new Sale_Item(120.000, R.drawable.apple_fuji,"Táo Fuji S100"));
        cat_items.add(new Sale_Item(120.000, R.drawable.raspberry,"Raspberry"));

        return cat_items;
    }

    private void addEvents() {
        imvBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        gvCategoryProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivity.this, ProductDetails.class);
                startActivity(intent);
            }
        });
    }
}