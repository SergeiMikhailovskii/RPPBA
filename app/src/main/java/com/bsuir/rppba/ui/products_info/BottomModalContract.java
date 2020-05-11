package com.bsuir.rppba.ui.products_info;

import com.bsuir.rppba.data.entity.Place;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface BottomModalContract {

    interface BottomModalView extends MvpView {

        void onFreeCellsLoaded(List<Place> cells);

        void onFreeCellsFailed();

        void onUnsortedProductMoved();

    }

    interface BottomModalPresenter extends MvpPresenter<BottomModalView> {

        void getFreeCells();

        void moveUnsortedProduct(int productId, int id, int amount);

        void moveSortedProduct(int productId, int cellFrom, int cellTo, int amount);

    }

}
