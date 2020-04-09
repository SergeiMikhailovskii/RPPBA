package com.bsuir.rppba.ui.create_bill;

import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface CreateBillContract {

    interface CreateBillView extends MvpView {

        void onWaybillSaved();

        void onWaybillFailed();

    }

    interface CreateBillPresenter extends MvpPresenter<CreateBillView> {

        void saveWaybill(
                String type,
                String customer,
                String waybillNumber,
                boolean isPassedFirstTest,
                boolean isPassedSecondTest,
                List<StockItem> stockItems
        );

    }

}
