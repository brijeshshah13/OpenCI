package com.openci.apicommunicator.models;

import com.google.gson.annotations.SerializedName;
import com.openci.apicommunicator.models.submodels.ReposDefaultBranch;
import com.openci.apicommunicator.models.submodels.ReposOwner;
import com.openci.apicommunicator.models.submodels.ReposPermissions;

/**
 * Created by Vicky on 08-01-2018.
 */

public class RepoResponse {
    @SerializedName("@type")
    private String mType;

    @SerializedName("@href")
    private String mHREF;

    @SerializedName("@representation")
    private String mRepresentation;

    @SerializedName("@permissions")
    private ReposPermissions mReposPermissions;

    @SerializedName("id")
    private int mID;

    @SerializedName("name")
    private String mName;

    @SerializedName("slug")
    private String mSlug;

    @SerializedName("description")
    private String mDescription;

    // Verify the data-type
    @SerializedName("github_language")
    private String mGitHubLanguage;

    @SerializedName("active")
    private boolean mActive;

    @SerializedName("private")
    private boolean mPrivate;

    @SerializedName("owner")
    private ReposOwner mRepoOwner;

    @SerializedName("default_branch")
    private ReposDefaultBranch mReposDefaultBranch;

    @SerializedName("starred")
    private boolean mStarred;

    @SerializedName("last_started_build")
    private BuildResponse mBuildResponse;

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

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String mSlug) {
        this.mSlug = mSlug;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getGitHubLanguage() {
        return mGitHubLanguage;
    }

    public void setGitHubLanguage(String mGitHubLanguage) {
        this.mGitHubLanguage = mGitHubLanguage;
    }

    public boolean isActive() {
        return mActive;
    }

    public void setActive(boolean mActive) {
        this.mActive = mActive;
    }

    public boolean isPrivate() {
        return mPrivate;
    }

    public void setPrivate(boolean mPrivate) {
        this.mPrivate = mPrivate;
    }

    public ReposOwner getRepoOwner() {
        return mRepoOwner;
    }

    public void setRepoOwner(ReposOwner mRepoOwner) {
        this.mRepoOwner = mRepoOwner;
    }

    public ReposDefaultBranch getReposDefualtBranch() {
        return mReposDefaultBranch;
    }

    public void setReposDefualtBranch(ReposDefaultBranch mReposDefualtBranch) {
        this.mReposDefaultBranch = mReposDefualtBranch;
    }

    public boolean isStarred() {
        return mStarred;
    }

    public void setStarred(boolean mStarred) {
        this.mStarred = mStarred;
    }

    public BuildResponse getBuildResponse() {
        return mBuildResponse;
    }

    public void setBuildResponse(BuildResponse mBuildResponse) {
        this.mBuildResponse = mBuildResponse;
    }
}
