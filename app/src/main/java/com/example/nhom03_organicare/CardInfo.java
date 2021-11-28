package com.example.nhom03_organicare;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class CardInfo extends AppCompatActivity {

    Button btnCardConfirm, btnScanCard;
    EditText edtCardNumb, edtDate, edtCVV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_info);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnCardConfirm =findViewById(R.id.btnCardConfirm);
        btnScanCard =findViewById(R.id.btnScanCard);
        edtCardNumb =findViewById(R.id.edtCardNumb);
        edtCVV =findViewById(R.id.edtCVV);
        edtDate=findViewById(R.id.edtDate);
    }

    private void addEvents() {
        btnCardConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnScanCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ScanCard();

            }
        });
    }

    private void ScanCard(){
        //Initialize intent integrator
        IntentIntegrator intentIntegrator =new IntentIntegrator(CardInfo.this);
        //Set prompt text
        intentIntegrator.setPrompt("For flash use volume up key");
        //Set beep
        intentIntegrator.setBeepEnabled(true);
        //Lock orientation
        intentIntegrator.setOrientationLocked(true);
        //Set capture activity
        intentIntegrator.setCaptureActivity(Capture.class);
        //Intiate scan
        intentIntegrator.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Initialize intent result
        IntentResult intentResult =IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        //Check codition
        if(intentResult.getContents()!=null){
            //Initialize alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(CardInfo.this);
            //Set title
            builder.setTitle("Kết quả");
            //Set message
            builder.setMessage("Kết quả là " + intentResult.getContents());
            builder.setNegativeButton("Thử lại", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    ScanCard();

                }
            });
            builder.setPositiveButton("Xác Nhận", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            //Show alert dialog
            builder.show();
        }else {
            Toast.makeText(getApplicationContext(),"You scan nothing",Toast.LENGTH_SHORT).show();
        }
    }
}