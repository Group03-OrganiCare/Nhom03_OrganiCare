package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Delivering;
import com.example.nhom03_organicare.R;

import java.util.List;

public class DeliveringAdapter extends BaseAdapter {

    Activity context;
    int item_layout_delivering;
    List<Delivering> deliverings;

    public DeliveringAdapter(Activity context, int item_layout_delivering, List<Delivering> deliverings) {
        this.context = context;
        this.item_layout_delivering = item_layout_delivering;
        this.deliverings = deliverings;
    }

    @Override
    public int getCount() {
        return deliverings.size();
    }

    @Override
    public Object getItem(int i) {
        return deliverings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder1 holder1;
        if(view == null){
        holder1 = new ViewHolder1();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout_delivering,null);
            holder1.imvProduct = view.findViewById(R.id.imvProduct_delivery);
            holder1.txtProductName = view.findViewById(R.id.txtNameProduct_delivery);
            holder1.txtPriceEach = view.findViewById(R.id.txtPriceEach_delivery);
            holder1.txtWeight = view.findViewById(R.id.txtWeight_delivery);
            holder1.txtPriceInvoice = view.findViewById(R.id.txtPriceInvoice_delivery);

            view.setTag(holder1);
        }else {
            holder1 = (ViewHolder1) view.getTag();
        }
            Delivering delivering = deliverings.get(i);
            holder1.txtPriceInvoice.setText(String.format("%.0f", delivering.getPriceInvoice_delivering()) + "VND");
            holder1.txtWeight.setText(String.valueOf(delivering.getWeight_delivering()));
            holder1.txtProductName.setText(delivering.getProductName_delivering());
            holder1.txtPriceEach.setText(String.valueOf(delivering.getPriceEach_delivering()));
            holder1.imvProduct.setImageResource(delivering.getProductThumb_delivering());
            return view;
    }

    public static class ViewHolder1{
        ImageView imvProduct;
        TextView txtProductName, txtPriceEach, txtWeight, txtPriceInvoice;
    }
}
