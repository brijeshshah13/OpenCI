package com.openci;

/**
 * Created by Vicky on 14-02-2018.
 */

import com.openci.apicommunicator.models.LibApp;

/**
 * Base class for those who need to maintain global application state.
 */
public class App extends LibApp {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
