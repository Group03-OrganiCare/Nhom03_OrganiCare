package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.adapter.DeliveringAdapter;
import com.example.model.Delivering;

import java.util.ArrayList;

public class TabHostInvoice extends AppCompatActivity {

    ListView lvDelivering;
    ArrayList<Delivering> deliverings;
    DeliveringAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_invoice);
        try {
            TabHost th = findViewById(R.id.tabHostInvoice);
            th.setup();

            TabHost.TabSpec spec = th.newTabSpec("Tab One");
            spec.setContent(R.id.tab1);
            spec.setIndicator("Đang giao");
            th.addTab(spec);

            spec = th.newTabSpec("Tab Two");
            spec.setContent(R.id.tab2);
            spec.setIndicator("Đã giao");
            th.addTab(spec);

            spec = th.newTabSpec("Tab Three");
            spec.setContent(R.id.tab3);
            spec.setIndicator("Đã huỷ");
            th.addTab(spec);
        }catch (Exception e){
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        linkViews();
        initData();
        loadData();
    }
    private void linkViews() {
        lvDelivering = findViewById(R.id.lvDelivering);
    }

    private void initData() {
        deliverings = new ArrayList<Delivering>();
        deliverings.add(new Delivering(R.drawable.ic_launcher_background,"Táo Dazzle",50000,5,250000));
        deliverings.add(new Delivering(R.drawable.ic_launcher_background,"Kiwi Zespri",80000,5,400000));
        deliverings.add(new Delivering(R.drawable.ic_launcher_background,"Granola",100000,5,500000));
        deliverings.add(new Delivering(R.drawable.ic_launcher_background,"Sữa hạt hữu cơ",30000,5,150000));
        deliverings.add(new Delivering(R.drawable.ic_launcher_background,"Việt quất",30000,5,150000));
        deliverings.add(new Delivering(R.drawable.ic_launcher_background,"Khoai lang hữu cơ",30000,5,150000));
    }

    private void loadData() {
        adapter = new DeliveringAdapter(TabHostInvoice.this,R.layout.item_layout_delivering,deliverings);
        lvDelivering.setAdapter(adapter);
    }
}