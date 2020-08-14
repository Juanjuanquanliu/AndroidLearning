package com.example.myandroidlearning.Views.ListView.Fruit;

import com.example.myandroidlearning.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fruit {
    public String name;
    public int imgId;

    public Fruit(String name, int imgId) {
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }
    public int getImgId() {
        return imgId;
    }
    public static List<Fruit> initFruits(){
        List<Fruit> fruitList = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            Fruit holder = new Fruit( "apple", R.drawable.apple);
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
        return  fruitList;
    }

    public static List<Fruit> initRandomFruits(){
        List<Fruit> fruitList = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            Fruit holder = new Fruit( getRandomLengthName("apple"), R.drawable.apple);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("banana"),R.drawable.banana);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("orange"),R.drawable.orange);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("watermelon"),R.drawable.watermelon);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("Pear"),R.drawable.pear);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("Grape"),R.drawable.grape);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("Pineapple"),R.drawable.pinneapple);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("Strawberry"),R.drawable.strawberry);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("Cherry"),R.drawable.cherry);
            fruitList.add(holder);
            holder = new Fruit( getRandomLengthName("Mango"),R.drawable.mango);
            fruitList.add(holder);
        }
        return  fruitList;
    }

    private static String getRandomLengthName(String Name){
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < length; i++){
            builder.append(Name);
        }
        return builder.toString();
    }
}
