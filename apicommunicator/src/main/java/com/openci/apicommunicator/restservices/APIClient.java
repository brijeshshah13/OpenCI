package com.openci.apicommunicator.restservices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Vicky on 08-01-2018.
 */

public class APIClient {
    public static final String PUBLIC_BASE_URL = "https://api.travis-ci.org/";
    public static final String PRIVATE_BASE_URL = "https://api.travis-ci.com/";
    private static Retrofit publicRetroFit = null;
    private static Retrofit privateRetroFit = null;

    public static Retrofit getPublicClient() {
        if (publicRetroFit == null) {
            publicRetroFit = new Retrofit.Builder()
                    .baseUrl(PUBLIC_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return publicRetroFit;
    }

    public static Retrofit getPrivateClient(){
        if (privateRetroFit == null) {
            privateRetroFit = new Retrofit.Builder()
                    .baseUrl(PRIVATE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return privateRetroFit;
    }
}
