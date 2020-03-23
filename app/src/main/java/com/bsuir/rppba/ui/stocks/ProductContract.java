package com.bsuir.rppba.ui.stocks;

import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface ProductContract {

    interface ProductView extends MvpView {

        void onProductsLoaded(List<StockItem> stockItems);

        void onProductsFailed();

    }

    interface ProductsPresenter extends MvpPresenter<ProductView> {

        void loadProductsList();

    }
}
