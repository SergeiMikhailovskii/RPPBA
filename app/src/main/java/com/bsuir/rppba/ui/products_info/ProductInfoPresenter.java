package com.bsuir.rppba.ui.products_info;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.BasePresenter;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProductInfoPresenter extends BasePresenter<ProductInfoContract.ProductInfoView> implements ProductInfoContract.ProductsInfoPresenters {

    @Override
    public void loadProductInfoList(int id) {
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().getProduct(id)
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(it -> view.showLoadingIndicator(true))
                .map(this::getStockItem)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(product -> {
                    view.showLoadingIndicator(false);
                    view.onProductInfoLoaded(product);
                }));
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
