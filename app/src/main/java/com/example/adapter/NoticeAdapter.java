package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.ItemNotice;
import com.example.nhom03_organicare.R;

import java.util.List;

public class NoticeAdapter extends BaseAdapter {
    Context context;
    int item_listview;
    List<ItemNotice> itemNotices;

    public NoticeAdapter(Context context, int item_listview, List<ItemNotice> itemNotices) {
        this.context = context;
        this.item_listview = item_listview;
        this.itemNotices = itemNotices;
    }

    @Override
    public int getCount() {
        return itemNotices.size();
    }

    @Override
    public Object getItem(int i) {
        return itemNotices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_listview, null);
            holder.imvNoticeThumb = view.findViewById(R.id.imvNoticeThumb);
            holder.txtNoticeNumber = view.findViewById(R.id.txtNoticeNumber);
            holder.txtNoticeContent = view.findViewById(R.id.txtNoticeContent);
            holder.txtNoticeTime = view.findViewById(R.id.txtNoticeTime);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        ItemNotice b = itemNotices.get(i);
        holder.imvNoticeThumb.setImageResource(b.getNoticeThumb());
        holder.txtNoticeNumber.setText(b.getNoticeNumber());
        holder.txtNoticeContent.setText(b.getNoticeContent());
        holder.txtNoticeTime.setText(b.getNoticeTime());
        return view;
    }
    public static class ViewHolder{
        ImageView imvNoticeThumb;
        TextView txtNoticeNumber, txtNoticeContent, txtNoticeTime;
    }
}
