package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.adapter.StoreAdapter;
import com.example.model.Store;

import java.util.ArrayList;

public class TabHostDelivery extends AppCompatActivity {

    ListView lvStore;
    ArrayList<Store> stores;
    StoreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_delivery);

        try {
            TabHost th = findViewById(R.id.tabHost);
            th.setup();

            TabHost.TabSpec spec = th.newTabSpec("Tab One");
            spec.setContent(R.id.tab1);
            spec.setIndicator("Tự đến lấy");
            th.addTab(spec);

            spec = th.newTabSpec("Tab Two");
            spec.setContent(R.id.tab2);
            spec.setIndicator("Giao hàng");
            th.addTab(spec);
        }catch (Exception e){
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        linkViews();
        initData();
        loadData();
    }
    private void linkViews() {
         lvStore= findViewById(R.id.lvStore);
    }

    private void initData() {
        stores = new ArrayList<Store>();
        stores.add(new Store("Cửa hàng số 1","02 Đinh Công Tráng, Q.7","1km"));
        stores.add(new Store("Cửa hàng số 2","74 Duy Tân, Q.7","6km"));
        stores.add(new Store("Cửa hàng số 3","836 Trần Khánh Dư, Q.7","9km"));
        stores.add(new Store("Cửa hàng số 4","09 Lý Thái Tổ, Q.7","12km"));
        stores.add(new Store("Cửa hàng số 5","21 Trường Chinh, Q.8","12.5km"));
        stores.add(new Store("Cửa hàng số 6","209 Trần Phú, Q.4","16km"));
        stores.add(new Store("Cửa hàng số 7","112 Lê Lợi, Q.4","18km"));

    }

    private void loadData() {
        adapter = new StoreAdapter(TabHostDelivery.this,R.layout.item_layout_store,stores);
        lvStore.setAdapter(adapter);
    }
}