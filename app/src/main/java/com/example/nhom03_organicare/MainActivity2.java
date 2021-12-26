package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.model.Category;
import com.example.model.MyItemClick;
import com.example.model.Product;
import com.example.model.Sale_Item;

import java.util.function.Function;

public class MainActivity2 extends AppCompatActivity implements MyItemClick {

    MeowBottomNavigation bottomNavigation;
    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        broadcastReceiver = new NetworkReceiver();
        RegisterNetworkBroadcastReceiver();

        linkViews();
        setNavigation();
    }

    @Override
    public void click(Product p) {
        Intent intent = new Intent(MainActivity2.this, ProductDetails.class);
        intent.putExtra("SelectedItem", p);
        startActivity(intent);
    }

    @Override
    public void clickItem(Sale_Item s) {
        Intent intent = new Intent(MainActivity2.this, ProductDetails.class);
        intent.putExtra("SaleItem", s);
        startActivity(intent);
    }

    @Override
    public void clickCat(Category c) {
        Intent intent = new Intent(MainActivity2.this, CategoryActivity.class);
        intent.putExtra("CatItem", c);
        startActivity(intent);
    }

    protected void RegisterNetworkBroadcastReceiver(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unRegisterNetworkBroadcastReceiver(){
        try {
            unregisterReceiver(broadcastReceiver);
        }catch (IllegalArgumentException e){
            e.printStackTrace();

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterNetworkBroadcastReceiver();
    }

    private void linkViews() {
        bottomNavigation = findViewById(R.id.bottomNavigation);
    }

    private void setNavigation() {

        //Add navigation item
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_only_you));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_shopping_cart));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_notifications));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_account));

        //Add events
        getSupportFragmentManager().beginTransaction().replace(R.id.layoutContainer, new HomeFragment()).commit();
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment fragment = null;
                //Check condition
                switch (item.getId()) {
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new SaleFragment();
                        break;
                    case 3:
                        fragment = new CartFragment();
                        break;
                    case 4:
                        fragment = new NotiFragment();
                        break;
                    case 5:
                        fragment = new Account2Fragment();
                        break;
                }
                transaction.replace(R.id.layoutContainer, fragment);
                transaction.commit();


                //Set notification count
                bottomNavigation.setCount(4, "10");
                //Set home fragment initially selected
                //bottomNavigation.show(1, true);
            }
        });

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(getApplicationContext(), "You clicked " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}