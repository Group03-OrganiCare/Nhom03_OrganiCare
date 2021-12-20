package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.adapter.DeliveringAdapter;
import com.example.model.Delivering;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class item_layout_delivered extends AppCompatActivity {

    Button btnRate;
    ListView lvDelivered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_layout_delivered);


        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnRate = findViewById(R.id.btnOpenRateBtS1);

        lvDelivered = findViewById(R.id.lvDelivered);
    }

    private void addEvents() {




        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetRate = new BottomSheetDialog(item_layout_delivered.this);
                bottomSheetRate.setContentView(R.layout.bottomsheet_rate);
                bottomSheetRate.setCanceledOnTouchOutside(false);

                Button btnRate = bottomSheetRate.findViewById(R.id.btnRate);
                RatingBar ratingBar = bottomSheetRate.findViewById(R.id.ratingBar);

                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                        int rating = (int) v;
                        String message = null;

                        int customerRating = (int) ratingBar.getRating();
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
                        Toast.makeText(item_layout_delivered.this, message, Toast.LENGTH_SHORT).show();
                    }
                });
                bottomSheetRate.show();
            }
        });
    }
}