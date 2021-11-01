package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Cart_Item;
import com.example.nhom03_organicare.R;

import java.util.List;

public class CartAdapter extends BaseAdapter {
    Context context;
    int item_listview;
    List<Cart_Item> cart_items;
    public CartAdapter(Context context, int item_listview, List<Cart_Item>productList) {
        this.context = context;
        this.cart_items = productList;
        this.item_listview = item_listview;
    }
    @Override
    public int getCount() {
        return cart_items.size();
    }

    @Override
    public Object getItem(int i) {
        return cart_items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.txtPickedName = view.findViewById(R.id.txtPickedName);
            holder.imvPickedThumb = view.findViewById(R.id.imvPickedThumb);
            holder.txtPickedPrice = view.findViewById(R.id.txtPickedPrice);
            holder.txtPickedWeight = view.findViewById(R.id.txtPickedWeight);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Cart_Item b = cart_items .get(i);
        holder.txtPickedName.setText(b.getPickedName());
        holder.imvPickedThumb.setImageResource(b.getPickedThumb());
        holder.txtPickedPrice.setText(b.getPickedPrice());
        holder.txtPickedWeight.setText(b.getPickedWeight());
        return view;
    }
    public static class ViewHolder{
        ImageView imvPickedThumb;
        TextView txtPickedName, txtPickedPrice, txtPickedWeight;
    }
}
