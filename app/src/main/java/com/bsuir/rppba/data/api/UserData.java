package com.bsuir.rppba.data.api;

public class UserData {

    private static String token;

    static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        UserData.token = token;
        LogisticsAPIFactory.getInstance().setAuthHeader();
    }

}
