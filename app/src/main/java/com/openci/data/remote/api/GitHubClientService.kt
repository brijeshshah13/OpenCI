package com.openci.data.remote.api

import com.openci.apicommunicator.models.GitHubAccessToken
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface GitHubClientService {
    @Headers("Accept: application/json")
    @POST("login/oauth/access_token")
    @FormUrlEncoded
    suspend fun getAccessToken(
        @Field("client_id") clientID: String?,
        @Field("client_secret") clientSecret: String?,
        @Field("code") code: String?
    ): Response<GitHubAccessToken>
}