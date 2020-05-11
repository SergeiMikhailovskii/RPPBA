package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class MoveSortedProductBody {

    @SerializedName("current_cell_id")
    private int idOld;

    @SerializedName("new_cell_id")
    private int idNew;

    @SerializedName("amount")
    private int amount;

    public MoveSortedProductBody(int idOld, int idNew, int amount) {
        this.idOld = idOld;
        this.idNew = idNew;
        this.amount = amount;
    }

}
