package com.example.nhom03_organicare;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.adapter.CategoryAdapter;
import com.example.adapter.ProductAdapter;
import com.example.model.Category;
import com.example.model.Product;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    GridView gvCategory, gvBestSeller;
    ArrayList<Category> categories;
    ArrayList<Product> products;
    CategoryAdapter categoryAdapter;
    ProductAdapter productAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Link Views
        gvCategory = view.findViewById(R.id.gvCategory);
        gvBestSeller = view.findViewById(R.id.gvBestSeller);

        //loadData
        categoryAdapter = new CategoryAdapter(getContext(), R.layout.category_layout, initData());
        gvCategory.setAdapter(categoryAdapter);

        productAdapter = new ProductAdapter(getContext(), R.layout.item_layout, initData2());
        gvBestSeller.setAdapter(productAdapter);

//        gvBestSeller.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_MOVE) {
//                    return true;
//                }
//                return false;
//            }
//        });

        return view;
    }

    private ArrayList<Category> initData() {
        categories = new ArrayList<Category>();
        categories.add(new Category(R.drawable.fruits, "Trái cây"));
        categories.add(new Category(R.drawable.vegetables, "Rau củ"));
        categories.add(new Category(R.drawable.drinks, "Đồ uống"));
        categories.add(new Category(R.drawable.others, "Khác"));

        return categories;
    }

    private ArrayList<Product> initData2() {
        products = new ArrayList<Product>();
        products.add(new Product(R.drawable.kiwi, "Kiwi", 150000, "USDA", "JAS"));
        products.add(new Product(R.drawable.apple_fuji, "Táo Fuji", 180000, "USDA", "JAS"));
        products.add(new Product(R.drawable.carrot, "Cà rốt", 100000, "USDA", "JAS"));
        products.add(new Product(R.drawable.green_cabbage, "Bắp cải xanh", 120000, "USDA", "JAS"));
        products.add(new Product(R.drawable.juice_apple, "Nước ép táo", 200000, "USDA", "JAS"));
        products.add(new Product(R.drawable.cacao, "Bột cacao", 150000, "USDA", "JAS"));
        products.add(new Product(R.drawable.milk_canxi, "Sữa canxi", 180000, "USDA", "JAS"));
        products.add(new Product(R.drawable.egg, "Trứng", 90000, "USDA", "JAS"));
        products.add(new Product(R.drawable.potato, "Khoai tây", 140000, "USDA", "JAS"));

        return products;
    }



}