//package com.openci.data.remote.api
//
//import com.openci.apicommunicator.models.OrgResponse
//import retrofit2.Response
//import retrofit2.http.GET
//import retrofit2.http.Header
//import retrofit2.http.Headers
//import retrofit2.http.Path
//
//interface OrgsService {
//    @Headers("Travis-API-Version: 3", "User-Agent: MyClient/1.0.0")
//    @GET("org/{id}")
//    suspend fun getIndividualOrg(
//        @Path("id") id: Int,
//        @Header("Authorization") authorization: String?
//    ): Response<OrgResponse>
//}