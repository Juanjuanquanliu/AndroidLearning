package com.example.myandroidlearning.Views.ListView;

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
}
