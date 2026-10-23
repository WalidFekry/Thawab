package com.App.Thwaap;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;

import com.App.Thwaap.databinding.ActivityMainBinding;
import com.App.Thwaap.databinding.ContentMainBinding;
import com.App.Thwaap.masbaha.MasbahaActivity;
import com.App.Thwaap.qoutes.QoutesActivity;
import com.App.Thwaap.roqia.RoqiaNoIternet;
import com.App.Thwaap.utils.CommonUtils;
import com.App.Thwaap.utils.PreferencesManager;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.romainpiel.shimmer.Shimmer;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMainBinding binding;
    private ContentMainBinding contentBinding;
    private boolean isPermissionGranted = false;

    private final ActivityResultLauncher<String> requestPermissionLauncherNotification =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                isPermissionGranted = isGranted;
                if (!isGranted && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                        showPermissionDialog();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //CommonUtils.setupEdgeToEdge(this, binding.getRoot());

        contentBinding = binding.appBarMain.contentMain;

        setSupportActionBar(binding.appBarMain.toolbar);

        setupUI();
        setupNavigationDrawer();
        setupClickListeners();

        FirebaseMessaging.getInstance().subscribeToTopic("all");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            checkNotificationPermission();
        }
    }

    private void setupUI() {
        try {
            Shimmer shimmer = new Shimmer();
            shimmer.start(contentBinding.tface);

            Typeface font = Typeface.createFromAsset(getAssets(), "6.otf");
            contentBinding.tface.setTypeface(font);

            contentBinding.texta.setTypeface(font);
            contentBinding.textb.setTypeface(font);
            contentBinding.textc.setTypeface(font);
            contentBinding.textd.setTypeface(font);
            contentBinding.texte.setTypeface(font);
            contentBinding.textf.setTypeface(font);
            contentBinding.textg.setTypeface(font);
            contentBinding.texth.setTypeface(font);
            contentBinding.texti.setTypeface(font);
        } catch (Exception e) {
            e.printStackTrace();
        }

        contentBinding.anima.startAnimation();
    }

    private void setupNavigationDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.appBarMain.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navView.setNavigationItemSelectedListener(this);
    }

    private void setupClickListeners() {
        contentBinding.abouut.setOnClickListener(v -> startActivity(new Intent(this, about.class)));

        contentBinding.imga.setOnClickListener(v -> navigateTo(Maintitle3.class, "اذكار الصباح"));
        contentBinding.imgb.setOnClickListener(v -> navigateTo(MainMSa.class, null));
        contentBinding.imgc.setOnClickListener(v -> navigateTo(Maintspea.class, "تسآبيح"));
        contentBinding.imgd.setOnClickListener(v -> navigateTo(Maintitle2.class, "اذكار السفر"));
        contentBinding.imge.setOnClickListener(v -> navigateTo(Maintitle2.class, "اذكار المسجد"));
        contentBinding.imgf.setOnClickListener(v -> navigateTo(Maintitle2.class, "اذكار النوم"));
        contentBinding.imgg.setOnClickListener(v -> navigateTo(Maintitle2.class, "اذكارالمنزل"));
        contentBinding.imgh.setOnClickListener(v -> navigateTo(Main2Activity.class, null));
        contentBinding.imgi.setOnClickListener(v -> navigateTo(Maintitle2.class, "الاسماء الحسني"));

        contentBinding.masbaha.setOnClickListener(v -> navigateTo(MasbahaActivity.class, "المسبحة"));
        if (contentBinding.masbaha2 != null) {
            contentBinding.masbaha2.setOnClickListener(v -> navigateTo(MasbahaActivity.class, "المسبحة"));
        }

        contentBinding.qoutes.setOnClickListener(v -> navigateTo(QoutesActivity.class, "اقتباسات عشوائية"));
        if (contentBinding.qoutes2 != null) {
            contentBinding.qoutes2.setOnClickListener(v -> navigateTo(QoutesActivity.class, "اقتباسات عشوائية"));
        }

        contentBinding.roqia.setOnClickListener(v -> navigateTo(RoqiaNoIternet.class, "الرقية الشرعية"));
        if (contentBinding.roqia2 != null) {
            contentBinding.roqia2.setOnClickListener(v -> navigateTo(RoqiaNoIternet.class, "الرقية الشرعية"));
        }

        contentBinding.kenz.setOnClickListener(v -> CommonUtils.openUrl(this, "https://t.co/US34fsUZeW"));
        if (contentBinding.kenz2 != null) {
            contentBinding.kenz2.setOnClickListener(v -> CommonUtils.openUrl(this, "https://t.co/US34fsUZeW"));
        }
    }

    private void navigateTo(Class<?> targetActivity, String title) {
        Intent intent = new Intent(this, targetActivity);
        if (title != null) {
            intent.putExtra("title", title);
        }
        startActivity(intent);
    }

    private void checkNotificationPermission() {
        if (!isPermissionGranted) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                isPermissionGranted = true;
            } else {
                requestPermissionLauncherNotification.launch(Manifest.permission.POST_NOTIFICATIONS);
            }
        }
    }

    private void showPermissionDialog() {
        new AlertDialog.Builder(this)
                .setMessage("من فضلك قم بالموافقة على الاشعارات لكي تصلك رسائل التفاؤل والإقتباسات من التطبيق ..")
                .setPositiveButton("الاعدادات", (dialog, which) -> {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.fromParts("package", getPackageName(), null));
                    startActivity(intent);
                    dialog.dismiss();
                })
                .setNegativeButton("إلغاء", (dialog, which) -> dialog.dismiss())
                .show();
    }

    @Override
    public void onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.webside) {
            CommonUtils.openUrl(this, "https://application-muslim.blogspot.com/?m=1&fbclid=IwAR2JSI7LF7kK9hVfmyu50eoYLq_-dXmJlkWovnMRoGTxgXm_S7FFewa1PdI");
        } else if (id == R.id.facegroub) {
            CommonUtils.openUrl(this, "https://www.facebook.com/groups/440403217380641");
        } else if (id == R.id.ratee) {
            CommonUtils.openPlayStore(this);
        } else if (id == R.id.maktbtiplus) {
            CommonUtils.openUrl(this, "https://walid-fekry.com/maktbti-plus/");
        } else if (id == R.id.tele) {
            CommonUtils.openUrl(this, "https://t.me/App_Maktbti");
        } else if (id == R.id.shareee) {
            CommonUtils.shareText(this,
                    " تطبيق ثواب (Thawap) ",
                    "\nقمنا بتصميم البرنامج ليكون بسيط و مجاني ليضم أذكار الصباح و المساء مكتوبة و أذكار المسلم بدون إنترنت و ليساعدك على أن لا تنسى ذكر الله ابداً .\n \nتفضل رابط تطبيق ثواب  https://play.google.com/store/apps/details?id=com.App.Thwaap \n",
                    "مشاركه تطبيق ثواب  مع الاصدقاء:");
        } else if (id == R.id.appshare2) {
            CommonUtils.openUrl(this, "https://www.facebook.com/sharer.php?u=https%3A%2F%2Fplay.google.com%2Fstore%2Fapps%2Fdetails%3Fid%3Dcom.App.Thwaap");
        } else if (id == R.id.about) {
            startActivity(new Intent(this, about.class));
        } else if (id == R.id.mass) {
            CommonUtils.sendEmail(this, "prowalidfekry@gmail.com", "رسالة إلى مبرمج تطبيق ثواب 📲", "");
        } else if (id == R.id.darkmode) {
            PreferencesManager prefs = new PreferencesManager(this);
            boolean newMode = !prefs.isNightMode();
            prefs.setNightMode(newMode);
            AppCompatDelegate.setDefaultNightMode(newMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
