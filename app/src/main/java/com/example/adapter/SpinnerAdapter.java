package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhom03_organicare.R;

public class SpinnerAdapter extends BaseAdapter {

    Context context;
    ImageView imvIcon;
    TextView txtName;
    int icons[];
    String[] names;
    LayoutInflater inflater;

    public SpinnerAdapter(Context context, int[] icons, String[] names, LayoutInflater inflater) {
        this.context = context;
        this.icons = icons;
        this.names = names;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_spinner, null);
        imvIcon = view.findViewById(R.id.imvIcon);
        txtName = view.findViewById(R.id.txtName);
        imvIcon.setImageResource(icons[i]);
        txtName.setText(names[i]);
        return view;
    }
}
