package com.example.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.nhom03_organicare.LogoFragment;
import com.example.nhom03_organicare.OnboardingFragment1;
import com.example.nhom03_organicare.OnboardingFragment2;
import com.example.nhom03_organicare.OnboardingFragment3;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LogoFragment();
            case 1:
                return new OnboardingFragment1();
            case 2:
                return new OnboardingFragment2();
            case 3:
                return new OnboardingFragment3();
            default:
                return new LogoFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
