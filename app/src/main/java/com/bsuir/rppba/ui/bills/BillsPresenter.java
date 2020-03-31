package com.bsuir.rppba.ui.bills;

import com.bsuir.rppba.data.entity.Bill;
import com.bsuir.rppba.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class BillsPresenter extends BasePresenter<BillsContract.BillsView> implements BillsContract.BillsPresenter {

    @Override
    public void loadBills() {
        view.showLoadingIndicator(true);

        List<Bill> bills = new ArrayList<>();

        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, 12345));

        view.showLoadingIndicator(false);
        view.onBillsLoaded(bills);
    }

}
