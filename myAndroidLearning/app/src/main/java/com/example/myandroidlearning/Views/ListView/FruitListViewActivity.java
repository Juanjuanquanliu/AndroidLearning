package com.example.myandroidlearning.Views.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.myandroidlearning.R;

import java.util.ArrayList;
import java.util.List;

public class FruitListViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list_view);
        initFruits();
        FruitListViewAdapter fruitListViewAdapter = new FruitListViewAdapter(FruitListViewActivity.this, R.layout.fruit_list_view_item, fruitList);
        ListView listView = findViewById(R.id.fruit_list_view);
        listView.setAdapter(fruitListViewAdapter);
    }
    private void initFruits(){
        for(int i = 0; i < 2; i++){
            Fruit holder = new Fruit( "apple",R.drawable.apple);
            fruitList.add(holder);
            holder = new Fruit( "banana",R.drawable.banana);
            fruitList.add(holder);
            holder = new Fruit( "orange",R.drawable.orange);
            fruitList.add(holder);
            holder = new Fruit( "watermelon",R.drawable.watermelon);
            fruitList.add(holder);
            holder = new Fruit( "Pear",R.drawable.pear);
            fruitList.add(holder);
            holder = new Fruit( "Grape",R.drawable.grape);
            fruitList.add(holder);
            holder = new Fruit( "Pineapple",R.drawable.pinneapple);
            fruitList.add(holder);
            holder = new Fruit( "Strawberry",R.drawable.strawberry);
            fruitList.add(holder);
            holder = new Fruit( "Cherry",R.drawable.cherry);
            fruitList.add(holder);
            holder = new Fruit( "Mango",R.drawable.mango);
            fruitList.add(holder);
        }
    }
}
