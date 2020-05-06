package com.bsuir.rppba.ui.manufacture_items;

import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface ManufactureItemsContract {

    interface ManufactureItemsView extends MvpView {

        void onProductsLoaded(List<RawMaterialsResponse> products);

        void onProductsFailed();

        void onMaterialsSent();

        void onMaterialsFailed();

    }

    interface ManufactureItemsPresenter extends MvpPresenter<ManufactureItemsView> {

        void getAvailableProducts(String type);

        void sendMaterialsToManufacture(int id, int cellId, int amount);

    }

}
