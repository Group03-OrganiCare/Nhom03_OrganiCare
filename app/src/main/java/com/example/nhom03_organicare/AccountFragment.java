package com.example.nhom03_organicare;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class AccountFragment extends Fragment {

    Button btnLogin, btnSignin;
    ImageView imvSetting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        //linkViews
        btnLogin = view.findViewById(R.id.btnLogin);
        btnSignin = view.findViewById(R.id.btnSignin);
        imvSetting = view.findViewById(R.id.imvSetting);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        imvSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Setting.class);
                startActivity(intent);
            }
        });

        return view;
    }
}