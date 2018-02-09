package com.openci.apicommunicator.interfaces;

import com.openci.apicommunicator.models.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by Vicky on 08-01-2018.
 */

public interface IUser {
    @Headers({
            "Travis-API-Version: 3",
            "User-Agent: MyClient/1.0.0"
    })
    @GET("user")
    Call<UserResponse> getUser(@Header("Authorization") String authorization);

    @Headers({
            "Travis-API-Version: 3",
            "User-Agent: MyClient/1.0.0"
    })
    @GET("user/{id}")
    Call<UserResponse> getIndividualUser(@Path("id") int id, @Header("Authorization") String authorization);
}
