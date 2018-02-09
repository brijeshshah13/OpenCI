package com.openci.apicommunicator.models.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vicky on 08-01-2018.
 */

public class ReposDefaultBranch {
    @SerializedName("@type")
    private String mType;

    @SerializedName("@href")
    private String mHREF;

    @SerializedName("@representation")
    private String mRepresentation;

    @SerializedName("name")
    private String mName;

    public String getType() {
        return mType;
    }

    public void setType(String mType) {
        this.mType = mType;
    }

    public String getHREF() {
        return mHREF;
    }

    public void setHREF(String mHREF) {
        this.mHREF = mHREF;
    }

    public String getRepresentation() {
        return mRepresentation;
    }

    public void setRepresentation(String mRepresentation) {
        this.mRepresentation = mRepresentation;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }
}
