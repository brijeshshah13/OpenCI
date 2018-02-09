package com.openci.apicommunicator.models.submodels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Vicky on 08-01-2018.
 */

public class Pagination {
    @SerializedName("limit")
    private int mLimit;

    @SerializedName("offset")
    private int mOffset;

    @SerializedName("count")
    private int mCount;

    @SerializedName("is_first")
    private boolean mIsFirst;

    @SerializedName("is_last")
    private boolean mIsLast;

    @SerializedName("next")
    private Limit mNext;

    @SerializedName("prev")
    private Limit mPrev;

    @SerializedName("first")
    private Limit mFirst;

    @SerializedName("last")
    private Limit mLast;

    public int getLimit() {
        return mLimit;
    }

    public void setLimit(int mLimit) {
        this.mLimit = mLimit;
    }

    public int getOffset() {
        return mOffset;
    }

    public void setOffset(int mOffset) {
        this.mOffset = mOffset;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(int mCount) {
        this.mCount = mCount;
    }

    public boolean isIsFirst() {
        return mIsFirst;
    }

    public void setIsFirst(boolean mIsFirst) {
        this.mIsFirst = mIsFirst;
    }

    public boolean isIsLast() {
        return mIsLast;
    }

    public void setIsLast(boolean mIsLast) {
        this.mIsLast = mIsLast;
    }

    public Limit getNext() {
        return mNext;
    }

    public void setNext(Limit mNext) {
        this.mNext = mNext;
    }

    public Limit getPrev() {
        return mPrev;
    }

    public void setPrev(Limit mPrev) {
        this.mPrev = mPrev;
    }

    public Limit getFirst() {
        return mFirst;
    }

    public void setFirst(Limit mFirst) {
        this.mFirst = mFirst;
    }

    public Limit getLast() {
        return mLast;
    }

    public void setLast(Limit mLast) {
        this.mLast = mLast;
    }
}
