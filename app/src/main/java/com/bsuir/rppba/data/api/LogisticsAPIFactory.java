package com.bsuir.rppba.data.api;

import androidx.annotation.NonNull;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LogisticsAPIFactory {

    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";

    private static final String BASE_URL = "https://53fbdef4.ngrok.io";

    private static LogisticsAPIFactory instance;

    private Retrofit retrofit;

    private LogisticsAPIFactory() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(loggingInterceptor);

        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request requestBuilder = original.newBuilder()
                    .header(CONTENT_TYPE_HEADER, CONTENT_TYPE_VALUE)
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(requestBuilder);
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @NonNull
    public static LogisticsAPIFactory getInstance() {
        if (instance == null) {
            instance = new LogisticsAPIFactory();
        }
        return instance;
    }

    @NonNull
    public LogisticsAPI getAPIService() {
        return retrofit.create(LogisticsAPI.class);
    }


}
