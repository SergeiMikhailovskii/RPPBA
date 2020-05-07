package com.bsuir.rppba.ui.materials;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.BasePresenter;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MaterialPresenter extends BasePresenter<MaterialContract.MaterialsView> implements MaterialContract.MaterialsPresenter {

    @Override
    public void loadMaterialsList() {
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
                                view.onMaterialsLoaded(list);
                            } else {
                                view.onMaterialsFailed();
                            }
                        }
                )
        );
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
