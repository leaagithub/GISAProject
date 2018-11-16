package com.phoenixcodingcsc191.gisaproject.Retrofit;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface INODEJS {
    @POST("register")
    @FormUrlEncoded
    Observable<String> registerUser(
                                @Field("eid") String eid,
                                @Field("fname") String fname,
                                @Field("lname") String lname,
                                @Field("phoneno") String phoneno,
                                @Field("password") String password,
                                @Field("email") String email);
    @POST("login")
    @FormUrlEncoded
    Observable<String> loginUser(@Field("eid") String eid,
                                 @Field("password") String password);
}
