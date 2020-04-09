package com.bsuir.rppba.ui.productsinfo;

import com.bsuir.rppba.data.entity.Place;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface ProductInfoContract {
    interface ProductInfoView extends MvpView {
        void onProductInfoLoaded(List<Place> places);
        void onProductInfoFailed();
    }

    interface ProductsInfoPresenters extends MvpPresenter<ProductInfoView>{
        void loadProductInfoList();
    }
}
