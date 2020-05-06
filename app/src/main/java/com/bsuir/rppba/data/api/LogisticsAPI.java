package com.bsuir.rppba.data.api;

import androidx.annotation.NonNull;

import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.data.entity.WaybillResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LogisticsAPI {

    @GET("/api/product/raw-materials")
    @NonNull
    Observable<List<RawMaterialsResponse>> getRawMaterials();

    @GET("/api/product/products")
    @NonNull
    Observable<List<RawMaterialsResponse>> getRawProducts();

    @GET("/api/waybill")
    @NonNull
    Observable<List<WaybillResponse>> getWaybills();

}
