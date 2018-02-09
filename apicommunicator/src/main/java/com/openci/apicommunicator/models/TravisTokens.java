package com.openci.apicommunicator.models;

/**
 * Created by Vicky on 09-01-2018.
 */

public class TravisTokens {
    String publicToken;
    String privateToken;

    public TravisTokens(String publicToken, String privateToken) {
        this.publicToken = publicToken;
        this.privateToken = privateToken;
    }

    public String getPublicToken() {
        return publicToken;
    }

    public String getPrivateToken() {
        return privateToken;
    }
}
