package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.ItemOrderTracking;
import com.example.nhom03_organicare.R;

import java.util.ArrayList;

public class ItemOrderTrackingAdapter extends RecyclerView.Adapter<ItemOrderTrackingAdapter.ViewHolder> {
    Context context;
    ArrayList<ItemOrderTracking> trackingOrders;

    public ItemOrderTrackingAdapter(Context context, ArrayList<ItemOrderTracking> trackingOrders) {
        this.context = context;
        this.trackingOrders = trackingOrders;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_delivery_condition, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvItemThumb.setImageResource(trackingOrders.get(position).getProductOrderThumb());
        holder.txtItemName.setText(trackingOrders.get(position).getProductName());
        holder.txtItemPrice.setText(String.format("%.0f", trackingOrders.get(position).getProductPrice()) + "VND");
        holder.txtItemQuantity.setText((trackingOrders.get(position).getProductQuantity()));
        holder.txtCondition.setText((trackingOrders.get(position).getDeliveryCondition()));
    }

    @Override
    public int getItemCount() {
        return trackingOrders.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvItemThumb;
        TextView txtItemName, txtItemPrice, txtItemQuantity, txtCondition;
        public ViewHolder(@NonNull View view) {
            super(view);
            //LinkViews
            imvItemThumb = view.findViewById(R.id.imvProductThumbOrder);
            txtItemName = view.findViewById(R.id.txtProductNameOrder);
            txtItemPrice = view.findViewById(R.id.txtProductPriceOrder);
            txtItemQuantity = view.findViewById(R.id.txtProductQuantity);
            txtCondition = view.findViewById(R.id.txtOrderCondition);

        }


    }
}
