package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.model.Cart_Item;
import com.example.nhom03_organicare.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{

    Context context;
    int item_layout;

    private List<Cart_Item> products;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public CartAdapter(Context context, int item_layout, List<Cart_Item> products) {
        this.context = context;
        this.item_layout = item_layout;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cart_Item p = products.get(position);
        if(p == null){
            return;
        }
        viewBinderHelper.bind(holder.layoutSwipe, String.valueOf(p.getPickedThumb()));
        holder.imvPickedThumb.setImageResource(p.getPickedThumb());
        holder.txtPickedName.setText(p.getPickedName());
        holder.txtPickedPrice.setText(p.getPickedPrice());
        holder.txtPickedWeight.setText(p.getPickedWeight());

        holder.imvDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                products.remove(holder.getBindingAdapterPosition());
                notifyItemRemoved(holder.getBindingAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        if(products != null){
            return products.size();
        }
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private SwipeRevealLayout layoutSwipe;
        private ImageView imvPickedThumb;
        private TextView txtPickedName, txtPickedPrice, txtPickedWeight;
        private ImageView imvDel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutSwipe = itemView.findViewById(R.id.layoutSwipe);
            imvPickedThumb = itemView.findViewById(R.id.imvPickedThumb);
            txtPickedName = itemView.findViewById(R.id.txtPickedName);
            txtPickedPrice = itemView.findViewById(R.id.txtPickedPrice);
            txtPickedWeight = itemView.findViewById(R.id.txtPickedWeight);


            imvDel = itemView.findViewById(R.id.imvDel);
        }
    }
}
