package com.bsuir.rppba.ui.products_info;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class BottomModalPresenter extends BasePresenter<BottomModalContract.BottomModalView> implements BottomModalContract.BottomModalPresenter {

    @Override
    public void getFreeCells() {
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().getEmptyCells()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cells -> view.onFreeCellsLoaded(cells)));
    }

}
