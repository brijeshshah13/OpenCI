package com.openci.apicommunicator.models;

import com.google.gson.annotations.SerializedName;
import com.openci.apicommunicator.models.submodels.OrgsPermissions;

/**
 * Created by Vicky on 05-02-2018.
 */

public class OrgResponse {
    @SerializedName("@type")
    private String mType;

    @SerializedName("@href")
    private String mHREF;

    @SerializedName("@representation")
    private String mRepresentation;

    @SerializedName("@permissions")
    private OrgsPermissions mOrgsPermissions;

    @SerializedName("id")
    private int mID;

    @SerializedName("login")
    private String mLoginName;

    @SerializedName("name")
    private String mName;

    // GitHub ID may require larger data-type than int, yet to test
    @SerializedName("github_id")
    private int mGitHubID;

    @SerializedName("avatar_url")
    private String mAvatarURL;

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

    public OrgsPermissions getOrgsPermissions() {
        return mOrgsPermissions;
    }

    public void setOrgsPermissions(OrgsPermissions mOrgsPermissions) {
        this.mOrgsPermissions = mOrgsPermissions;
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getLoginName() {
        return mLoginName;
    }

    public void setLoginName(String mLoginName) {
        this.mLoginName = mLoginName;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public int getGitHubID() {
        return mGitHubID;
    }

    public void setGitHubID(int mGitHubID) {
        this.mGitHubID = mGitHubID;
    }

    public String getAvatarURL() {
        return mAvatarURL;
    }

    public void setAvatarURL(String mAvatarURL) {
        this.mAvatarURL = mAvatarURL;
    }
}
