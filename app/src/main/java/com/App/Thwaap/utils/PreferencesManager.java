package com.App.Thwaap.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesManager {
    private static final String PREF_NAME = "masbaha";
    private final SharedPreferences preferences;

    public PreferencesManager(Context context) {
        this.preferences = context.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setMasbahaIndex(int selection, int index) {
        preferences.edit().putInt("index" + selection, index).apply();
    }

    public int getMasbahaIndex(int selection) {
        return preferences.getInt("index" + selection, 0);
    }

    public void clearMasbahaIndex(int selection) {
        preferences.edit().putInt("index" + selection, 0).apply();
    }
}
