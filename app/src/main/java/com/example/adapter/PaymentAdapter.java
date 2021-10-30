package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Payment;
import com.example.nhom03_organicare.R;

import java.util.List;

public class PaymentAdapter extends BaseAdapter {

    Activity context;
    int resource;
    List<Payment> paymentList;

    public PaymentAdapter(Activity context, int resource, List<Payment> paymentList) {
        this.context = context;
        this.resource = resource;
        this.paymentList = paymentList;
    }

    @Override
    public int getCount() {
        return paymentList.size();
    }

    @Override
    public Object getItem(int i) {
        return paymentList.get(i);
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
            holder.imvPaymentThumb = view.findViewById(R.id.imvPaymentThumb);
            holder.txtPaymentName = view.findViewById(R.id.txtPaymentName);
            view.setTag(holder);
        }else{
            holder =(ViewHolder) view.getTag();
        }
        //binding data
        Payment p = paymentList.get(i);
        holder.imvPaymentThumb.setImageResource(p.getPaymentThumb());
        holder.txtPaymentName.setText(String.valueOf(p.getPaymentName()));
        return view;
    }
    public static class ViewHolder{
        ImageView imvPaymentThumb;
        TextView txtPaymentName;
    }
}
