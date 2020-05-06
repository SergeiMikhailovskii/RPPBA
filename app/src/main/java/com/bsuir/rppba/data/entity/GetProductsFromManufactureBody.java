package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class GetProductsFromManufactureBody {

    private int amount;
    private int price;
    @SerializedName("date_of_manufacture")
    private String dateOfManufacture;
    @SerializedName("receiving_date")
    private String receivingDate;
    private int nomenclature;

    public GetProductsFromManufactureBody(int amount, int price, String dateOfManufacture, String receivingDate, int nomenclature) {
        this.amount = amount;
        this.price = price;
        this.dateOfManufacture = dateOfManufacture;
        this.receivingDate = receivingDate;
        this.nomenclature = nomenclature;
    }

}
