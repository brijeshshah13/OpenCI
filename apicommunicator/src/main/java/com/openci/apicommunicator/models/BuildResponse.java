package com.openci.apicommunicator.models;

import com.google.gson.annotations.SerializedName;
import com.openci.apicommunicator.models.submodels.BuildsPermissions;

public class BuildResponse {
    @SerializedName("@type")
    private String mType;

    @SerializedName("@href")
    private String mHREF;

    @SerializedName("@representation")
    private String mRepresentation;

    @SerializedName("@permissions")
    private BuildsPermissions mBuildsPermissions;

    @SerializedName("id")
    private int mID;

    @SerializedName("number")
    private String mNumber;

    @SerializedName("state")
    private String mState;

    @SerializedName("duration")
    private int mDuration;

    @SerializedName("event_type")
    private String mEventType;

    @SerializedName("previous_state")
    private String mPreviousState;

    @SerializedName("pull_request_title")
    private String mPullRequestTitle;

    @SerializedName("pull_request_number")
    private int mPullRequestNumber;

    @SerializedName("started_at")
    private String mStartedAt;

    @SerializedName("finished_at")
    private String mFinishedAt;

    @SerializedName("private")
    private boolean mPrivate;

    @SerializedName("repository")
    private RepoResponse mRepository;

    @SerializedName("tag")
    private String mTag;

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

    public BuildsPermissions getBuildsPermissions() {
        return mBuildsPermissions;
    }

    public void setBuildsPermissions(BuildsPermissions mBuildsPermissions) {
        this.mBuildsPermissions = mBuildsPermissions;
    }

    public int getID() {
        return mID;
    }

    public void setID(int mID) {
        this.mID = mID;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getState() {
        return mState;
    }

    public void setState(String mState) {
        this.mState = mState;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    public String getEventType() {
        return mEventType;
    }

    public void setEventType(String mEventType) {
        this.mEventType = mEventType;
    }

    public String getPreviousState() {
        return mPreviousState;
    }

    public void setPreviousState(String mPreviousState) {
        this.mPreviousState = mPreviousState;
    }

    public String getPullRequestTitle() {
        return mPullRequestTitle;
    }

    public void setPullRequestTitle(String mPullRequestTitle) {
        this.mPullRequestTitle = mPullRequestTitle;
    }

    public int getPullRequestNumber() {
        return mPullRequestNumber;
    }

    public void setPullRequestNumber(int mPullRequestNumber) {
        this.mPullRequestNumber = mPullRequestNumber;
    }

    public String getStartedAt() {
        return mStartedAt;
    }

    public void setStartedAt(String mStartedAt) {
        this.mStartedAt = mStartedAt;
    }

    public String getFinishedAt() {
        return mFinishedAt;
    }

    public void setFinishedAt(String mFinishedAt) {
        this.mFinishedAt = mFinishedAt;
    }

    public boolean isPrivate() {
        return mPrivate;
    }

    public void setPrivate(boolean mPrivate) {
        this.mPrivate = mPrivate;
    }

    public RepoResponse getRepository() {
        return mRepository;
    }

    public void setRepository(RepoResponse mRepository) {
        this.mRepository = mRepository;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String mTag) {
        this.mTag = mTag;
    }
}