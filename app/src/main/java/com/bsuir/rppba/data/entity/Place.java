package com.bsuir.rppba.data.entity;

public class Place extends Entity {

    private String place;
    private int amount;
    private int maxLimit;

    public Place() {
        this.place = "";
        this.amount = 0;
        this.maxLimit = 0;
    }

    public Place(String place, int amount, int maxLimit) {
        this.place = place;
        this.amount = amount;
        this.maxLimit = maxLimit;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }
}
