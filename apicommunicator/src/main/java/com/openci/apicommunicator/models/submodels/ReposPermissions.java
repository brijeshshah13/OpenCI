package com.openci.apicommunicator.models.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vicky on 08-01-2018.
 */

public class ReposPermissions {
    @SerializedName("read")
    private boolean mRead;

    @SerializedName("admin")
    private boolean mAdmin;

    @SerializedName("activate")
    private boolean mActivate;

    @SerializedName("deactivate")
    private boolean mDeactivate;

    @SerializedName("star")
    private boolean mStar;

    @SerializedName("unstar")
    private boolean mUnstar;

    @SerializedName("create_cron")
    private boolean mCreateCron;

    @SerializedName("create_env_var")
    private boolean mCreateEnvVar;

    @SerializedName("create_key_pair")
    private boolean mCreateKeyPair;

    @SerializedName("delete_key_pair")
    private boolean mDeleteKeyPair;

    @SerializedName("create_request")
    private boolean mCreateRequest;

    public boolean isRead() {
        return mRead;
    }

    public void setRead(boolean mRead) {
        this.mRead = mRead;
    }

    public boolean isAdmin() {
        return mAdmin;
    }

    public void setAdmin(boolean mAdmin) {
        this.mAdmin = mAdmin;
    }

    public boolean isActivate() {
        return mActivate;
    }

    public void setActivate(boolean mActivate) {
        this.mActivate = mActivate;
    }

    public boolean isDeactivate() {
        return mDeactivate;
    }

    public void setDeactivate(boolean mDeactivate) {
        this.mDeactivate = mDeactivate;
    }

    public boolean isStar() {
        return mStar;
    }

    public void setStar(boolean mStar) {
        this.mStar = mStar;
    }

    public boolean isUnstar() {
        return mUnstar;
    }

    public void setUnstar(boolean mUnstar) {
        this.mUnstar = mUnstar;
    }

    public boolean isCreateCron() {
        return mCreateCron;
    }

    public void setCreateCron(boolean mCreateCron) {
        this.mCreateCron = mCreateCron;
    }

    public boolean isCreateEnvVar() {
        return mCreateEnvVar;
    }

    public void setCreateEnvVar(boolean mCreateEnvVar) {
        this.mCreateEnvVar = mCreateEnvVar;
    }

    public boolean isCreateKeyPair() {
        return mCreateKeyPair;
    }

    public void setCreateKeyPair(boolean mCreateKeyPair) {
        this.mCreateKeyPair = mCreateKeyPair;
    }

    public boolean isDeleteKeyPair() {
        return mDeleteKeyPair;
    }

    public void setDeleteKeyPair(boolean mDeleteKeyPair) {
        this.mDeleteKeyPair = mDeleteKeyPair;
    }

    public boolean isCreateRequest() {
        return mCreateRequest;
    }

    public void setCreateRequest(boolean mCreateRequest) {
        this.mCreateRequest = mCreateRequest;
    }
}
