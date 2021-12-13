package com.example.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Discount;
import com.example.nhom03_organicare.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.DiscountViewHolder>{

    private List<Discount> mListDiscounts;

    public DiscountAdapter(List<Discount> mListDiscounts) {
        this.mListDiscounts = mListDiscounts;
    }

    @NonNull
    @Override
    public DiscountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discount, parent, false);
        return new DiscountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountViewHolder holder, int position) {
        Discount discount = mListDiscounts.get(position);
        if (discount == null) {
            return;
        }
        holder.imvDiscount.setImageResource(discount.getCodeThumb());
        holder.txtCodeName.setText(discount.getCodeName());
        holder.txtCodeUsage.setText(discount.getCodeUsage());
        holder.txtCodeExp.setText(discount.getGetCodeExp());
    }

    @Override
    public int getItemCount() {
        if (mListDiscounts != null) {
            return mListDiscounts.size();
        }

        return 0;
    }

    public class DiscountViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView imvDiscount;
        private TextView txtCodeName;
        private TextView txtCodeUsage;
        private TextView txtCodeExp;

        public DiscountViewHolder(@NonNull View itemView) {
            super(itemView);
            imvDiscount = itemView.findViewById(R.id.imvDiscount);
            txtCodeName  = itemView.findViewById(R.id.txtCodeName);
            txtCodeUsage  = itemView.findViewById(R.id.txtCodeUsage);
            txtCodeExp  = itemView.findViewById(R.id.txtCodeExp);
        }
    }
}
