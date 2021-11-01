package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.ItemPaymentAndShipment;
import com.example.nhom03_organicare.R;

import java.util.List;

public class ItemPayAndShipAdapter extends BaseAdapter {
    Activity context;
    int resource;
    List<ItemPaymentAndShipment> list;

    public ItemPayAndShipAdapter(Activity context, int resource, List<ItemPaymentAndShipment> list) {
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){

            holder = new ViewHolder();
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,null);
            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName=view.findViewById(R.id.txtName);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            view.setTag(holder);
        }else{
            holder =(ViewHolder) view.getTag();
        }
        //binding data
        ItemPaymentAndShipment item = list.get(i);
        holder.imvThumb.setImageResource(item.getPayAndShipThumb());
        holder.txtName.setText(item.getPayAndShipName());
        holder.txtPrice.setText(String.valueOf(item.getPayAndShipPrice()));

        return view;
    }
    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtPrice,txtName;
    }

}
