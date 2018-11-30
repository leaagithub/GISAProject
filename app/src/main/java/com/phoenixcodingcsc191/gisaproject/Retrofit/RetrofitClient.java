package com.phoenixcodingcsc191.gisaproject.Retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;
    //192.168.29.111:3000 my cpu local address
    //http://10.0.2.2:3000/ android emulator local server
    //http://100.115.92.205:3000/ chromebook local server
    public static final String API_BASE_URL = "http://192.168.29.111:3000/";
    public static Retrofit getInstance(){
        if (instance == null)
            instance = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        return instance;
    }
}
