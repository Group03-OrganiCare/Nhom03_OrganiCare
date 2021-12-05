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

public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.DiscountHolder>{

    private List<Discount> mListDiscount;

    public DiscountAdapter(List<Discount> mListDiscount) {
        this.mListDiscount = mListDiscount;
    }

    @NonNull
    @Override
    public DiscountHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discount, parent, false);
        return new DiscountHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscountHolder holder, int position) {
        Discount discount = mListDiscount.get(position);
        if (discount != null){
            return;
        }
        holder.imvDiscount.setImageResource(discount.getCodeThumb());
        holder.txtCodeName.setText(discount.getCodeName());
        holder.txtCodeUsage.setText(discount.getCodeUsage());
        holder.txtCodeExp.setText(discount.getGetCodeExp());
    }

    @Override
    public int getItemCount() {
        if(mListDiscount != null){
            return mListDiscount.size();
        }
        return 0;
    }

    public class DiscountHolder extends RecyclerView.ViewHolder{

        private CircleImageView imvDiscount;
        private TextView txtCodeName, txtCodeUsage, txtCodeExp;

        public DiscountHolder(@NonNull View itemView) {
            super(itemView);
            imvDiscount = itemView.findViewById(R.id.imvDiscount);
            txtCodeName  = itemView.findViewById(R.id.txtCodeName);
            txtCodeUsage  = itemView.findViewById(R.id.txtCodeUsage);
            txtCodeExp  = itemView.findViewById(R.id.txtCodeExp);
        }
    }
}
