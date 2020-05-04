package com.bsuir.rppba.ui.materials;

import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface MaterialContract {

    interface MaterialsView extends MvpView {

        void onMaterialsLoaded(List<StockItem> stockItems);

        void onMaterialsFailed();

    }

    interface MaterialsPresenter extends MvpPresenter<MaterialsView> {

        void loadMaterialsList();

    }

}
