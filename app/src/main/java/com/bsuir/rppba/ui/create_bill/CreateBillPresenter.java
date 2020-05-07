package com.bsuir.rppba.ui.create_bill;

import android.annotation.SuppressLint;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.entity.CreateWaybillBody;
import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CreateBillPresenter extends BasePresenter<CreateBillContract.CreateBillView> implements CreateBillContract.CreateBillPresenter {

    @SuppressLint("NewApi")
    @Override
    public void saveWaybill(String type, int customer, boolean isPassedFirstTest, boolean isPassedSecondTest, List<Integer> stockItems) {
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().createWaybill(
                new CreateWaybillBody(customer, stockItems.stream().mapToInt(i -> i).toArray(), isPassedFirstTest, isPassedSecondTest, type)
        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.onWaybillSaved()));
    }

    @Override
    public void loadClienteles() {
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().getAllClienteles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(clienteles -> view.onClientelesLoaded(clienteles)));
    }

    @Override
    public void getProducts() {
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().getProducts()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(it -> view.showLoadingIndicator(true))
                .flatMapIterable(stockItems -> stockItems)
                .map(this::getStockItem)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(() -> view.showLoadingIndicator(false))
                .subscribe(list -> {
                            view.showLoadingIndicator(false);
                            if (!list.isEmpty()) {
                                view.onProductsLoaded(list);
                            } else {
                                view.onProductsFailed();
                            }
                        }
                ));
    }

    @Override
    public void getMaterials() {
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().getRawMaterials()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(it -> view.showLoadingIndicator(true))
                .flatMapIterable(stockItems -> stockItems)
                .map(this::getStockItem)
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate(() -> view.showLoadingIndicator(false))
                .subscribe(list -> {
                            view.showLoadingIndicator(false);
                            if (!list.isEmpty()) {
                                view.onProductsLoaded(list);
                            } else {
                                view.onProductsFailed();
                            }
                        }
                ));

    }


    private StockItem getStockItem(RawMaterialsResponse rawMaterialsResponse) {
        return new StockItem(rawMaterialsResponse.getImage(),
                rawMaterialsResponse.getNomenclature().getName(),
                rawMaterialsResponse.getNomenclature().getKindOfNomenclature(),
                rawMaterialsResponse.getAmount(),
                rawMaterialsResponse.getId(),
                new ArrayList<>());
    }


}
