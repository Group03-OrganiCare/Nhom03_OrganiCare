package com.example.nhom03_organicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.adapter.CartAdapter;
import com.example.model.Cart_Item;
import com.example.model.Sale_Item;

import java.util.ArrayList;


public class CartFragment extends Fragment {

    ListView lvPickedProduct;
    ArrayList<Cart_Item> cart_items;
    CartAdapter adapter;
    Button btnOrder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);
        //linkViews
        lvPickedProduct = view.findViewById(R.id.lvPickedProduct);
        btnOrder = view.findViewById(R.id.btnOrder);

        //loadData
        adapter = new CartAdapter(getContext(), R.layout.cart_item, initData());
        lvPickedProduct.setAdapter(adapter);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OrderDetails.class);
                startActivity(intent);
            }
        });

        return view;

    }

    private ArrayList<Cart_Item> initData() {
        cart_items = new ArrayList<Cart_Item>();
        cart_items.add(new Cart_Item(R.drawable.corn, "Bắp ngọt hữu cơ", "100.000/kg", "1kg"));
        cart_items.add(new Cart_Item(R.drawable.red_cabbage, "Bắp cải tím hữu cơ", "119.000/kg", "1kg"));
        cart_items.add(new Cart_Item(R.drawable.green_cabbage, "Bắp cải xanh hữu cơ", "190.000/kg", "1kg"));
        cart_items.add(new Cart_Item(R.drawable.potato, "Khoai tây hữu cơ", "100.000/kg", "1kg"));

        return cart_items;
    }
}