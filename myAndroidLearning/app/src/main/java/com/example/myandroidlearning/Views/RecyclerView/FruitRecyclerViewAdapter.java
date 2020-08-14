package com.example.myandroidlearning.Views.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myandroidlearning.R;
import com.example.myandroidlearning.Views.ListView.Fruit.Fruit;

import java.util.List;

public class FruitRecyclerViewAdapter extends RecyclerView.Adapter<FruitRecyclerViewAdapter.ViewHolder>{
    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImg;
        TextView fruitName;
        public ViewHolder(View view){
            super(view);
            fruitView = view;
            fruitImg = (ImageView) view.findViewById(R.id.fruit_img);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }

    };
    private List<Fruit> myFruitList;
    public FruitRecyclerViewAdapter(List<Fruit> fruitList){
        myFruitList = fruitList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_view_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = myFruitList.get(position);
                Toast.makeText(view.getContext(), "RecyclerView点击测试. 你点击了View: " + fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.fruitImg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = myFruitList.get(position);
                Toast.makeText(view.getContext(), "RecyclerView点击测试. 你点击了Image: " + fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = myFruitList.get(position);
        holder.fruitImg.setImageResource(fruit.getImgId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return myFruitList.size();
    }


}
