package com.example.nhom03_organicare;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.CategoryAdapter;
import com.example.adapter.ProductAdapter;
import com.example.model.Category;
import com.example.model.MyItemClick;
import com.example.model.Product;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    EditText edtSearch;
    TextView txtProductNameDetail, txtProductPriceDetail, txtTitle;
    ImageView imvProductImage;
    GridView gvCategory, gvBestSeller;
    ArrayList<Category> categories;
    ArrayList<Product> products;
    CategoryAdapter categoryAdapter;
    ProductAdapter productAdapter;
    MyItemClick itemClick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Link Views
        edtSearch = view.findViewById(R.id.edtSearch);
        gvCategory = view.findViewById(R.id.gvCategory);
        gvBestSeller = view.findViewById(R.id.gvBestSeller);
        imvProductImage = view.findViewById(R.id.imvProductImage);
        txtProductNameDetail = view.findViewById(R.id.txtProductNameDetail);
        txtProductPriceDetail = view.findViewById(R.id.txtProductPriceDetail);
        txtTitle = view.findViewById(R.id.txtTitle);

        //loadData
        categoryAdapter = new CategoryAdapter(getContext(), R.layout.category_layout, initData());
        gvCategory.setAdapter(categoryAdapter);

        productAdapter = new ProductAdapter(getContext(), R.layout.item_layout, initData2());
        gvBestSeller.setAdapter(productAdapter);

        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        gvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    itemClick = (MyItemClick) getActivity();
                    if (itemClick != null) {
                        itemClick.clickCat(categories.get(position));
                    }
                } else {
                    txtTitle.setText(categories.get(position).getCategoryName());
                }
            }
        });

        gvBestSeller.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    itemClick = (MyItemClick) getActivity();
                    if (itemClick != null) {
                        itemClick.click(products.get(position));
                    }
                } else {
                    imvProductImage.setImageResource(products.get(position).getProductThumb());
                    txtProductNameDetail.setText(products.get(position).getProductName());
                    txtProductPriceDetail.setText(String.format("%.0f", products.get(position).getProductPrice()) + "VND");
                }
            }
        });

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
        products.add(new Product(R.drawable.green_cabbage, "Bắp cải", 120000, "USDA", "JAS"));
        products.add(new Product(R.drawable.juice_apple, "Nước ép táo", 200000, "USDA", "JAS"));
        products.add(new Product(R.drawable.cacao, "Bột cacao", 150000, "USDA", "JAS"));
        products.add(new Product(R.drawable.milk_canxi, "Sữa canxi", 180000, "USDA", "JAS"));
        products.add(new Product(R.drawable.egg, "Trứng", 90000, "USDA", "JAS"));
        products.add(new Product(R.drawable.potato, "Khoai tây", 140000, "USDA", "JAS"));

        return products;
    }
}