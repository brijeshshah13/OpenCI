//package com.openci.data.remote.api
//
//import com.openci.apicommunicator.models.ReposResponse
//import retrofit2.Response
//import retrofit2.http.GET
//import retrofit2.http.Header
//import retrofit2.http.Headers
//import retrofit2.http.Query
//
//interface ReposService {
//    @Headers("Travis-API-Version: 3", "User-Agent: MyClient/1.0.0")
//    @GET("repos")
//    suspend fun getRepos(
//        @Header("Authorization") authorization: String?,
//        @Query("include") include: String?
//    ): Response<ReposResponse>
//}