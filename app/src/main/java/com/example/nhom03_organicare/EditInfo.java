package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.adapter.SpinnerAdapter;
import com.example.model.Product;
import com.example.model.UserInfo;

public class EditInfo extends AppCompatActivity{

    String[] districts = {"Quận 1","Quận 2","Quận 3","Quận 4","Quận 5","Quận 6", "Quận 7", "Quận 8", "Quận 9", "Quận 10", "Quận 11", "Quận 12",};

    String[] wards = {"An Khánh", "An Phú", "Hiệp Bình Phước", "Hiệp Bình Chánh", "Linh Chiểu", "Linh Đông", "Linh Tây", "Linh Trung",
    "Linh Xuân", "Thảo Điền", "Trường Thọ", "Long Thạnh Mỹ"};

    int icons[] = {R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2,
            R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2,
            R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2};

    Spinner spDistrict, spWard;
    EditText edtName, edtAddress, edtEmail, edtPhone;
    ImageButton imbBack;
    Button btnConfirm;
    String district, ward, name, address, email, phone;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        linkViews();
        loadData();
        addEvents();
    }

    private void linkViews() {
        spDistrict = findViewById(R.id.spDistrict);
        spWard = findViewById(R.id.spWard);
        imbBack = findViewById(R.id.imbBack);
        btnConfirm = findViewById(R.id.btnConfirm);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
    }

    private void loadData() {

        SpinnerAdapter spinnerAdapter =new SpinnerAdapter(getApplicationContext(), icons, districts, getLayoutInflater());
        spDistrict.setAdapter(spinnerAdapter);


        SpinnerAdapter spinnerAdapter1 = new SpinnerAdapter(getApplicationContext(), icons, wards, getLayoutInflater());
        spWard.setAdapter(spinnerAdapter1);

        spDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                district = spDistrict.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                district = spDistrict.getSelectedItem().toString();
            }
        });

        spWard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ward = spWard.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    private void addEvents() {
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(EditInfo.this, OrderDetails.class);
                startActivity(intent);
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = edtName.getText().toString();
                address = edtAddress.getText().toString();
                email = edtEmail.getText().toString();
                phone = edtPhone.getText().toString();

                UserInfo userInfo = new UserInfo(name, district, ward, address, email, phone);

                intent = new Intent(EditInfo.this, OrderDetails.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("info", userInfo);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}