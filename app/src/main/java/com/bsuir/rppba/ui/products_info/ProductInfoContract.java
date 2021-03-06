package com.bsuir.rppba.ui.products_info;

import com.bsuir.rppba.data.entity.Place;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface ProductInfoContract {
    interface ProductInfoView extends MvpView {
        void onProductInfoLoaded(StockItem stockItem);

        void onProductInfoFailed();
    }

    interface ProductsInfoPresenters extends MvpPresenter<ProductInfoView> {
        void loadProductInfoList(int id);
    }
}
