package com.example.nhom03_organicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class Account2Fragment extends Fragment {
    Button btnPoint, btnHistory, btnDiscount, btnFavorite;
    ImageView imvSetting2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account2, container, false);
        btnPoint = view.findViewById(R.id.btnPoint);
        btnHistory = view.findViewById(R.id.btnHistory);
        btnFavorite = view.findViewById(R.id.btnFavorite);
        btnDiscount = view.findViewById(R.id.btnDiscount);

        imvSetting2 = view.findViewById(R.id.imvSetting2);

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Point.class);
                startActivity(intent);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TabHostInvoice.class);
                startActivity(intent);
            }
        });

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FavoriteProducts.class);
                startActivity(intent);
            }
        });

        btnDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DiscountActivity.class);
                startActivity(intent);
            }
        });

        imvSetting2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Setting.class);
                startActivity(intent);
            }
        });

        return view;
    }
}