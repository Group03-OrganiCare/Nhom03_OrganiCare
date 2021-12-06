package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.Store;
import com.example.nhom03_organicare.R;

import java.util.List;

public class StoreAdapter extends BaseAdapter {

    Activity context;
    int item_layout_store;
    List<Store> storeList;

    public StoreAdapter(Activity context, int item_layout_store, List<Store> storeList) {
        this.context = context;
        this.item_layout_store = item_layout_store;
        this.storeList = storeList;
    }

    @Override
    public int getCount() {
        return storeList.size();
    }

    @Override
    public Object getItem(int i) {
        return storeList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            //Link item
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout_store,null);
            holder.txtStoreName = view.findViewById(R.id.txtStoreName);
            holder.txtDistance = view.findViewById(R.id.txtDistance);
            holder.txtAddress = view.findViewById(R.id.txtAddress);

            view.setTag(holder);


        }else{
            holder = (ViewHolder) view.getTag();
        }
            Store store = storeList.get(i);
            holder.txtAddress.setText(store.getTxtAddress());
            holder.txtDistance.setText(store.getTxtDistance());
            holder.txtStoreName.setText(store.getTxtStoreName());
        return view;
    }

    public static class ViewHolder{
        TextView txtStoreName, txtAddress, txtDistance;
    }

}
