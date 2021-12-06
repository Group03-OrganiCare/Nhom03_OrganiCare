package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {
    ImageButton imbBackOTP;
    EditText edtNewPassword, edtNewPassword1;
    boolean passwordVisible;
    Button btnConfirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        linkViews();
        addEvents();

    }

    private void linkViews() {
        imbBackOTP = findViewById(R.id.imbBackOTP);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtNewPassword1 = findViewById(R.id.edtNewPassword1);
        btnConfirmPass = findViewById(R.id.btnConfirmPass);
    }

    private void addEvents() {
        imbBackOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePassword.this, OTPActivity.class);
                startActivity(intent);
            }
        });

        edtNewPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=edtNewPassword.getRight()-edtNewPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=edtNewPassword.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            edtNewPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            //for hide password
                            edtNewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            //set drawable image here
                            edtNewPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_eye, 0);
                            //for show password
                            edtNewPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        edtNewPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        edtNewPassword1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=edtNewPassword1.getRight()-edtNewPassword1.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=edtNewPassword1.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            edtNewPassword1.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            //for show password
                            edtNewPassword1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            //set drawable image here
                            edtNewPassword1.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_eye, 0);
                            //for hide password
                            edtNewPassword1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        edtNewPassword1.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        btnConfirmPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNewPassword.getText().length() == 0 || edtNewPassword1.getText().length() == 0) {
                    Toast.makeText(ChangePassword.this, "Bạn phải nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ChangePassword.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}