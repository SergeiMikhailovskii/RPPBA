package com.bsuir.rppba.ui.bills;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.entity.Bill;
import com.bsuir.rppba.data.entity.WaybillResponse;
import com.bsuir.rppba.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BillsPresenter extends BasePresenter<BillsContract.BillsView> implements BillsContract.BillsPresenter {

    @Override
    public void loadBills() {
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().getWaybills()
                .subscribeOn(Schedulers.io())
                .flatMapIterable(bills -> bills)
                .map(this::getBills)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(bills -> {
                    view.showLoadingIndicator(false);
                    if (!bills.isEmpty()) {
                        view.onBillsLoaded(bills);
                    } else {
                        view.onBillsFailed();
                    }
                }));
    }

    private Bill getBills(WaybillResponse response) {
        return new Bill(response.getNumber(),
                response.getClientele().getName(),
                response.getWaybillType(),
                (response.isFirstCheckPassed() && response.isSecondCheckPassed()),
                response.getDateOfSending());
    }

}
