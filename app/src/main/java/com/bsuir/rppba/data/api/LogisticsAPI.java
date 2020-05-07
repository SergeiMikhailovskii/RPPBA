package com.bsuir.rppba.data.api;

import androidx.annotation.NonNull;

import com.bsuir.rppba.data.entity.Clientele;
import com.bsuir.rppba.data.entity.CreateWaybillBody;
import com.bsuir.rppba.data.entity.GetProductsFromManufactureBody;
import com.bsuir.rppba.data.entity.LoginUserBody;
import com.bsuir.rppba.data.entity.LoginUserResponse;
import com.bsuir.rppba.data.entity.Nomenclature;
import com.bsuir.rppba.data.entity.RawMaterialsResponse;
import com.bsuir.rppba.data.entity.SendMaterialsToManufactureBody;
import com.bsuir.rppba.data.entity.WaybillResponse;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LogisticsAPI {

    @GET("/api/product/raw-materials")
    @NonNull
    Observable<List<RawMaterialsResponse>> getRawMaterials();

    @GET("/api/waybill")
    @NonNull
    Observable<List<WaybillResponse>> getWaybills();

    @GET("/api/product/products")
    @NonNull
    Observable<List<RawMaterialsResponse>> getProducts();

    @POST("/api/product/{id}/send-materials-to-manufacture")
    Completable sendMaterialsToManufacture(@Path("id") int id, @Body SendMaterialsToManufactureBody body);

    @POST("/api/product/create-product")
    Completable getProductsFromManufacture(@Body GetProductsFromManufactureBody body);

    @GET("/api/nomenclature")
    Observable<List<Nomenclature>> getNomenclatures();

    @POST("/api/user/login")
    @NonNull
    Single<LoginUserResponse> loginUser(@Body LoginUserBody body);

    @GET("/api/clientele")
    @NonNull
    Observable<List<Clientele>> getAllClienteles();

    @POST("/api/waybill/create-waybill")
    @NonNull
    Completable createWaybill(@Body CreateWaybillBody body);

    @GET("/api/product/{id}")
    @NonNull
    Single<RawMaterialsResponse> getProduct(@Path("id") int id);

}
