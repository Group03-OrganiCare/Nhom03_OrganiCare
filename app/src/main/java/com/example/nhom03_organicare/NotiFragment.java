package com.example.nhom03_organicare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adapter.NoticeAdapter;
import com.example.model.ItemNotice;

import java.util.ArrayList;
import java.util.List;


public class NotiFragment extends Fragment {

    ListView lvNotice;
    ArrayList<ItemNotice> itemNotices;
    NoticeAdapter noticeAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noti, container, false);
        //Link view
        lvNotice = view.findViewById(R.id.lvNotice);
        //Load data
        noticeAdapter = new NoticeAdapter(getContext(), R.layout.item_notice, initData());
        lvNotice.setAdapter(noticeAdapter);
        return view;
    }

    private List<ItemNotice> initData() {
        itemNotices = new ArrayList<ItemNotice>();
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 1", "Đặt hàng thành công!", "03/12/2021 03:00 PM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 2", "Đặt hàng thành công!", "04/12/2021 04:00 PM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 3", "Đặt hàng thành công!", "05/12/2021 05:00 PM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 4", "Đặt hàng thành công!", "06/12/2021 06:00 PM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 5", "Đặt hàng thành công!", "07/12/2021 07:00 PM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 6", "Đặt hàng thành công!", "08/12/2021 08:00 AM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 7", "Đặt hàng thành công!", "09/12/2021 09:00 AM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 8", "Đặt hàng thành công!", "10/12/2021 10:00 AM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 9", "Đặt hàng thành công!", "11/12/2021 11:00 AM"));
        itemNotices.add(new ItemNotice(R.drawable.notibell, "Thông báo 10", "Đặt hàng thành công!", "12/12/2021 02:00 PM"));
        return itemNotices;
    }
}