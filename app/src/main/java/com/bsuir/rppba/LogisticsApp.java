package com.bsuir.rppba;

import android.app.Application;
import android.content.Context;

public class LogisticsApp extends Application {

    public static LogisticsApp instance;
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }

    public static LogisticsApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        instance = this;
    }
}
