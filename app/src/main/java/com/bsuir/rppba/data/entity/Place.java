package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class Place extends Entity {

    private int id;
    private String place;
    @SerializedName("actual_size")
    private int actualSize;
    private int size;

    public Place() {
        this.place = "";
        this.actualSize = 0;
        this.size = 0;
    }

    public Place(String place, int actualSize, int size) {
        this.place = place;
        this.actualSize = actualSize;
        this.size = size;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getActualSize() {
        return actualSize;
    }

    public void setActualSize(int actualSize) {
        this.actualSize = actualSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
