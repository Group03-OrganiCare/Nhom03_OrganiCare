package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Delivery;
import com.example.model.Payment;
import com.example.nhom03_organicare.R;

import java.util.List;

public class DeliveryAdapter extends BaseAdapter {

    Activity context;
    int resource;
    List<Delivery>deliveryList;

    public DeliveryAdapter(Activity context, int resource, List<Delivery> deliveryList) {
        this.context = context;
        this.resource = resource;
        this.deliveryList = deliveryList;
    }

    @Override
    public int getCount() {
        return deliveryList.size();
    }

    @Override
    public Object getItem(int i) {
        return deliveryList.get(i);
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
            holder.imvDeliveryThumb = view.findViewById(R.id.imvThumb);
            holder.txtDeliveryPrice = view.findViewById(R.id.txtName);
            view.setTag(holder);
        }else{
            holder =(ViewHolder) view.getTag();
        }
        //binding data
        Delivery d = deliveryList.get(i);
        holder.imvDeliveryThumb.setImageResource(d.getDeliveryThumb());
        holder.txtDeliveryPrice.setText(String.valueOf(d.getDeliveryPrice()));
        return view;
    }
    public static class ViewHolder{
        ImageView imvDeliveryThumb;
        TextView txtDeliveryPrice;
    }


}
