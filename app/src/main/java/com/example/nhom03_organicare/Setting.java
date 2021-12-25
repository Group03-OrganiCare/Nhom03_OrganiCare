package com.example.nhom03_organicare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Setting extends AppCompatActivity {
    LinearLayout layoutChangePassword, layoutFAQ,layoutLogout;
    ImageButton imbBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        layoutChangePassword = findViewById(R.id.layoutChangePassword);
        layoutFAQ = findViewById(R.id.layoutFAQ);
        layoutLogout = findViewById(R.id.layoutLogout);
        imbBack = findViewById(R.id.imbBack);
    }

    private void addEvents() {
        layoutChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, ChangePassword.class);
                startActivity(intent);
            }
        });

        layoutFAQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Setting.this, FAQ.class);
                startActivity(intent);
            }
        });
        imbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        layoutLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XacNhanLogOut();
            }
        });
    }

    private void XacNhanLogOut() {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Thông báo !");
        alertBuilder.setMessage("Bạn có muốn đăng xuất ?");

        alertBuilder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Setting.this, AccountFragment.class );
                startActivity(intent);
            }
        });
        alertBuilder.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertBuilder.show();
    }

}