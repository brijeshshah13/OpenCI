package com.openci.apicommunicator.models.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vicky on 08-01-2018.
 */

public class ReposOwner {
    @SerializedName("@type")
    private String mType;

    @SerializedName("id")
    private int mId;

    @SerializedName("login")
    private String mLoginName;

    @SerializedName("@href")
    private String mHREF;

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public String getLoginName() {
        return mLoginName;
    }

    public void setLoginName(String mLoginName) {
        this.mLoginName = mLoginName;
    }

    public String getHREF() {
        return mHREF;
    }

    public void setHREF(String mHREF) {
        this.mHREF = mHREF;
    }
}
