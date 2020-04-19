package com.openci.data.remote.api

import com.openci.apicommunicator.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface UserService {
    @Headers("Travis-API-Version: 3", "User-Agent: MyClient/1.0.0")
    @GET("user")
    suspend fun getUser(@Header("Authorization") authorization: String?): Response<UserResponse>

    @Headers("Travis-API-Version: 3", "User-Agent: MyClient/1.0.0")
    @GET("user/{id}")
    suspend fun getIndividualUser(
        @Path("id") id: Int,
        @Header("Authorization") authorization: String?
    ): Response<UserResponse>
}