package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class WaybillResponse {

    private int id;

    @SerializedName("clientele_participant")
    private Clientele clientele;
    private String number;

    @SerializedName("date_of_sending")
    private String dateOfSending;

    @SerializedName("first_check_passed")
    private boolean isFirstCheckPassed;

    @SerializedName("second_check_passed")
    private boolean isSecondCheckPassed;

    @SerializedName("waybill_type")
    private String waybillType;
    private int[] products;

    public WaybillResponse(int id, Clientele clientele, String number, String dateOfSending, boolean isFirstCheckPassed, boolean isSecondCheckPassed, String waybillType, int[] products) {
        this.id = id;
        this.clientele = clientele;
        this.number = number;
        this.dateOfSending = dateOfSending;
        this.isFirstCheckPassed = isFirstCheckPassed;
        this.isSecondCheckPassed = isSecondCheckPassed;
        this.waybillType = waybillType;
        this.products = products;
    }

    public WaybillResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Clientele getClientele() {
        return clientele;
    }

    public void setClientele(Clientele clientele) {
        this.clientele = clientele;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDateOfSending() {
        return dateOfSending;
    }

    public void setDateOfSending(String dateOfSending) {
        this.dateOfSending = dateOfSending;
    }

    public boolean isFirstCheckPassed() {
        return isFirstCheckPassed;
    }

    public void setFirstCheckPassed(boolean firstCheckPassed) {
        this.isFirstCheckPassed = firstCheckPassed;
    }

    public boolean isSecondCheckPassed() {
        return isSecondCheckPassed;
    }

    public void setSecondCheckPassed(boolean secondCheckPassed) {
        isSecondCheckPassed = secondCheckPassed;
    }

    public String getWaybillType() {
        return waybillType;
    }

    public void setWaybillType(String waybillType) {
        this.waybillType = waybillType;
    }

    public int[] getProducts() {
        return products;
    }

    public void setProducts(int[] products) {
        this.products = products;
    }

}
