package com.bsuir.rppba.ui.productsinfo;

import com.bsuir.rppba.R;
import com.bsuir.rppba.data.entity.Place;
import com.bsuir.rppba.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoPresenter extends BasePresenter<ProductInfoContract.ProductInfoView> implements ProductInfoContract.ProductsInfoPresenters {

    @Override
    public void loadProductInfoList() {
        view.showLoadingIndicator(true);
        List<Place> places = new ArrayList<>();

        places.add(new Place("Unsorted", R.integer.A100, R.integer.MaxLimit));
        places.add(new Place("A1", R.integer.A90, R.integer.MaxLimit));
        places.add(new Place("A2", R.integer.A80, R.integer.MaxLimit));
        places.add(new Place("A3", R.integer.A70, R.integer.MaxLimit));
        places.add(new Place("A4", R.integer.A60, R.integer.MaxLimit));

        view.showLoadingIndicator(false);
        view.onProductInfoLoaded(places);

    }
}
