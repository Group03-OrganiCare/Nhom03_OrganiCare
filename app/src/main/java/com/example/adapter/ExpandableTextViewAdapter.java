package com.example.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.text.LineBreaker;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.nhom03_organicare.R;

public class ExpandableTextViewAdapter extends BaseExpandableListAdapter {

    Context context;
    String[]  faqQuestion ={
            "Làm thế nào để bảo quản được thực phẩm hữu cơ?",
            "Làm thế nào để nhận biệt được thực phẩm hữu cơ? ",
            "Các chứng nhận về thực phẩm hữu cơ?",
            "Tại sao giá thực phẩm hữu cơ lại đắt hơn so với thực phẩm thông thường?"
    };
    String[][]  faqAnswer ={
            {"Hầu hết các sản phẩm khi chưa mở nắp, bạn chỉ cần bảo quản ở nhiệt độ phòng, dưới 30 độ C. " +
                    "Tránh ánh nắng trực tiếp chiếu thẳng vào, tránh đè nặng các đồ vật lên nhau. " +
                    "Sau mở nắp, hầu hết các sản phẩm thực phẩm hữu cơ cần được bảo quản trong tủ lạnh. " +
                    "Điều này tránh vi khuẩn xâm nhập."},

            {"Hầu hết các sản phẩm khi chưa mở nắp, bạn chỉ cần bảo quản ở nhiệt độ phòng, dưới 30 độ C. " +
            "Tránh ánh nắng trực tiếp chiếu thẳng vào, tránh đè nặng các đồ vật lên nhau. " +
            "Sau mở nắp, hầu hết các sản phẩm thực phẩm hữu cơ cần được bảo quản trong tủ lạnh. " +
            "Điều này tránh vi khuẩn xâm nhập."},

            {"Hầu hết các sản phẩm khi chưa mở nắp, bạn chỉ cần bảo quản ở nhiệt độ phòng, dưới 30 độ C. " +
                    "Tránh ánh nắng trực tiếp chiếu thẳng vào, tránh đè nặng các đồ vật lên nhau. " +
                    "Sau mở nắp, hầu hết các sản phẩm thực phẩm hữu cơ cần được bảo quản trong tủ lạnh. " +
                    "Điều này tránh vi khuẩn xâm nhập."},

            {"Hầu hết các sản phẩm khi chưa mở nắp, bạn chỉ cần bảo quản ở nhiệt độ phòng, dưới 30 độ C. " +
                    "Tránh ánh nắng trực tiếp chiếu thẳng vào, tránh đè nặng các đồ vật lên nhau. " +
                    "Sau mở nắp, hầu hết các sản phẩm thực phẩm hữu cơ cần được bảo quản trong tủ lạnh. " +
                    "Điều này tránh vi khuẩn xâm nhập."}
    };

    TextView faqQ,faqA;
    public ExpandableTextViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return faqQuestion.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return faqAnswer[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return faqQuestion[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return faqAnswer[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
        String questionFAQ=(String) getGroup(groupPosition);
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_faq_question,null);
        }
        faqQ= view.findViewById(R.id.txtFAQQuestion);
        faqQ.setText(questionFAQ);
        faqQ.setTypeface(null, Typeface.BOLD);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup parent) {
        final String answerFAQ=(String) getChild(groupPosition,childPosition);
        if(view==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.item_faq_answer,null);
        }
        faqA =view.findViewById(R.id.txtFAQAnswer);
        faqA.setText(answerFAQ);
        faqA.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
