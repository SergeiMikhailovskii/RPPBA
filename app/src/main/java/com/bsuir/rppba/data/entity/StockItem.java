package com.bsuir.rppba.data.entity;

import java.util.List;

public class StockItem extends Entity {

    private String icon;
    private String name;
    private String subName;
    private int amount;
    private List<Place> places;

    public StockItem() {
    }

    public StockItem(String icon, String name, String subName, int amount, List<Place> places) {
        this.icon = icon;
        this.name = name;
        this.subName = subName;
        this.amount = amount;
        this.places = places;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

}
