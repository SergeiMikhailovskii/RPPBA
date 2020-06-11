package com.bsuir.rppba.ui.products_info;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.entity.MoveSortedProductBody;
import com.bsuir.rppba.data.entity.MoveUnsortedProductBody;
import com.bsuir.rppba.ui.base.BasePresenter;

import io.reactivex.Scheduler;
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

    @Override
    public void moveUnsortedProduct(int productId, int id, int amount) {
        MoveUnsortedProductBody body = new MoveUnsortedProductBody(id, amount);
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().moveUnsortedProduct(productId, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.onUnsortedProductMoved()));
    }

    @Override
    public void moveSortedProduct(int productId, int cellFrom, int cellTo, int amount) {
        MoveSortedProductBody body = new MoveSortedProductBody(cellFrom, cellTo, amount);
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().moveSortedProduct(productId, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.onUnsortedProductMoved()));
    }

}
