package com.bsuir.rppba.ui.manufacture_items;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.ui.base.BasePresenter;
import com.bsuir.rppba.ui.manufacture.ManufactureFragment;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ManufactureItemsPresenter extends BasePresenter<ManufactureItemsContract.ManufactureItemsView> implements ManufactureItemsContract.ManufactureItemsPresenter {

    @Override
    public void getAvailableProducts(String type) {
        Observable<List<RawMaterialsResponse>> response;
        if (type.equals(ManufactureFragment.GET)) {
            response = LogisticsAPIFactory.getInstance().getAPIService().getProducts();
        } else {
            response = LogisticsAPIFactory.getInstance().getAPIService().getRawMaterials();
        }

        mCompositeDisposable.add(response
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(it -> view.showLoadingIndicator(true))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(materialsResponses -> {
                    view.showLoadingIndicator(false);
                    if (!materialsResponses.isEmpty()) {
                        view.onProductsLoaded(materialsResponses);
                    } else {
                        view.onProductsFailed();
                    }
                }));
    }

}
