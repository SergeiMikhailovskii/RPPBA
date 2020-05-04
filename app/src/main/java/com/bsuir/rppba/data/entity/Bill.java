package com.bsuir.rppba.data.entity;

public class Bill extends Entity {

    private String billId;
    private String stockItemReceiver;
    private String stockItemSupplier;
    private String type;
    private boolean areChecksPassed;
    private int amount;
    private int price;
    private String date;
    private QualityControl qualityControl;

    public Bill(
            String billId,
            String stockItemReceiver,
            String stockItemSupplier,
            String type,
            boolean areChecksPassed,
            int amount,
            int price,
            String date,
            QualityControl qualityControl
    ) {
        this.billId = billId;
        this.stockItemReceiver = stockItemReceiver;
        this.stockItemSupplier = stockItemSupplier;
        this.type = type;
        this.areChecksPassed = areChecksPassed;
        this.amount = amount;
        this.price = price;
        this.date = date;
        this.qualityControl = qualityControl;
    }

    public Bill() {
    }

    public Bill(String billId, String stockItemSupplier, String type, boolean areChecksPassed, String date) {
        this.billId = billId;
        this.stockItemSupplier = stockItemSupplier;
        this.type = type;
        this.areChecksPassed = areChecksPassed;
        this.date = date;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getStockItemReceiver() {
        return stockItemReceiver;
    }

    public void setStockItemReceiver(String stockItemReceiver) {
        this.stockItemReceiver = stockItemReceiver;
    }

    public String getStockItemSupplier() {
        return stockItemSupplier;
    }

    public void setStockItemSupplier(String stockItemSupplier) {
        this.stockItemSupplier = stockItemSupplier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isAreChecksPassed() {
        return areChecksPassed;
    }

    public void setAreChecksPassed(boolean areChecksPassed) {
        this.areChecksPassed = areChecksPassed;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public QualityControl getQualityControl() {
        return qualityControl;
    }

    public void setQualityControl(QualityControl qualityControl) {
        this.qualityControl = qualityControl;
    }

}
