package com.saja.mytask;

import android.app.Application;

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
