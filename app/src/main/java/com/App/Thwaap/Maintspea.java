package com.App.Thwaap;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class Maintspea extends AppCompatActivity {
ViewPager pagert;
List<itempagerms>lis;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
         WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maintspea);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adsspha);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        pagert=(ViewPager)findViewById(R.id.tsbeh);
        lis=new ArrayList<>();
        lis.add(new itempagerms(getResources().getString(R.string.tst2),"1-5"));
        lis.add(new itempagerms(getResources().getString(R.string.tst3),"2-5"));
        lis.add(new itempagerms(getResources().getString(R.string.tst4),"3-5"));
        lis.add(new itempagerms(getResources().getString(R.string.tst6),"4-5"));
        lis.add(new itempagerms(getResources().getString(R.string.tst7),"5-5"));
        Adapterpagerts adapterpager1=new Adapterpagerts(this,lis);
        pagert.setAdapter(adapterpager1);

    }
}
