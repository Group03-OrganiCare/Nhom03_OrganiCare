package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adapter.ItemOrderAdapter;
import com.example.adapter.ItemSuggestionAdapter;
import com.example.model.ItemOrder;
import com.example.model.ItemSuggestion;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ImageView imvFilter;
    RecyclerView rcvSuggestion;
    ItemSuggestionAdapter adapter;

    DrawerLayout drawerFilter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        linkViews();
        configRecyclerView();
        initData();
        addEvents();
    }

    private void linkViews() {
        rcvSuggestion = findViewById(R.id.rcvSuggestion);
        imvFilter = findViewById(R.id.imvFilter);
        drawerFilter = findViewById(R.id.drawerFilter);
    }

    private void configRecyclerView() {
        GridLayoutManager manager = new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false);
        rcvSuggestion.setLayoutManager(manager);
        rcvSuggestion.setHasFixedSize(true);
        rcvSuggestion.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        ArrayList<ItemSuggestion> itemSuggestions = new ArrayList<>();
        itemSuggestions.add(new ItemSuggestion(R.drawable.red_cabbage, "Bắp cải tím"));
        itemSuggestions.add(new ItemSuggestion(R.drawable.apple_rose,"Táo Rose Dazzle"));
        itemSuggestions.add(new ItemSuggestion(R.drawable.raspberry,"Raspberry"));
        itemSuggestions.add(new ItemSuggestion(R.drawable.milk_barista,"Sữa Barista"));
        itemSuggestions.add(new ItemSuggestion(R.drawable.kiwi,"Kiwi"));
        itemSuggestions.add(new ItemSuggestion(R.drawable.tomato,"Cà chua"));
        itemSuggestions.add(new ItemSuggestion(R.drawable.potato,"Khoai tây"));
        itemSuggestions.add(new ItemSuggestion(R.drawable.juice_apple,"Nước ép táo"));

        adapter = new ItemSuggestionAdapter(getApplicationContext(), itemSuggestions);
        rcvSuggestion.setAdapter(adapter);
    }

    private void addEvents() {
        imvFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerFilter.openDrawer(GravityCompat.END);
                Toast.makeText(SearchActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}