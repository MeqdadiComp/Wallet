package com.saja.mytask.application;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class WalletApplication extends Application {
    private static WalletApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static WalletApplication getInstance() {
        return instance;
    }
}
