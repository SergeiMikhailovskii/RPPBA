package com.bsuir.rppba.ui.manufacture_items;

import android.annotation.SuppressLint;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.entity.GetProductsFromManufactureBody;
import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.data.entity.SendMaterialsToManufactureBody;
import com.bsuir.rppba.ui.base.BasePresenter;
import com.bsuir.rppba.ui.manufacture.ManufactureFragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ManufactureItemsPresenter extends BasePresenter<ManufactureItemsContract.ManufactureItemsView> implements ManufactureItemsContract.ManufactureItemsPresenter {

    @Override
    public void getAvailableProducts(String type) {
        Observable<List<RawMaterialsResponse>> response;
        if (type.equals(ManufactureFragment.GET)) {
            response = LogisticsAPIFactory.getInstance().getAPIService().getProducts();
        } else {
            response = LogisticsAPIFactory.getInstance().getAPIService().getRawMaterials();
        }

        mCompositeDisposable.add(response
                .subscribeOn(Schedulers.io())
                .doOnSubscribe(it -> view.showLoadingIndicator(true))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(materialsResponses -> {
                    view.showLoadingIndicator(false);
                    if (!materialsResponses.isEmpty()) {
                        view.onProductsLoaded(materialsResponses);
                    } else {
                        view.onProductsFailed();
                    }
                }));
    }

    @Override
    public void sendMaterialsToManufacture(int id, int cellId, int amount) {
        SendMaterialsToManufactureBody body = new SendMaterialsToManufactureBody(cellId, amount);
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().sendMaterialsToManufacture(id, body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.onMaterialsSent()));
    }

    @Override
    public void getProductsFromManufacture(int amount, int nomenclature) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        @SuppressLint("SimpleDateFormat") DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(new Date());
        GetProductsFromManufactureBody body = new GetProductsFromManufactureBody(amount, 0, nowAsISO, nowAsISO, nomenclature);
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().getProductsFromManufacture(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.onMaterialsSent()));
    }

    @Override
    public void getNomenclatures() {
        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().getNomenclatures()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(nomenclatures -> view.onNomenclaturesLoaded(nomenclatures)));
    }


}
