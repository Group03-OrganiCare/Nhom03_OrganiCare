package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Sale_Item;
import com.example.nhom03_organicare.R;

import java.util.ArrayList;

public class SaleAdapter extends BaseAdapter {

    Context context;
    int item_gridview;
    ArrayList<Sale_Item> sale_items;

    public SaleAdapter(Context context, int item_gridview, ArrayList<Sale_Item> sale_items) {
        this.context = context;
        this.item_gridview = item_gridview;
        this.sale_items = sale_items;
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
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_sale, null);
            holder.imvSaleThumb = view.findViewById(R.id.imvSaleThumb);
            holder.txtSaleProductName = view.findViewById(R.id.txtSaleProductName);
            holder.txtSaleProductPrice = view.findViewById(R.id.txtSaleProductPrice);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        Sale_Item s = sale_items.get(i);
        holder.imvSaleThumb.setImageResource(s.getProductThumb());
        holder.txtSaleProductName.setText(s.getProductName());
        holder.txtSaleProductPrice.setText(String.format("%.0f", s.getProductPrice()) + "VND");


        return view;
    }

    public static class ViewHolder {
        ImageView imvSaleThumb;
        TextView txtSaleProductName, txtSaleProductPrice;
    }
}
