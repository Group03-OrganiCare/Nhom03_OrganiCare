package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AdjustQuantity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerWeight;
    ImageView imvOrderThumb, imvMinus, imvPlus;
    TextView txtOrderName, txtOrderPrice, txtQuantity;
    EditText edtOrderNote;
    Button btnCloseOrder, btnConfirmOrder;
    private int numberOrder = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_quantity);
        setContentView(R.layout.activity_main);
        linkViews();;
        addEvents();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weight, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWeight.setAdapter(adapter);

        spinnerWeight.setOnItemSelectedListener(this);
    }


    private void linkViews() {
        spinnerWeight = findViewById(R.id.spinnerWeight);

        imvOrderThumb = findViewById(R.id.imvOrderThumb);
        imvMinus = findViewById(R.id.imvMinus);
        imvPlus = findViewById(R.id.imvPlus);

        txtOrderName = findViewById(R.id.txtOrderName);
        txtOrderPrice = findViewById(R.id.txtOrderPrice);
        txtQuantity = findViewById(R.id.txtQuantity);

        edtOrderNote = findViewById(R.id.txtOrderNote);

        btnCloseOrder = findViewById(R.id.btnCloseOrder);
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);
    }

    private void addEvents() {
        btnCloseOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnConfirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdjustQuantity.this, "Sản phẩm đã được thêm vào giỏ hàng của bạn", Toast.LENGTH_SHORT).show();
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
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}