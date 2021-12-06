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

    ListView lvDelivering,lvDelivered,lvDeliverCancel;
    ArrayList<Delivering> deliverings;
    DeliveringAdapter adapter,adapter1,adapter2;
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
    private void linkViews()
    {
        lvDelivering = findViewById(R.id.lvDelivering);
        lvDelivered = findViewById(R.id.lvDelivered);
        lvDeliverCancel = findViewById(R.id.lvDeliverCancel);
    }

    private void initData() {
        deliverings = new ArrayList<Delivering>();
        deliverings.add(new Delivering(R.drawable.apple_dazzle,"Táo Dazzle",50000,250000,5));
        deliverings.add(new Delivering(R.drawable.kiwi,"Kiwi Zespri",80000,400000,5));
        deliverings.add(new Delivering(R.drawable.granola,"Granola",100000,500000,5));
        deliverings.add(new Delivering(R.drawable.milk_barista,"Sữa hạt hữu cơ",30000,150000,5));
        deliverings.add(new Delivering(R.drawable.juice_blueberry,"Việt quất",30000,150000,5));
        deliverings.add(new Delivering(R.drawable.sweet_potato,"Khoai lang hữu cơ",30000,150000,5));
    }

    private void loadData() {
        adapter = new DeliveringAdapter(TabHostInvoice.this,R.layout.item_layout_delivering,deliverings);
        lvDelivering.setAdapter(adapter);
        adapter1 = new DeliveringAdapter(TabHostInvoice.this,R.layout.item_layout_delivered,deliverings);
        lvDelivered.setAdapter(adapter1);
        adapter2 = new DeliveringAdapter(TabHostInvoice.this,R.layout.item_layout_delivercancel, deliverings);
        lvDeliverCancel.setAdapter(adapter2);
    }
}