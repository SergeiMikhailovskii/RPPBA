package com.bsuir.rppba.data.entity;

// https://s3-alpha-sig.figma.com/img/1cb3/405d/dab11e460d0789dcd17b6da0a9d3792f?Expires=1586736000&Signature=BSUeZgcrzwRK5ku8G7S9y6UqE0idIYfdWrIHcGenDYYYVAsjkRV28Gd3xheBKEc9rtAtaHfOl6djoBFnuNgZQmNh640UC976z2Vafxkq8IyXuNBwi3-qyNgFwzXY4nQKyPowS3QZlKuVx3wzlbKjZrD0lgSt8FXhS7xegJIjzoQqOzMMjdhX9KfU3njAOEvy4jI9cGc4AJuWStL7etvyrL9F~UBqD84NY5W6muY-moLpGkuLVjUqAvXc2qHpXufDVVO90l0CfQczGXxnw5S91a0EcDWjWKamnYX5FLJycTteq8u4LJQbt75fN0fqu3QdkSztAGN1qwGK4ZsKPEaEUg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA
// https://s3-alpha-sig.figma.com/img/f0fa/ec1e/7c44a75a6ee9b1dbc7b4f616088e6ea1?Expires=1586736000&Signature=SxbR4V3hCqUL7jlSWqN~vur0nSOG0ZiLL3EuBQ3YXnmdwe-17l2b8OdwZ--j0hOjG-882IrNpnjeGFiBHJD00dB-qdAXGSArDpsIvRbHMWVpKcZHnOQyrwm7ZiejzY06TCShtYpanYn1w7KlGpI4aifPa7ji72DAKXHvpeApqOEfFksL1pSDrtv9x5~9FWjNwLU6Pt-O4pVCdk7Xy4HAfiYhrEO9a7BDxGy3O5aBTw6SX64Sg8KdkUwJYS0KMUe3VOny24r6Dd4TNS-nNv995-g6BEXK1nXK-45zYm2mzg68wTxBgdt~aV-5vy59poFe4v~G-bKtFsYEBthfzJe7Fg__&Key-Pair-Id=APKAINTVSUGEWH5XD5UA

public class Bill extends Entity {

    private String billId;
    private String stockItemReceiver;
    private String stockItemSupplier;
    private String type;
    private boolean isBillInProgress;
    private int amount;
    private int price;
    private long date;
    private QualityControl qualityControl;

    public Bill(
            String billId,
            String stockItemReceiver,
            String stockItemSupplier,
            String type,
            boolean isBillInProgress,
            int amount,
            int price,
            long date,
            QualityControl qualityControl
    ) {
        this.billId = billId;
        this.stockItemReceiver = stockItemReceiver;
        this.stockItemSupplier = stockItemSupplier;
        this.type = type;
        this.isBillInProgress = isBillInProgress;
        this.amount = amount;
        this.price = price;
        this.date = date;
        this.qualityControl = qualityControl;
    }

    public Bill() {
    }

    public Bill(String billId, String stockItemSupplier, String type, boolean isBillInProgress, long date) {
        this.billId = billId;
        this.stockItemSupplier = stockItemSupplier;
        this.type = type;
        this.isBillInProgress = isBillInProgress;
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

    public boolean isBillInProgress() {
        return isBillInProgress;
    }

    public void setBillInProgress(boolean billInProgress) {
        isBillInProgress = billInProgress;
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public QualityControl getQualityControl() {
        return qualityControl;
    }

    public void setQualityControl(QualityControl qualityControl) {
        this.qualityControl = qualityControl;
    }

}
