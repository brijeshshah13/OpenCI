package com.openci.apicommunicator.interfaces;

import com.openci.apicommunicator.models.GitHubAccessToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Vicky on 24-12-2017.
 */

public interface IGitHubClient {
    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    Call<GitHubAccessToken> getAccessToken(
            @Field("client_id") String clientID,
            @Field("client_secret") String clientSecret,
            @Field("code") String code
    );
}
