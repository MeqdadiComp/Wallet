package com.saja.mytask.application;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class WalletApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
