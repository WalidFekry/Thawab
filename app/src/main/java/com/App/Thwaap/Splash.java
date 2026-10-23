package com.App.Thwaap;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.App.Thwaap.databinding.ActivitySplashBinding;
import com.App.Thwaap.utils.CommonUtils;

public class Splash extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    private static final int SPLASH_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        CommonUtils.setupFullscreen(this);

        ActivitySplashBinding binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            Typeface typeface = Typeface.createFromAsset(getAssets(), "ggg.ttf");
            binding.textth.setTypeface(typeface);
        } catch (Exception e) {
            Log.e(TAG, "Error loading font: " + e.getMessage());
        }

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (!isFinishing() && !isDestroyed()) {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
