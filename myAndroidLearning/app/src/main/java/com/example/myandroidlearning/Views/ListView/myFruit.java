package com.example.myandroidlearning.Views.ListView;

public class myFruit {

    public myFruit(int imageId, String simTitle, String simDate, String simContent) {
        this.imageId = imageId;
        this.simTitle = simTitle;
        this.simDate = simDate;
        this.simContent = simContent;
    }

    public int getImageId() {
        return imageId;
    }

    public String getSimTitle() {
        return simTitle;
    }

    public String getSimDate() {
        return simDate;
    }

    public String getSimContent() {
        return simContent;
    }

    private int imageId;
    private String simTitle, simDate, simContent;
}
