package com.example.nhom03_organicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.CartAdapter;
import com.example.model.Cart_Item;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;


public class CartFragment extends Fragment {

    RecyclerView rcvCart;
    ArrayList<Cart_Item> products;
    Button btnOrder;
    ImageButton imbBackHome;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cart, container, false);
        //linkViews
        rcvCart = view.findViewById(R.id.rcvCart);
        btnOrder = view.findViewById(R.id.btnOrder);
        imbBackHome = view.findViewById(R.id.imbBackHome);

        //loadData
        CartAdapter adapter = new CartAdapter(getContext(), R.layout.cart_item, initData());
        rcvCart.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rcvCart.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        rcvCart.addItemDecoration(itemDecoration);

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
        products = new ArrayList<Cart_Item>();
        products.add(new Cart_Item( R.drawable.corn, "Bắp ngọt hữu cơ", "100.000/kg","Trọng lượng: 1kg"));
        products.add(new Cart_Item(R.drawable.carrot, "Cà rốt hữu cơ", "80.000/kg", "Trọng lượng: 1kg"));
        products.add(new Cart_Item(R.drawable.potato, "Khoai tây hữu cơ", "120.000/kg", "Trọng lượng: 1kg"));

        return products;
    }

}