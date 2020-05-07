package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class RawMaterialsResponse {

    private int id;
    private Place[] cell;
    private int amount;
    private double price;
    private Nomenclature nomenclature;
    private String image;

    @SerializedName("date_of_manufacture")
    private String dateOfManufacture;

    @SerializedName("receiving_date")
    private String receivingDate;

    public RawMaterialsResponse(int id, Place[] cell, int amount, double price, String dateOfManufacture, String receivingDate, Nomenclature nomenclature) {
        this.id = id;
        this.cell = cell;
        this.amount = amount;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.receivingDate = receivingDate;
        this.nomenclature = nomenclature;
    }

    public RawMaterialsResponse() {
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Place[] getCell() {
        return cell;
    }

    public void setCell(Place[] cell) {
        this.cell = cell;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(String receivingDate) {
        this.receivingDate = receivingDate;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

}
