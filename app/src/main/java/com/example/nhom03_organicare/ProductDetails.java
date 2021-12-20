package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.ItemSimilarAdapter;
import com.example.adapter.ItemSuggestionAdapter;
import com.example.model.ItemSimilar;
import com.example.model.ItemSuggestion;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class ProductDetails extends AppCompatActivity {

    RecyclerView rcvSimilar;
    ItemSimilarAdapter adapter;

    TextView txtAddToCart;
    private int numberOrder = 1;
    Spinner spinnerWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        linkViews();
        configRecyclerView();
        initData();
    }

    private void linkViews() {

        rcvSimilar = findViewById(R.id.rcvSimilar);

        txtAddToCart = findViewById(R.id.txtAddToCart);

//        spinnerWeight = findViewById(R.id.spinnerWeight);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weight, android.R.layout.simple_spinner_dropdown_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerWeight.setAdapter(adapter);
//
//        spinnerWeight.setOnItemSelectedListener(this);

        //show bottom sheet order
        txtAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetOrder = new BottomSheetDialog(ProductDetails.this);
                bottomSheetOrder.setContentView(R.layout.bottomsheet_order);

                //Spinner spinnerWeight = bottomSheetOrder.findViewById(R.id.spinnerWeight);
                //ImageView imvOrderThumb;
                ImageView imvMinus = bottomSheetOrder.findViewById(R.id.imvMinus),
                        imvPlus = bottomSheetOrder.findViewById(R.id.imvPlus);
                //TextView txtOrderName, txtOrderPrice;
                TextView txtQuantity = bottomSheetOrder.findViewById(R.id.txtQuantity);
                //EditText edtOrderNote;
                Button btnCloseOrder = bottomSheetOrder.findViewById(R.id.btnCloseOrder),
                        btnConfirmOrder =bottomSheetOrder.findViewById(R.id.btnConfirmOrder);

                btnCloseOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(ProductDetails.this, "Sản phẩm đã được thêm vào giỏ hàng của bạn", Toast.LENGTH_SHORT).show();
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
    }

    private void configRecyclerView() {
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rcvSimilar.setLayoutManager(manager);
        rcvSimilar.setHasFixedSize(true);
        rcvSimilar.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        ArrayList<ItemSimilar> itemSimilars = new ArrayList<>();
        itemSimilars.add(new ItemSimilar(R.drawable.tomato,"Cà chua", 50000));
        itemSimilars.add(new ItemSimilar(R.drawable.red_cabbage, "Bắp cải tím", 50000));
        itemSimilars.add(new ItemSimilar(R.drawable.raspberry,"Raspberry", 120000));
        itemSimilars.add(new ItemSimilar(R.drawable.milk_barista,"Sữa Barista", 130000));
        itemSimilars.add(new ItemSimilar(R.drawable.kiwi,"Kiwi", 150000));
        itemSimilars.add(new ItemSimilar(R.drawable.potato,"Khoai tây", 75000));
        itemSimilars.add(new ItemSimilar(R.drawable.apple_rose,"Táo Dazzle", 150000));
        itemSimilars.add(new ItemSimilar(R.drawable.juice_apple,"Nước ép táo", 180000));

        adapter = new ItemSimilarAdapter(getApplicationContext(), itemSimilars);
        rcvSimilar.setAdapter(adapter);
    }
}