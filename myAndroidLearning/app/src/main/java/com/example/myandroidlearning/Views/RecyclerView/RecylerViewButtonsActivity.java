package com.example.myandroidlearning.Views.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.Views.RecyclerView.ChatBox.ChatBoxActivity;

public class RecylerViewButtonsActivity extends AppCompatActivity {
    private Button simple_recycle_view_btn, fruit_recycle_view_btn, waterfall_recycler_view_btn,grid_recycler_view_btn,chat_box_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view_buttons);
        simple_recycle_view_btn = (Button) findViewById(R.id.vertical_recycler_view_btn);
        fruit_recycle_view_btn = (Button) findViewById(R.id.fruit_recycler_view_btn);
        waterfall_recycler_view_btn = (Button) findViewById(R.id.waterfall_recycler_view_btn);
        grid_recycler_view_btn = (Button) findViewById(R.id.grid_recycler_view_btn);
        chat_box_btn = (Button) findViewById(R.id.chat_box_btn);
        simple_recycle_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecylerViewButtonsActivity.this, RecyclerVerticalViewActivity.class);
                startActivity(intent);
            }
        });
        fruit_recycle_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecylerViewButtonsActivity.this, RecyclerHorizentalViewActivity.class);
                startActivity(intent);
            }
        });
        waterfall_recycler_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecylerViewButtonsActivity.this, RecyclerWaterFallViewActivity.class);
                startActivity(intent);
            }
        });
        grid_recycler_view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecylerViewButtonsActivity.this, RecyclerGridViewActivity.class);
                startActivity(intent);
            }
        });
        chat_box_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecylerViewButtonsActivity.this, ChatBoxActivity.class);
                startActivity(intent);
            }
        });

    }
}