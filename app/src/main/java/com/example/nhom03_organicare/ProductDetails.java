package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.example.adapter.ItemSimilarAdapter;
import com.example.adapter.ItemSuggestionAdapter;
import com.example.model.ItemSimilar;
import com.example.model.ItemSuggestion;

import java.util.ArrayList;

public class ProductDetails extends AppCompatActivity {

    RecyclerView rcvSimilar;
    ItemSimilarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        linkViews();
        configRecyclerView();
        initData();
    }

    private void linkViews() {
        rcvSimilar = findViewById(R.id.rcvSimilar);
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rcvSimilar.setLayoutManager(manager);
        rcvSimilar.setHasFixedSize(true);
        rcvSimilar.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        ArrayList<ItemSimilar> itemSimilars = new ArrayList<>();
        itemSimilars.add(new ItemSimilar(R.drawable.tomato,"Cà chua", 50000));
        itemSimilars.add(new ItemSimilar(R.drawable.red_cabbage, "Bắp cải tím", 50000));
        itemSimilars.add(new ItemSimilar(R.drawable.raspberry,"Raspberry", 120000));
        itemSimilars.add(new ItemSimilar(R.drawable.milk_barista,"Sữa Barista", 130000));
        itemSimilars.add(new ItemSimilar(R.drawable.kiwi,"Kiwi", 150000));
        itemSimilars.add(new ItemSimilar(R.drawable.potato,"Khoai tây", 75000));
        itemSimilars.add(new ItemSimilar(R.drawable.apple_rose,"Táo Dazzle", 150000));
        itemSimilars.add(new ItemSimilar(R.drawable.juice_apple,"Nước ép táo", 180000));

        adapter = new ItemSimilarAdapter(getApplicationContext(), itemSimilars);
        rcvSimilar.setAdapter(adapter);
    }
}