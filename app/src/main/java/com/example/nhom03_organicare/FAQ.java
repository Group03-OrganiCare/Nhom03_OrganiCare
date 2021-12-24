package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;

import com.example.adapter.ExpandableTextViewAdapter;

public class FAQ extends AppCompatActivity {

    ExpandableListView expandableTextView;
    ExpandableTextViewAdapter adapter;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        linkViews();
        loadData();
        addEvents();

    }

    private void linkViews() {
        expandableTextView=findViewById(R.id.elvFAQ);
        btnBack = findViewById(R.id.btnBack);
    }

    private void loadData() {
        adapter= new ExpandableTextViewAdapter(this);
        expandableTextView.setAdapter(adapter);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}