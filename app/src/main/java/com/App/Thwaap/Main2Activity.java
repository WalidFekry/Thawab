package com.App.Thwaap;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.App.Thwaap.base.BaseActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private final String TAG = "TAG";
    RecyclerView rec;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);


        rec = (RecyclerView) findViewById(R.id.rec1);
        rec.setLayoutManager(new LinearLayoutManager(this));
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        List<rec_item> listt = new ArrayList<>();
        listt.add(new rec_item("أذكار الاستيقاظ من النوم"));
        listt.add(new rec_item("دعاء الوضوء"));
        listt.add(new rec_item("الدعاء عند سماع الآذان"));
        listt.add(new rec_item("أدعية استفتاح الصلاة"));
        listt.add(new rec_item("أدعية الركوع في الصلاة"));
        listt.add(new rec_item("أدعية الرفع من الركوع"));
        listt.add(new rec_item("أدعية السجود"));
        listt.add(new rec_item("أدعية الجلوس بين السجدتين "));
        listt.add(new rec_item("دعاء سجود التلاوة"));
        listt.add(new rec_item("أدعية بعد التشهد الأخير وقبل السلام"));
        listt.add(new rec_item("أدعية للوالدين"));
        listt.add(new rec_item("أدعية للمتوفى (ذكور)"));
        listt.add(new rec_item("أدعية للمتوفية (إناث)"));
        listt.add(new rec_item("أدعية للميّت الطفل الصغير (ذكر أو أنثى)"));
        listt.add(new rec_item("أالدّعاء للميّت في  صّلاة الجنازة"));
        listt.add(new rec_item("دعاء يوم الجمعه"));
        listt.add(new rec_item("دعاء الرزق"));
        listt.add(new rec_item("الدعاء للمريض بالشفاء"));
        listt.add(new rec_item("ماهي الاستخارة و حكمها"));
        listt.add(new rec_item("متى يحتاج العبد إلى صلاة الاستخارة"));
        listt.add(new rec_item("دعاء صلاة الإستخارة"));
        listt.add(new rec_item("دعاء السفر"));
        listt.add(new rec_item("أدعية مأثورة في شهر رمضان"));
        listt.add(new rec_item("نصائح رمضانية"));
        listt.add(new rec_item("دعاء العشر الأواخر من رمضان"));
        listt.add(new rec_item("دعاء ليلة القدر"));
        listt.add(new rec_item("الرُّقية الشرعية من القرآن والسنة"));
        listt.add(new rec_item("الرُّقية الشرعية من القرآن الكريم"));
        listt.add(new rec_item("الرُّقية الشرعية من السنة النبوية"));


        Adapters adapters = new Adapters(this, listt);
        rec.setAdapter(adapters);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setUpAds();
        getHandler().postDelayed(this::LoadAds, 4000);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setUpAds() {

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, getString(R.string.Biny2), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
    }

    private void LoadAds() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(Main2Activity.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.webside) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://application-muslim.blogspot.com/?m=1&fbclid=IwAR2JSI7LF7kK9hVfmyu50eoYLq_-dXmJlkWovnMRoGTxgXm_S7FFewa1PdI")));
        } else if (id == R.id.facegroub) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/440403217380641")));
        } else if (id == R.id.ratee) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/4VQlA6AZrH")));
        } else if (id == R.id.shareee) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, " تطبيق ثواب (Thawap) ");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "\n" +
                    "قمنا بتصميم البرنامج ليكون بسيط و مجاني ليضم أذكار الصباح و المساء مكتوبة و أذكار المسلم بدون إنترنت و ليساعدك على أن لا تنسى ذكر الله ابداً .\n \n" +
                    "تفضل رابط تطبيق ثواب  https://t.co/4VQlA6AZrH \n");
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "مشاركه تطبيق ثواب  مع الاصدقاء:"));


        } else if (id == R.id.mass) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "walid_fekry@hotmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "اكتب آقتراحك");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
