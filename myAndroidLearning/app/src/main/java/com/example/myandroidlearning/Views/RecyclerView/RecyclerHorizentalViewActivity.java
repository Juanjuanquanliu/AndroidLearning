package com.example.myandroidlearning.Views.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.Views.ListView.Fruit.Fruit;

import java.util.List;

import static com.example.myandroidlearning.Views.ListView.Fruit.Fruit.initFruits;

public class RecyclerHorizentalViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_horizental_view);
        List<Fruit> fruitList = initFruits();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fruit_horizontal_recycle_view);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitRecyclerViewAdapter fruitRecyclerViewAdapter = new FruitRecyclerViewAdapter(fruitList);
        recyclerView.setAdapter(fruitRecyclerViewAdapter);

    }
}