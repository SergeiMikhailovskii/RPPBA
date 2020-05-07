package com.bsuir.rppba.ui.create_bill;

import com.bsuir.rppba.data.entity.Clientele;
import com.bsuir.rppba.data.entity.StockItem;
import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

import java.util.List;

public interface CreateBillContract {

    interface CreateBillView extends MvpView {

        void onWaybillSaved();

        void onWaybillFailed();

        void onClientelesLoaded(List<Clientele> clienteles);

        void onClientelesFailed();

        void onProductsLoaded(List<StockItem> products);

        void onProductsFailed();

    }

    interface CreateBillPresenter extends MvpPresenter<CreateBillView> {

        void saveWaybill(
                String type,
                int customer,
                boolean isPassedFirstTest,
                boolean isPassedSecondTest,
                List<Integer> stockItems
        );

        void loadClienteles();

        void getProducts();

    }

}
