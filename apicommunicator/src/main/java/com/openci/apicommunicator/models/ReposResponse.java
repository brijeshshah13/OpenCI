package com.openci.apicommunicator.models;

import com.google.gson.annotations.SerializedName;
import com.openci.apicommunicator.models.submodels.Pagination;

import java.util.ArrayList;

/**
 * Created by Vicky on 08-01-2018.
 */

public class ReposResponse {
    @SerializedName("@type")
    private String mType;

    @SerializedName("@href")
    private String mHREF;

    @SerializedName("@representation")
    private String mRepresentation;

    @SerializedName("@pagination")
    private Pagination mPagination;

    @SerializedName("repositories")
    private ArrayList<RepoResponse> mRepositories;

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

    public Pagination getPagination() {
        return mPagination;
    }

    public void setPagination(Pagination mPagination) {
        this.mPagination = mPagination;
    }

    public ArrayList<RepoResponse> getRepositories() {
        return mRepositories;
    }

    public void setRepositories(ArrayList<RepoResponse> mRepositories) {
        this.mRepositories = mRepositories;
    }
}
