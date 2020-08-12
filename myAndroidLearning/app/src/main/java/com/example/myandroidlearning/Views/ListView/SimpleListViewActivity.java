package com.example.myandroidlearning.Views.ListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myandroidlearning.R;

import java.util.ArrayList;
import java.util.List;

public class SimpleListViewActivity extends AppCompatActivity {

    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango","Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};
    private ListView simple_list_view, my_simple_list_view;
    private List<myFruit> myFruits = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SimpleListViewActivity.this, android.R.layout.simple_list_item_1, data);
        simple_list_view = (ListView) findViewById(R.id.simple_list_view);
        simple_list_view.setAdapter(adapter);
        my_simple_list_view = (ListView) findViewById(R.id.my_simple_list_view);
        initMyViewHolders();
        mySimpleListViewAdpater adpater2 = new mySimpleListViewAdpater(SimpleListViewActivity.this, R.layout.my_simple_list_view_item, myFruits);
        my_simple_list_view.setAdapter(adpater2);

    }
    private void initMyViewHolders(){
        for(int i = 0; i < data.length; i++){
            myFruit holder = new myFruit(R.drawable.apple, "apple","2020-08-10", "这是一个苹果");
            myFruits.add(holder);
            holder = new myFruit(R.drawable.banana, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
            holder = new myFruit(R.drawable.orange, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
            holder = new myFruit(R.drawable.watermelon, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
            holder = new myFruit(R.drawable.pear, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
            holder = new myFruit(R.drawable.grape, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
            holder = new myFruit(R.drawable.pinneapple, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
            holder = new myFruit(R.drawable.strawberry, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
            holder = new myFruit(R.drawable.cherry, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
            holder = new myFruit(R.drawable.mango, data[i],"2020-08-10", "这是一个 "+data[i]);
            myFruits.add(holder);
        }
    }
}