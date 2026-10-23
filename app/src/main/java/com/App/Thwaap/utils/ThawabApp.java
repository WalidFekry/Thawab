package com.App.Thwaap.utils;

import android.app.Application;

import androidx.appcompat.app.AppCompatDelegate;

public class ThawabApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AdManager.getInstance().init(this);
        NotificationUtils.createNotificationChannel(this);

        PreferencesManager prefs = new PreferencesManager(this);
        if (prefs.isNightMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
