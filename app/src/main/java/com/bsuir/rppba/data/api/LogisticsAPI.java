package com.bsuir.rppba.data.api;

import androidx.annotation.NonNull;

import com.bsuir.rppba.data.entity.RawMaterialsResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LogisticsAPI {

    @GET("/api/product/raw-materials")
    @NonNull
    Observable<List<RawMaterialsResponse>> getRawMaterials();

}
