package com.openci.apicommunicator.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vicky on 24-12-2017.
 */

public class TravisAccessToken {
    @SerializedName("access_token")
    private String access_token;

    public String getTravisAccessToken() {
        return access_token;
    }
}
