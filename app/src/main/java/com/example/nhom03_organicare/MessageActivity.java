package com.example.nhom03_organicare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.adapter.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private EditText edtMessage;
    private Button btnSend;
    private ImageButton imbBackMessage;

    private RecyclerView rcvMessage;
    private MessageAdapter messageAdapter;
    private List<Message> mListMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        linkViews();
        addEvent();

    }

    private void linkViews() {
        edtMessage = findViewById(R.id.edtMessage);
        btnSend = findViewById(R.id.btnSend);
        rcvMessage = findViewById(R.id.rcv_message);
        imbBackMessage = findViewById(R.id.imbBackMessage);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvMessage.setLayoutManager(linearLayoutManager);


        mListMessage = new ArrayList<>();
        messageAdapter = new MessageAdapter();
        messageAdapter.setData(mListMessage);

        rcvMessage.setAdapter(messageAdapter);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String strMessage = edtMessage.getText().toString().trim();
        if(TextUtils.isEmpty(strMessage)){

            return;
        }
        mListMessage.add(new Message(strMessage));
        messageAdapter.notifyDataSetChanged();
        rcvMessage.scrollToPosition(mListMessage.size() - 1);

        edtMessage.setText("");
    }

    private void addEvent() {
        imbBackMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MessageActivity.this, ProductDetails.class);
                startActivity(intent);
            }
        });
    }
}