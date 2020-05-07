package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class CreateWaybillBody {

    @SerializedName("clientele_participant")
    private int clienteleParticipant;

    private int[] products;

    @SerializedName("first_check_passed")
    private boolean isFirstCheckPassed;

    @SerializedName("second_check_passed")
    private boolean isSecondCheckPassed;

    @SerializedName("waybill_type")
    private String waybillType;

    public CreateWaybillBody(int clienteleParticipant, int[] products, boolean isFirstCheckPassed, boolean isSecondCheckPassed, String waybillType) {
        this.clienteleParticipant = clienteleParticipant;
        this.products = products;
        this.isFirstCheckPassed = isFirstCheckPassed;
        this.isSecondCheckPassed = isSecondCheckPassed;
        this.waybillType = waybillType;
    }
}
