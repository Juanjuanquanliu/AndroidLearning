package com.example.myandroidlearning.Views.ListView.Fruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myandroidlearning.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.myandroidlearning.Views.ListView.Fruit.Fruit.initFruits;

public class FruitListViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list_view);
        fruitList = initFruits();
        final FruitListViewAdapter fruitListViewAdapter = new FruitListViewAdapter(FruitListViewActivity.this, R.layout.fruit_view_item, fruitList);
        ListView listView = findViewById(R.id.fruit_list_view);
        listView.setAdapter(fruitListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(FruitListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
