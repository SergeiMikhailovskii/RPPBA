package com.bsuir.rppba.ui.create_bill;

import android.util.Log;

import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.BasePresenter;

import java.util.List;

public class CreateBillPresenter extends BasePresenter<CreateBillContract.CreateBillView> implements CreateBillContract.CreateBillPresenter {

    @Override
    public void saveWaybill(String type, String customer, String waybillNumber, boolean isPassedFirstTest, boolean isPassedSecondTest, List<StockItem> stockItems) {
        view.showLoadingIndicator(true);

        for (int i = 0; i < stockItems.size(); i++) {
            if (stockItems.get(i).getName() == null || stockItems.get(i).getAmount() == 0) {
                stockItems.remove(i);
                i--;
            }
        }

        Log.i(getClass().getName(), "Type: " + type);
        Log.i(getClass().getName(), "WaybillNumber: " + waybillNumber);
        Log.i(getClass().getName(), "Is passed first test: " + isPassedFirstTest);
        Log.i(getClass().getName(), "Is passed second test: " + isPassedSecondTest);
        for (StockItem item : stockItems) {
            Log.i(getClass().getName(), "Item: " + item.getName() + ", Amount: " + item.getAmount());
        }
        view.showLoadingIndicator(false);
        view.onWaybillSaved();
    }

}
