package com.App.Thwaap;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.qoutes.QoutesActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.ArrayList;
import java.util.List;

public class Maintitle3 extends BaseActivity {
ViewPager pager1;
List<item>lista;
    private AdView mAdView;
    private String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maintitle3);
        pager1=(ViewPager)findViewById(R.id.pager1);
        lista=new ArrayList<>();
        lista.add(new item(getResources().getString(R.string.spage1),getResources().getString(R.string.spage2),getResources().getString(R.string.spage3),"1-20"));
        lista.add(new item(getResources().getString(R.string.spagea1),getResources().getString(R.string.spagea2),getResources().getString(R.string.spagea3),"2-20"));
        lista.add(new item(getResources().getString(R.string.spageb1),getResources().getString(R.string.spageb2),getResources().getString(R.string.spageb3),"3-20"));
        lista.add(new item(getResources().getString(R.string.spagec1),getResources().getString(R.string.spagec2),getResources().getString(R.string.spagec3),"4-20"));
        lista.add(new item(getResources().getString(R.string.spaged1),getResources().getString(R.string.spaged2),getResources().getString(R.string.spaged3),"5-20"));
        lista.add(new item(getResources().getString(R.string.spagee1),getResources().getString(R.string.spagee2),getResources().getString(R.string.spagee3),"6-20"));
        lista.add(new item(getResources().getString(R.string.spageh1),getResources().getString(R.string.spageh2),getResources().getString(R.string.spageh3),"7-20"));
        lista.add(new item(getResources().getString(R.string.spagei1),getResources().getString(R.string.spagei2),getResources().getString(R.string.spagei3),"8-20"));
        lista.add(new item(getResources().getString(R.string.spagej1),getResources().getString(R.string.spagej2),getResources().getString(R.string.spagej3),"9-20"));
        lista.add(new item(getResources().getString(R.string.spagek1),getResources().getString(R.string.spagek2),getResources().getString(R.string.spagek3),"10-20"));
        lista.add(new item(getResources().getString(R.string.spagel1),getResources().getString(R.string.spagel2),getResources().getString(R.string.spagel3),"11-20"));
        lista.add(new item(getResources().getString(R.string.spagem1),getResources().getString(R.string.spagem2),getResources().getString(R.string.spagem3),"12-20"));
        lista.add(new item(getResources().getString(R.string.spagen1),getResources().getString(R.string.spagen2),getResources().getString(R.string.spagen3),"13-20"));
        lista.add(new item(getResources().getString(R.string.spagep1),getResources().getString(R.string.spagep2),getResources().getString(R.string.spagep3),"14-20"));
        lista.add(new item(getResources().getString(R.string.spageq1),getResources().getString(R.string.spageq2),getResources().getString(R.string.spageq3),"15-20"));
        lista.add(new item(getResources().getString(R.string.spagew1),getResources().getString(R.string.spagew2),getResources().getString(R.string.spagew3),"16-20"));
        lista.add(new item(getResources().getString(R.string.spageww1),getResources().getString(R.string.spageww2),getResources().getString(R.string.spageww3),"17-20"));
        lista.add(new item(getResources().getString(R.string.spagwww1),getResources().getString(R.string.spagwww2),getResources().getString(R.string.spagwww3),"18-20"));
        lista.add(new item(getResources().getString(R.string.spagewwww1),getResources().getString(R.string.spagewwww2),getResources().getString(R.string.spagewwww3),"19-20"));
        lista.add(new item(getResources().getString(R.string.spagez1),getResources().getString(R.string.spagez2),getResources().getString(R.string.spagez3),"20-20"));
        Adapterpager1 adapterpager1= new Adapterpager1(this,lista);
        pager1.setAdapter(adapterpager1);
        setUpAds();
    }

    private void setUpAds() {
        mAdView = findViewById(R.id.pagerspah);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}
