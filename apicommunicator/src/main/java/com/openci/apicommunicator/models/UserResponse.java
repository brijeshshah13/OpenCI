package com.openci.apicommunicator.models;

import com.google.gson.annotations.SerializedName;
import com.openci.apicommunicator.models.submodels.UserPermissions;

/**
 * Created by Vicky on 08-01-2018.
 */

public class UserResponse {
    @SerializedName("@type")
    private String mType;

    @SerializedName("@href")
    private String mHREF;

    @SerializedName("@representation")
    private String mRepresentation;

    @SerializedName("@permissions")
    private UserPermissions mUserPermissions;

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

    @SerializedName("is_syncing")
    private boolean mIsSyncing;

    @SerializedName("synced_at")
    private String mSyncedAt;

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

    public UserPermissions getUserPermissions() {
        return mUserPermissions;
    }

    public void setUserPermissions(UserPermissions mUserPermissions) {
        this.mUserPermissions = mUserPermissions;
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

    public boolean isIsSyncing() {
        return mIsSyncing;
    }

    public void setIsSyncing(boolean mIsSyncing) {
        this.mIsSyncing = mIsSyncing;
    }

    public String getSyncedAt() {
        return mSyncedAt;
    }

    public void setSyncedAt(String mSyncedAt) {
        this.mSyncedAt = mSyncedAt;
    }
}