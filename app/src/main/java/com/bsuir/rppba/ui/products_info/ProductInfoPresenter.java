package com.bsuir.rppba.ui.products_info;

import com.bsuir.rppba.data.entity.Place;
import com.bsuir.rppba.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoPresenter extends BasePresenter<ProductInfoContract.ProductInfoView> implements ProductInfoContract.ProductsInfoPresenters {

    @Override
    public void loadProductInfoList() {
        view.showLoadingIndicator(true);
        List<Place> places = new ArrayList<>();

        places.add(new Place("Unsorted", 100, 1000));
        places.add(new Place("A1", 90, 1000));
        places.add(new Place("A2", 80, 1000));
        places.add(new Place("A3", 70, 1000));
        places.add(new Place("A4", 60, 1000));

        view.showLoadingIndicator(false);
        view.onProductInfoLoaded(places);

    }
}
