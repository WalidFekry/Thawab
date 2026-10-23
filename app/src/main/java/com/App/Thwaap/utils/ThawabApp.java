package com.App.Thwaap.utils;

import android.app.Application;

public class ThawabApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AdManager.getInstance().init(this);
        NotificationUtils.createNotificationChannel(this);
    }
}
