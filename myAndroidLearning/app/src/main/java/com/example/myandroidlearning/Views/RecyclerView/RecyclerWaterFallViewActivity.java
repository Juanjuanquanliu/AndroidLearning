package com.example.myandroidlearning.Views.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.Views.ListView.Fruit.Fruit;

import java.util.List;

import static com.example.myandroidlearning.Views.ListView.Fruit.Fruit.initRandomFruits;

public class RecyclerWaterFallViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_water_fall_view);
        List<Fruit> fruitList = initRandomFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.waterfall_recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //适配器
        FruitRecyclerViewAdapter fruitRecyclerViewAdapter = new FruitRecyclerViewAdapter(fruitList);
        recyclerView.setAdapter(fruitRecyclerViewAdapter);
    }
}