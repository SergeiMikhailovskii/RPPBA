package com.bsuir.rppba.ui.products;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.BasePresenter;
import com.bsuir.rppba.ui.products.ProductContract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProductPresenter extends BasePresenter<ProductContract.ProductView> implements ProductContract.ProductsPresenter {

    @Override
    public void loadProductsList() {
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
                                ;
                            } else {
                                view.onProductsFailed();
                            }
                        }
                )
        );
    }

    private StockItem getStockItem(RawMaterialsResponse rawMaterialsResponse) {
        // TODO add icon
        return new StockItem("",
                rawMaterialsResponse.getNomenclature().getName(),
                rawMaterialsResponse.getNomenclature().getKindOfNomenclature(),
                rawMaterialsResponse.getAmount(),
                rawMaterialsResponse.getId(),
                new ArrayList<>(Arrays.asList(rawMaterialsResponse.getCell())));
    }

}
