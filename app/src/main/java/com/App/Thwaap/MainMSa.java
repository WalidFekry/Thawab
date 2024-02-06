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

public class MainMSa extends AppCompatActivity {
ViewPager pager2;
List<item_pager2>list2;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_main_msa);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adsmsa);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        pager2=(ViewPager)findViewById(R.id.pager2);
        list2=new ArrayList<>();
        list2.add(new item_pager2(getResources().getString(R.string.azm1),getResources().getString(R.string.azm2),getResources().getString(R.string.azm3),"1-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm4),getResources().getString(R.string.azm5),getResources().getString(R.string.azm6),"2-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm7),getResources().getString(R.string.azm8),getResources().getString(R.string.azm9),"3-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm10),getResources().getString(R.string.azm11),getResources().getString(R.string.azm12),"4-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm13),getResources().getString(R.string.azm14),getResources().getString(R.string.azm15),"5-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm16),getResources().getString(R.string.azm17),getResources().getString(R.string.azm18),"6-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm19),getResources().getString(R.string.azm20),getResources().getString(R.string.azm21),"7-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm22),getResources().getString(R.string.azm23),getResources().getString(R.string.azm24),"8-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm25),getResources().getString(R.string.azm26),getResources().getString(R.string.azm27),"9-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm28),getResources().getString(R.string.azm29),getResources().getString(R.string.azm30),"10-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm31),getResources().getString(R.string.azm32),getResources().getString(R.string.azm33),"11-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm34),getResources().getString(R.string.azm35),getResources().getString(R.string.azm36),"12-13"));
        list2.add(new item_pager2(getResources().getString(R.string.azm37),getResources().getString(R.string.azm38),getResources().getString(R.string.azm39),"13-13"));
        Adapterpage2 adapterpager2=new Adapterpage2(list2,this);
        pager2.setAdapter(adapterpager2);

    }
}
