package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.DeliveringAdapter;
import com.example.model.Delivering;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class TabHostInvoice extends AppCompatActivity {

    ListView lvDelivering, lvDelivered, lvDeliverCancel;
    LinearLayout layoutItem, layoutItem2, layoutItem3;
    ArrayList<Delivering> deliverings;
    DeliveringAdapter adapter, adapter1, adapter2;

    Button btnOpenRateBtS, btnReorder, btnBuyAgain;
    private int numberOrder = 1;
    Spinner spinnerWeight;
    ArrayList<String> weight;
    ArrayAdapter<String> arrayAdapter;
    int customerRating = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_invoice);
        try {
            TabHost th = findViewById(R.id.tabHostInvoice);
            th.setup();


            th.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String s) {

                    for (int i = 0; i < th.getTabWidget().getChildCount(); i++) {
                        th.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#005959")); // unselected
                        TextView tv = (TextView) th.getTabWidget().getChildAt(i).findViewById(android.R.id.title); //Unselected Tabs
                        tv.setTextColor(Color.parseColor("#FFFFFFFF"));
                    }

                    th.getTabWidget().getChildAt(th.getCurrentTab()).setBackgroundColor(Color.parseColor("#FFFFFFFF")); // selected
                    TextView tv = (TextView) th.getCurrentTabView().findViewById(android.R.id.title); //for Selected Tab
                    tv.setTextColor(Color.parseColor("#005959"));
                }
            });
            TabHost.TabSpec spec = th.newTabSpec("Tab One");
            spec.setContent(R.id.tab1);
            spec.setIndicator("Đang giao");
            th.addTab(spec);

            spec = th.newTabSpec("Tab Two");
            spec.setContent(R.id.tab2);
            spec.setIndicator("Đã giao");
            th.addTab(spec);

            spec = th.newTabSpec("Tab Three");
            spec.setContent(R.id.tab3);
            spec.setIndicator("Đã huỷ");
            th.addTab(spec);
        }catch (Exception e){
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        linkViews();
//        initData();
//        loadData();
        addEvents();
    }

    private void linkViews()
    {
//        lvDelivering = findViewById(R.id.lvDelivering);
//        lvDelivered = findViewById(R.id.lvDelivered);
//        lvDeliverCancel = findViewById(R.id.lvDeliverCancel);

        layoutItem = findViewById(R.id.layoutItem);
        layoutItem2 = findViewById(R.id.layoutItem2);
        layoutItem3 = findViewById(R.id.layoutItem3);
        btnOpenRateBtS = findViewById(R.id.btnOpenRateBtS);
        btnReorder = findViewById(R.id.btnReOrder);
        btnBuyAgain = findViewById(R.id.btnBuyAgain);


    }

    private void initData() {
        deliverings = new ArrayList<Delivering>();
        deliverings.add(new Delivering(R.drawable.apple_dazzle,"Táo Dazzle",50000,250000,5));
        deliverings.add(new Delivering(R.drawable.kiwi,"Kiwi Zespri",80000,400000,5));
        deliverings.add(new Delivering(R.drawable.granola,"Granola",100000,500000,5));
        deliverings.add(new Delivering(R.drawable.milk_barista,"Sữa hạt hữu cơ",30000,150000,5));
        deliverings.add(new Delivering(R.drawable.juice_blueberry,"Việt quất",30000,150000,5));
        deliverings.add(new Delivering(R.drawable.sweet_potato,"Khoai lang hữu cơ",30000,150000,5));
    }

    private void loadData() {
        adapter = new DeliveringAdapter(TabHostInvoice.this,R.layout.item_layout_delivering,deliverings);
        lvDelivering.setAdapter(adapter);
        adapter1 = new DeliveringAdapter(TabHostInvoice.this,R.layout.item_layout_delivered,deliverings);
        lvDelivered.setAdapter(adapter1);
        adapter2 = new DeliveringAdapter(TabHostInvoice.this,R.layout.item_layout_delivercancel, deliverings);
        lvDeliverCancel.setAdapter(adapter2);
    }
    private void addEvents() {
        btnOpenRateBtS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetRate = new BottomSheetDialog(TabHostInvoice.this);
                bottomSheetRate.setContentView(R.layout.bottomsheet_rate);
                bottomSheetRate.setCanceledOnTouchOutside(false);

                Button btnRate = bottomSheetRate.findViewById(R.id.btnRate);
                RatingBar ratingBar = bottomSheetRate.findViewById(R.id.ratingBar);

                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        int rating = (int) v;
                        String message = null;

                        customerRating = (int) ratingBar.getRating();
                        switch (rating){
                            case 1:
                                message = "Chúng tôi rất tiếc!";
                                break;
                            case 2:
                                message ="Có vẻ sản phẩm này chưa làm bạn hài lòng?";
                                break;
                            case 3:
                                message = "Để lại đánh giá để chúng tôi cải thiện sản phẩm nhé!";
                                break;
                            case 4:
                                message ="Mừng là bạn thích sản phẩm!";
                                break;
                            case 5:
                                message ="Tuyệt vời! Cảm ơn bạn đã sử dụng sản phẩm";
                                break;
                        }
                        Toast.makeText(TabHostInvoice.this, message, Toast.LENGTH_SHORT).show();
                        bottomSheetRate.show();
                    }
                });
                btnRate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TabHostInvoice.this, "Đánh giá của bạn đã được ghi nhận", Toast.LENGTH_SHORT).show();
                        bottomSheetRate.dismiss();
                    }
                });
                bottomSheetRate.show();
            }
        });

        btnReorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetOrder = new BottomSheetDialog(TabHostInvoice.this);
                bottomSheetOrder.setContentView(R.layout.bottomsheet_order);

                Spinner spinnerWeight = bottomSheetOrder.findViewById(R.id.spinnerWeight);
                weight = new ArrayList<>();
                weight.add("1kg");
                weight.add("5kg");
                weight.add("hộp");
                weight.add("thùng");
                arrayAdapter = new ArrayAdapter<String>(TabHostInvoice.this, android.R.layout.simple_spinner_dropdown_item, weight);
                spinnerWeight.setAdapter(arrayAdapter);

                ImageView imvMinus = bottomSheetOrder.findViewById(R.id.imvMinus),
                        imvPlus = bottomSheetOrder.findViewById(R.id.imvPlus);

                TextView txtQuantity = bottomSheetOrder.findViewById(R.id.txtQuantity);

                //EditText edtOrderNote;
                Button btnAddCart = bottomSheetOrder.findViewById(R.id.btnAddCart),
                        btnOrder =bottomSheetOrder.findViewById(R.id.btnOrder);


                btnAddCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TabHostInvoice.this, "Sản phẩm đã được thêm vào giỏ hàng của bạn", Toast.LENGTH_SHORT).show();
                    }
                });

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TabHostInvoice.this, OrderDetails.class);
                        startActivity(intent);
                    }
                });

                imvPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        numberOrder = numberOrder + 1 ;
                        txtQuantity.setText(String.valueOf(numberOrder));
                    }
                });

                imvMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(numberOrder > 1){
                            numberOrder = numberOrder - 1 ;
                        }
                        txtQuantity.setText(String.valueOf(numberOrder));
                    }
                });
                bottomSheetOrder.show();
            }
        });

        btnBuyAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetOrder = new BottomSheetDialog(TabHostInvoice.this);
                bottomSheetOrder.setContentView(R.layout.bottomsheet_order);

                Spinner spinnerWeight = bottomSheetOrder.findViewById(R.id.spinnerWeight);
                weight = new ArrayList<>();
                weight.add("1kg");
                weight.add("5kg");
                weight.add("hộp");
                weight.add("thùng");
                arrayAdapter = new ArrayAdapter<String>(TabHostInvoice.this, android.R.layout.simple_spinner_dropdown_item, weight);
                spinnerWeight.setAdapter(arrayAdapter);

                ImageView imvMinus = bottomSheetOrder.findViewById(R.id.imvMinus),
                        imvPlus = bottomSheetOrder.findViewById(R.id.imvPlus);

                TextView txtQuantity = bottomSheetOrder.findViewById(R.id.txtQuantity);

                //EditText edtOrderNote;
                Button btnAddCart = bottomSheetOrder.findViewById(R.id.btnAddCart),
                        btnOrder =bottomSheetOrder.findViewById(R.id.btnOrder);


                btnAddCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TabHostInvoice.this, "Sản phẩm đã được thêm vào giỏ hàng của bạn", Toast.LENGTH_SHORT).show();
                    }
                });

                btnOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TabHostInvoice.this, OrderDetails.class);
                        startActivity(intent);
                    }
                });

                imvPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        numberOrder = numberOrder + 1 ;
                        txtQuantity.setText(String.valueOf(numberOrder));
                    }
                });

                imvMinus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(numberOrder > 1){
                            numberOrder = numberOrder - 1 ;
                        }
                        txtQuantity.setText(String.valueOf(numberOrder));
                    }
                });
                bottomSheetOrder.show();
            }
        });

        layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabHostInvoice.this, TrackingOrder.class);
                startActivity(intent);
            }
        });

        layoutItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabHostInvoice.this, TrackingOrder.class);
                startActivity(intent);
            }
        });

        layoutItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TabHostInvoice.this, TrackingOrder.class);
                startActivity(intent);
            }
        });
    }
}