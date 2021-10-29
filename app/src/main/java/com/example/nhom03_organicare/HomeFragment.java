package com.example.nhom03_organicare;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.adapter.CategoryAdapter;
import com.example.model.Category;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    GridView gvCategory;
    ArrayList<Category> categories;
    CategoryAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Link Views
        gvCategory = view.findViewById(R.id.gvCategory);
        //loadData
        adapter = new CategoryAdapter(getContext(), R.layout.category_layout, initData());
        gvCategory.setAdapter(adapter);

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




}