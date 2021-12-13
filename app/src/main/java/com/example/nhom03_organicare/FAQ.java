package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import com.example.adapter.ExpandableTextViewAdapter;

public class FAQ extends AppCompatActivity {

    ExpandableListView expandableTextView;
    ExpandableTextViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        linkViews();
        loadData();

    }

    private void linkViews() {
        expandableTextView=findViewById(R.id.elvFAQ);

    }

    private void loadData() {
        adapter= new ExpandableTextViewAdapter(this);
        expandableTextView.setAdapter(adapter);
    }
}