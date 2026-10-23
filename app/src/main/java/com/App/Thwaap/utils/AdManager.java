package com.App.Thwaap.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class AdManager {
    private static final String TAG = "AdManager";
    private static volatile AdManager instance;
    private boolean isInitialized = false;
    private InterstitialAd mInterstitialAd;
    private boolean isLoadingInterstitial = false;

    private AdManager() {}

    public static AdManager getInstance() {
        if (instance == null) {
            synchronized (AdManager.class) {
                if (instance == null) {
                    instance = new AdManager();
                }
            }
        }
        return instance;
    }

    public void init(@NonNull Context context) {
        if (isInitialized) return;
        MobileAds.initialize(context.getApplicationContext(), initializationStatus -> {
            isInitialized = true;
            Log.d(TAG, "AdMob initialized successfully.");
        });
    }

    public void loadBanner(@NonNull AdView adView) {
        try {
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        } catch (Exception e) {
            Log.e(TAG, "Failed to load banner ad: " + e.getMessage());
        }
    }

    public void loadInterstitial(@NonNull Context context, @NonNull String adUnitId) {
        if (isLoadingInterstitial || mInterstitialAd != null) return;

        isLoadingInterstitial = true;
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(context, adUnitId, adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mInterstitialAd = interstitialAd;
                isLoadingInterstitial = false;
                Log.d(TAG, "Interstitial ad loaded successfully.");
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd = null;
                isLoadingInterstitial = false;
                Log.e(TAG, "Interstitial ad failed to load: " + loadAdError.getMessage());
            }
        });
    }

    public void showInterstitial(@NonNull Activity activity) {
        if (activity.isFinishing() || activity.isDestroyed()) return;

        if (mInterstitialAd != null) {
            mInterstitialAd.show(activity);
            mInterstitialAd = null;
        } else {
            Log.d(TAG, "Interstitial ad is not ready yet.");
        }
    }

    public boolean isInterstitialReady() {
        return mInterstitialAd != null;
    }
}
