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
import com.example.model.ItemSuggestion;
import com.example.nhom03_organicare.R;

import java.util.ArrayList;

public class ItemSuggestionAdapter extends RecyclerView.Adapter<ItemSuggestionAdapter.ViewHolder> {

    Context context;
    ArrayList<ItemSuggestion> itemSuggestions;


    public ItemSuggestionAdapter(Context context, ArrayList<ItemSuggestion> itemSuggestions) {
        this.context = context;
        this.itemSuggestions = itemSuggestions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_suggestion, parent, false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imvItemThumb.setImageResource(itemSuggestions.get(position).getItemThumb());
        holder.txtItemName.setText(itemSuggestions.get(position).getItemName());
    }

    @Override
    public int getItemCount() {
        return itemSuggestions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imvItemThumb;
        TextView txtItemName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Link Views
            imvItemThumb = itemView.findViewById(R.id.imvItemThumb);
            txtItemName = itemView.findViewById(R.id.txtItemName);
        }
    }
}
