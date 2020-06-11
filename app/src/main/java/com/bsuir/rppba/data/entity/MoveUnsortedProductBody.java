package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class MoveUnsortedProductBody {

    @SerializedName("new_cell_id")
    private int newCellId;

    private int amount;

    public MoveUnsortedProductBody(int newCellId, int amount) {
        this.newCellId = newCellId;
        this.amount = amount;
    }

    public int getNewCellId() {
        return newCellId;
    }

    public int getAmount() {
        return amount;
    }

}
