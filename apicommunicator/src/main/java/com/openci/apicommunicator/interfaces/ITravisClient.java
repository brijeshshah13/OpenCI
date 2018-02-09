package com.openci.apicommunicator.interfaces;

import com.openci.apicommunicator.models.TravisTokenRequest;
import com.openci.apicommunicator.models.TravisAccessToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Vicky on 24-12-2017.
 */

public interface ITravisClient {
    @Headers({
            "Content-Type: application/json",
            "User-Agent: MyClient/1.0.0"
    })
    @POST("auth/github")
    Call<TravisAccessToken> getAccessToken(
            @Body TravisTokenRequest travisTokenRequest
    );
}
