package com.example.nhom03_organicare;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.SaleAdapter;
import com.example.model.MyItemClick;
import com.example.model.Sale_Item;

import java.util.ArrayList;

public class SaleFragment extends Fragment {

    GridView gvSaleProduct;
    TextView txtProductNameDetail, txtProductPriceDetail;
    ImageView imvProductImage;
    ArrayList<Sale_Item> sale_items;
    SaleAdapter adapter;
    ImageButton imbBackSale;
    MyItemClick itemClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sale, container, false);
        //linkViews
        gvSaleProduct = view.findViewById(R.id.gvSaleProduct);
        imbBackSale = view.findViewById(R.id.imbBackSale);
        imvProductImage = view.findViewById(R.id.imvProductImage);
        txtProductNameDetail = view.findViewById(R.id.txtProductNameDetail);
        txtProductPriceDetail = view.findViewById(R.id.txtProductPriceDetail);

        imbBackSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HomeFragment.class);
                startActivity(intent);
            }
        });

        //load Data
        adapter = new SaleAdapter(getContext(), R.layout.item_sale, initData());
        gvSaleProduct.setAdapter(adapter);

        gvSaleProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    itemClick = (MyItemClick) getActivity();
                    if (itemClick != null) {
                        itemClick.clickItem(sale_items.get(position));
                    }
                } else {
                    imvProductImage.setImageResource(sale_items.get(position).getProductThumb());
                    txtProductNameDetail.setText(sale_items.get(position).getProductName());
                    txtProductPriceDetail.setText(String.format("%.0f", sale_items.get(position).getProductPrice()) + "VND");
                }
            }
        });

        return view;

    }

    private ArrayList<Sale_Item> initData() {
        sale_items = new ArrayList<Sale_Item>();
        sale_items.add(new Sale_Item(100000, R.drawable.red_cabbage,"Bắp cải tím"));
        sale_items.add(new Sale_Item(100000, R.drawable.green_cabbage,"Bắp cải xanh"));
        sale_items.add(new Sale_Item(220000, R.drawable.kiwi,"Kiwi Zespri vàng"));
        sale_items.add(new Sale_Item(95000, R.drawable.corn,"Bắp ngọt"));
        sale_items.add(new Sale_Item(115000, R.drawable.carrot,"Cà rốt hữu cơ"));
        sale_items.add(new Sale_Item(120000, R.drawable.apple_fuji,"Táo Fuji S100"));
        sale_items.add(new Sale_Item(120000, R.drawable.raspberry,"Raspberry"));
        sale_items.add(new Sale_Item(115000, R.drawable.potato,"Khoai tây hữu cơ"));
        sale_items.add(new Sale_Item(70000, R.drawable.sweet_potato,"Khoai lang Nhật"));
        sale_items.add(new Sale_Item(105000, R.drawable.tomato,"Cà chua hữu cơ"));

        return sale_items;
    }

}