package com.openci.data.remote.api

import com.openci.models.TravisAccessToken
import com.openci.models.TravisTokenRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TravisAuthService {
    @Headers(
        "Content-Type: application/json",
        "User-Agent: MyClient/1.0.0"
    )
    @POST("auth/github")
    suspend fun getTravisAccessToken(
        @Body travisTokenRequest: TravisTokenRequest?
    ): Response<TravisAccessToken>
}