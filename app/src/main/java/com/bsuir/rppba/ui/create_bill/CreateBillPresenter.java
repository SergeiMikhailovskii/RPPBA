package com.bsuir.rppba.ui.create_bill;

import android.util.Log;

import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.BasePresenter;

import java.util.List;

public class CreateBillPresenter extends BasePresenter<CreateBillContract.CreateBillView> implements CreateBillContract.CreateBillPresenter {

    @Override
    public void saveWaybill(String type, String customer, String waybillNumber, boolean isPassedFirstTest, boolean isPassedSecondTest, List<StockItem> stockItems) {
        view.showLoadingIndicator(true);
        Log.i(this.getClass().getName(), type + " " + customer + " " + waybillNumber);
        view.showLoadingIndicator(false);
        view.onWaybillSaved();
    }

}
