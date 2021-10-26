package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        linkViews();
        setNavigation();

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
        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                //Check condition
                switch (item.getId()) {
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new OnlyYouFragment();
                        break;
                    case 3:
                        fragment = new CartFragment();
                        break;
                    case 4:
                        fragment = new NotiFragment();
                        break;
                    case 5:
                        fragment = new Accountragment();
                        break;
                }
            }
        });
    }


}