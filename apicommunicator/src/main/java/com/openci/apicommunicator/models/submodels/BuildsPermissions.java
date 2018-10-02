package com.openci.apicommunicator.models.submodels;

import com.google.gson.annotations.SerializedName;

public class BuildsPermissions {
    @SerializedName("read")
    private boolean mRead;

    @SerializedName("cancel")
    private boolean mCancel;

    @SerializedName("restart")
    private boolean mRestart;

    public boolean isRead() {
        return mRead;
    }

    public void setRead(boolean mRead) {
        this.mRead = mRead;
    }

    public boolean isCancel() {
        return mCancel;
    }

    public void setCancel(boolean mCancel) {
        this.mCancel = mCancel;
    }

    public boolean isRestart() {
        return mRestart;
    }

    public void setRestart(boolean mRestart) {
        this.mRestart = mRestart;
    }
}
