package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.adapter.SpinnerAdapter;
import com.example.model.Product;
import com.example.model.UserInfo;

public class EditInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] districts = {"TPHCM - Quận 1","TPHCM - Quận 2","TPHCM - Quận 3","TPHCM - Quận 4","TPHCM - Quận 5","TPHCM - Quận 6",
            "TPHCM - Quận 7", "TPHCM - Quận 8", "TPHCM - Quận 9", "TPHCM - Quận 10", "TPHCM - Quận 11", "TPHCM - Quận 12",};

    String[] wards = {"An Khánh", "An Phú", "Hiệp Bình Phước", "Hiệp Bình Chánh", "Linh Chiểu", "Linh Đông", "Linh Tây", "Linh Trung",
    "Linh Xuân", "Thảo Điền", "Trường Thọ", "Long Thạnh Mỹ"};

    int icons[] = {R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2,
            R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2,
            R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2, R.drawable.ic_baseline_place2};

    Spinner spDistrict, spWard;
    EditText edtName, edtAddress, edtEmail, edtPhone;
    ImageButton imbBack;
    Button btnConfirm;
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
        spDistrict.setOnItemSelectedListener(this);
        SpinnerAdapter spinnerAdapter =new SpinnerAdapter(getApplicationContext(), icons, districts, getLayoutInflater());
        spDistrict.setAdapter(spinnerAdapter);

        spWard.setOnItemSelectedListener(this);
        SpinnerAdapter spinnerAdapter1 = new SpinnerAdapter(getApplicationContext(), icons, wards, getLayoutInflater());
        spWard.setAdapter(spinnerAdapter1);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

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
                String name = edtName.getText().toString();
                String district = spDistrict.getSelectedItem().toString();
                String ward = spWard.getSelectedItem().toString();
                String address = edtAddress.getText().toString();
                String email = edtEmail.getText().toString();
                String phone = edtPhone.getText().toString();

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