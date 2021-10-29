package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Category;
import com.example.nhom03_organicare.R;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    Context context;
    int item_gridview;
    List<Category> categoryList;

    public CategoryAdapter(Context context, int item_gridview, List<Category> categoryList) {
        this.context = context;
        this.item_gridview = item_gridview;
        this.categoryList = categoryList;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int i) {
        return categoryList.get(i);
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
            holder.imvCategoryThumb = view.findViewById(R.id.imvCategoryThumb);
            holder.txtCategoryName = view.findViewById(R.id.txtCategoryName);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        //Binding data
        Category cat = categoryList.get(i);
        holder.imvCategoryThumb.setImageResource(cat.getCategoryThumb());
        holder.txtCategoryName.setText(cat.getCategoryName());

        return view;
    }

    public static class ViewHolder {
        ImageView imvCategoryThumb;
        TextView txtCategoryName;
    }

}
