package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Rate extends AppCompatActivity {
    Button btnRate;
    RatingBar ratingBar;

    int customerRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        btnRate = findViewById(R.id.btnRate);
        ratingBar = findViewById(R.id.ratingBar);

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
                Toast.makeText(Rate.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Rate.this, "Đánh giá của bạn đã được ghi nhận", Toast.LENGTH_SHORT).show();
            }
        });
    }
}