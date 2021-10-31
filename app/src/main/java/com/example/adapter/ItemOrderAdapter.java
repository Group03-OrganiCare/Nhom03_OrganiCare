package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.ItemOrder;
import com.example.nhom03_organicare.R;

import java.util.ArrayList;

public class ItemOrderAdapter extends RecyclerView.Adapter<ItemOrderAdapter.ViewHolder> {

    Context context;
    ArrayList<ItemOrder> itemOrders;


    public ItemOrderAdapter(Context context, ArrayList<ItemOrder> itemOrders) {
        this.context = context;
        this.itemOrders = itemOrders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_order, parent, false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvItemThumb.setImageResource(itemOrders.get(position).getItemThumb());
        holder.txtItemName.setText(itemOrders.get(position).getItemName());
        holder.txtItemPrice.setText(String.valueOf(itemOrders.get(position).getItemPrice()));
        holder.txtItemWeight.setText(String.valueOf(itemOrders.get(position).getItemWeight()));
        holder.txtItemTotal.setText(String.valueOf(itemOrders.get(position).getItemTotal()));
    }


    @Override
    public int getItemCount() {
        return itemOrders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvItemThumb;
        TextView txtItemName, txtItemPrice, txtItemWeight, txtItemTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Link Views
            imvItemThumb = itemView.findViewById(R.id.imvItemThumb);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtItemPrice = itemView.findViewById(R.id.txtItemPrice);
            txtItemWeight = itemView.findViewById(R.id.txtItemWeightData);
            txtItemTotal = itemView.findViewById(R.id.txtTotalData);
        }

    }
}
