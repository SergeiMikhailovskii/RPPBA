package com.bsuir.rppba.ui.bills;

import com.bsuir.rppba.data.entity.Bill;
import com.bsuir.rppba.data.entity.Clientele;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface BillsContract {

    interface BillsView extends MvpView {

        void onBillsLoaded(List<Bill> bills);

        void onBillsFailed();

    }

    interface BillsPresenter extends MvpPresenter<BillsView> {

        void loadBills();

    }

}
