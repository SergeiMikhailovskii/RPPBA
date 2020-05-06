package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class SendMaterialsToManufactureBody {

    @SerializedName("cell_id")
    private int cellId;
    private int amount;

    public SendMaterialsToManufactureBody(int cellId, int amount) {
        this.cellId = cellId;
        this.amount = amount;
    }

}
