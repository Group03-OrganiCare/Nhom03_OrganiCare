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

public class ChangePasswordAccount extends AppCompatActivity {

    ImageButton imbBackAcc2;
    EditText edtNewPassword, edtTypePwAgain, edtPresentPassword;
    boolean passwordVisible;
    Button btnChangePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password_account);
        linkViews();
        addEvents();
    }
    private void linkViews() {
        imbBackAcc2 = findViewById(R.id.imbBackAcc2);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtPresentPassword = findViewById(R.id.edtPresentPassword);
        edtTypePwAgain=findViewById(R.id.edtTypePwAgain);
        btnChangePass = findViewById(R.id.btnChangePass);
    }

    private void addEvents() {
        imbBackAcc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePasswordAccount.this, Setting.class);
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

        edtPresentPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=edtPresentPassword.getRight()-edtPresentPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=edtPresentPassword.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            edtPresentPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            //for show password
                            edtPresentPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            //set drawable image here
                            edtPresentPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_eye, 0);
                            //for hide password
                            edtPresentPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        edtPresentPassword.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        edtTypePwAgain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int Right = 2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=edtTypePwAgain.getRight()-edtTypePwAgain.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=edtTypePwAgain.getSelectionEnd();
                        if(passwordVisible){
                            //set drawable image here
                            edtTypePwAgain.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24, 0);
                            //for show password
                            edtTypePwAgain.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else{
                            //set drawable image here
                            edtTypePwAgain.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_eye, 0);
                            //for hide password
                            edtTypePwAgain.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        edtTypePwAgain.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNewPassword.getText().length() == 0 || edtPresentPassword.getText().length() == 0||edtTypePwAgain.getText().length()==0) {
                    Toast.makeText(ChangePasswordAccount.this, "Bạn phải nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(ChangePasswordAccount.this, Account2.class);
                    startActivity(intent);
                }
            }
        });
    }
}