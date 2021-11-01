package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.CartAdapter;
import com.example.model.Cart_Item;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    ListView lvPickedProduct;
    ArrayList<Cart_Item> cart_items;
    CartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        linkViews();
        initData();
        loadData();
    }
    private void linkViews() {
        lvPickedProduct = findViewById(R.id.lvPickedProduct);
    }
    private void initData() {
        cart_items = new ArrayList<Cart_Item>();
        cart_items.add(new Cart_Item(R.drawable.corn, "Bắp ngọt hữu cơ", "100.000/kg", "1kg"));
        cart_items.add(new Cart_Item(R.drawable.red_cabbage, "Bắp cải tím hữu cơ", "119.000/kg", "1kg"));
        cart_items.add(new Cart_Item(R.drawable.green_cabbage, "Bắp cải xanh hữu cơ", "190.000/kg", "1kg"));
        cart_items.add(new Cart_Item(R.drawable.potato, "Khoai tây hữu cơ", "100.000/kg", "1kg"));

    }
    private void loadData() {
        adapter = new CartAdapter(Cart.this, R.layout.cart_item, cart_items);
        lvPickedProduct.setAdapter(adapter);

    }
}