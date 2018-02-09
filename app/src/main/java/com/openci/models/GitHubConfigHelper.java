package com.openci.models;

import com.openci.BuildConfig;

/**
 * Created by Vicky on 04-02-2018.
 */

public class GitHubConfigHelper {
    public static String getClientID() {
        return BuildConfig.GITHUB_CLIENT_ID;
    }

    public static String getSecret() {
        return BuildConfig.GITHUB_SECRET;
    }
}
