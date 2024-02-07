package com.App.Thwaap;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class Splash extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 2500;
    Shimmer shimmer;
    TextView textcon1;
    private ShimmerTextView textth;
    private ImageView im_splash;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        im_splash = (ImageView) findViewById(R.id.im_splash);
        textth = (ShimmerTextView) findViewById(R.id.textth);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "ggg.ttf");
        textth.setTypeface(typeface);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                // Prepare an Interstitial Ad Listener

                Intent i = new Intent(Splash.this, MainActivity.class);


                startActivity(i);


                // close this activity
                finish();

            }
        }, SPLASH_TIME_OUT);

        textcon1 = (TextView) findViewById(R.id.textcon1);


    }

}