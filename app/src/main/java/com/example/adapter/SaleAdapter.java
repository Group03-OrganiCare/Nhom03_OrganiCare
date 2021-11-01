package com.example.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Sale_Item;
import com.example.nhom03_organicare.R;

import java.util.List;

public class SaleAdapter extends BaseAdapter {
    Activity context;
    int item_gridview;
    List<Sale_Item> sale_items;

    public SaleAdapter(Activity context, int item_gridview, List<Sale_Item>sale_items) {
        this.context = context;
        this.sale_items = sale_items;
        this.item_gridview = item_gridview;
    }
    @Override
    public int getCount() {
        return sale_items.size();
    }

    @Override
    public Object getItem(int i) {
        return sale_items.get(i);
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
            view = inflater.inflate(item_gridview, null);
            holder.txtSaleProductName = view.findViewById(R.id.txtSaleProductName);
            holder.imvSaleThumb = view.findViewById(R.id.imvSaleThumb);
            holder.txtSaleProductPrice = view.findViewById(R.id.txtSaleProductPrice);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Sale_Item b = sale_items .get(i);
        holder.txtSaleProductName.setText(b.getProductName());
        holder.imvSaleThumb.setImageResource(b.getProductThumb());
        holder.txtSaleProductPrice.setText(b.getProductPrice());
        return view;
    }
    public static class ViewHolder{
        ImageView imvSaleThumb;
        TextView txtSaleProductName, txtSaleProductPrice;
    }
}
