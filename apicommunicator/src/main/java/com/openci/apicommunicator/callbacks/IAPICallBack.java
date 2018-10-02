package com.openci.apicommunicator.callbacks;

import androidx.annotation.NonNull;

/**
 * Created by Vicky on 06-01-2018.
 */

public interface IAPICallBack<T> {
    void onSuccess(@NonNull T value);

    void onError(@NonNull String errorMessage);
}
