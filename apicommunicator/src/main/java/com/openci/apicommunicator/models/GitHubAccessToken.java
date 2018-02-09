package com.openci.apicommunicator.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vicky on 24-12-2017.
 */

public class GitHubAccessToken {
    @SerializedName("access_token")
    private String access_token;

    public String getGitHubAccessToken() {
        return access_token;
    }
}
