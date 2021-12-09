package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.ItemSimilar;
import com.example.model.ItemSuggestion;
import com.example.nhom03_organicare.R;

import java.util.ArrayList;

public class ItemSimilarAdapter extends RecyclerView.Adapter<ItemSimilarAdapter.ViewHolder> {

    Context context;
    ArrayList<ItemSimilar> itemSimilars;


    public ItemSimilarAdapter(Context context, ArrayList<ItemSimilar> itemSimilars) {
        this.context = context;
        this.itemSimilars = itemSimilars;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_similar, parent, false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvItemThumb.setImageResource(itemSimilars.get(position).getItemThumb());
        holder.txtItemName.setText(itemSimilars.get(position).getItemName());
        holder.txtItemPrice.setText(String.valueOf(itemSimilars.get(position).getItemPrice()));
    }

    @Override
    public int getItemCount() {
        return itemSimilars.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvItemThumb;
        TextView txtItemName, txtItemPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Link Views
            imvItemThumb = itemView.findViewById(R.id.imvItemThumb);
            txtItemName = itemView.findViewById(R.id.txtItemName);
            txtItemPrice = itemView.findViewById(R.id.txtItemPrice);
        }
    }
}
