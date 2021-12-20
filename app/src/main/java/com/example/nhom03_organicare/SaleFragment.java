package com.example.nhom03_organicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.adapter.SaleAdapter;
import com.example.model.Sale_Item;

import java.util.ArrayList;

public class SaleFragment extends Fragment {

    GridView gvSaleProduct;
    ArrayList<Sale_Item> sale_items;
    SaleAdapter adapter;
    ImageButton imbBackSale;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sale, container, false);
        //linkViews
        gvSaleProduct = view.findViewById(R.id.gvSaleProduct);
        imbBackSale = view.findViewById(R.id.imbBackSale);

        imbBackSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HomeFragment.class);
                startActivity(intent);
            }
        });

        //load Data
        adapter = new SaleAdapter(getContext(), R.layout.item_layout, initData());
        gvSaleProduct.setAdapter(adapter);
        return view;

    }

    private ArrayList<Sale_Item> initData() {
        sale_items = new ArrayList<Sale_Item>();
        sale_items.add(new Sale_Item(100.000, R.drawable.red_cabbage,"Bắp cải tím"));
        sale_items.add(new Sale_Item(100.000, R.drawable.green_cabbage,"Bắp cải xanh hữu cơ"));
        sale_items.add(new Sale_Item(220.000, R.drawable.kiwi,"Kiwi Zespri vàng"));
        sale_items.add(new Sale_Item(95.000, R.drawable.corn,"Bắp ngọt"));
        sale_items.add(new Sale_Item(115.000, R.drawable.carrot,"Cà rốt tím hữu cơ"));
        sale_items.add(new Sale_Item(120.000, R.drawable.apple_fuji,"Táo Fuji S100"));
        sale_items.add(new Sale_Item(120.000, R.drawable.apple_dazzle,"Bắp cải tím hữu cơ"));
        sale_items.add(new Sale_Item(115.000, R.drawable.potato,"Khoai tây hữu cơ"));
        sale_items.add(new Sale_Item(70.000, R.drawable.sweet_potato,"Khoai lang Nhật"));
        sale_items.add(new Sale_Item(105.000, R.drawable.tomato,"Cà chua hữu cơ"));

        return sale_items;
    }

}