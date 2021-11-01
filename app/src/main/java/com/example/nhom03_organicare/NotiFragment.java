package com.example.nhom03_organicare;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.model.Category;

import java.util.ArrayList;


public class NotiFragment extends Fragment {

    ListView lvNotice;
    ArrayList<String> arrayNotice;
    ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noti, container, false);
        //Link view
        lvNotice = view.findViewById(R.id.lvNotice);
        arrayNotice = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, initData() );
        lvNotice.setAdapter(arrayAdapter);
        return view;
    }

    private ArrayList<String> initData(){
        arrayNotice.add("Notice 1");
        arrayNotice.add("Notice 2");
        arrayNotice.add("Notice 3");
        arrayNotice.add("Notice 4");
        arrayNotice.add("Notice 5");
        arrayNotice.add("Notice 6");
        arrayNotice.add("Notice 7");
        arrayNotice.add("Notice 8");
        arrayNotice.add("Notice 9");
        arrayNotice.add("Notice 10");
        arrayNotice.add("Notice 11");
        arrayNotice.add("Notice 12");
        arrayNotice.add("Notice 13");
        arrayNotice.add("Notice 14");
        arrayNotice.add("Notice 15");
        arrayNotice.add("Notice 16");
        return arrayNotice;
    }

}