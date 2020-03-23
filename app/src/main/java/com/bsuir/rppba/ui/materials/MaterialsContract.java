package com.bsuir.rppba.ui.materials;

import com.bsuir.rppba.data.entity.Material;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface MaterialsContract {

    interface MaterialsView extends MvpView {

        void onMaterialsLoaded(List<Material> materials);

        void onMaterialsFailed();

    }

    interface MaterialsPresenter extends MvpPresenter<MaterialsView> {

        void loadMaterialsList();

    }

}
