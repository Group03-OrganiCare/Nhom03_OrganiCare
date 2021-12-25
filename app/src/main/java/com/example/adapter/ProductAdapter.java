package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Product;
import com.example.nhom03_organicare.R;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Context context;
    int item_gridview;
    List<Product> productList;

    public ProductAdapter(Context context, int item_gridview, List<Product> productList) {
        this.context = context;
        this.item_gridview = item_gridview;
        this.productList = productList;
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            //Link item view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_gridview, null);
            holder.imvProductThumb = view.findViewById(R.id.imvProductThumb);
            holder.txtProductName = view.findViewById(R.id.txtProductName);
            holder.txtProductPrice = view.findViewById(R.id.txtProductPrice);
            holder.txtProductCert1 = view.findViewById(R.id.txtProductCert1);
            holder.txtProductCert2 = view.findViewById(R.id.txtProductCert2);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        Product p = productList.get(i);
        holder.imvProductThumb.setImageResource(p.getProductThumb());
        holder.txtProductName.setText(p.getProductName());
        holder.txtProductPrice.setText(String.format("%.0f", p.getProductPrice()) + "VND");
        holder.txtProductCert1.setText(p.getProductCert1());
        holder.txtProductCert2.setText(p.getProductCert2());

        return view;
    }

    public static class ViewHolder {
        ImageView imvProductThumb;
        TextView txtProductName, txtProductPrice, txtProductCert1, txtProductCert2;
    }

}
