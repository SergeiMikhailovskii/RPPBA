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

        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", false, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", false, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", false, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "Out", true, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "In", true, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "In", true, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "In", true, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "In", true, Long.parseLong("1585669457430")));
        bills.add(new Bill("BY12345/12341", "Government Transfer", "In", true, Long.parseLong("1585669457430")));

        view.showLoadingIndicator(false);
        view.onBillsLoaded(bills);
    }

}
