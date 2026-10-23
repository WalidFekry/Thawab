package com.App.Thwaap;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.App.Thwaap.databinding.ActivityAboutBinding;
import com.App.Thwaap.utils.CommonUtils;
import com.App.Thwaap.utils.PreferencesManager;
import com.romainpiel.shimmer.Shimmer;

public class about extends AppCompatActivity {

    private ActivityAboutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonUtils.setupEdgeToEdge(this, binding.getRoot());

        setupFontsAndShimmer();
        setupClickListeners();
    }

    private void setupFontsAndShimmer() {
        try {
            Typeface typeface = Typeface.createFromAsset(getAssets(), "6.otf");
            Typeface typeface1 = Typeface.createFromAsset(getAssets(), "ggg.ttf");

            binding.textthaeap.setTypeface(typeface1);
            binding.txtapp.setTypeface(typeface);
            binding.t1.setTypeface(typeface);
            binding.t2.setTypeface(typeface);
            binding.t3.setTypeface(typeface);
            binding.t4.setTypeface(typeface);
            binding.t6.setTypeface(typeface);
            binding.t7.setTypeface(typeface);
            binding.t8.setTypeface(typeface);
            binding.t9.setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Shimmer shimmer = new Shimmer();
        shimmer.start(binding.textthaeap);
    }

    private void setupClickListeners() {
        PreferencesManager prefs = new PreferencesManager(this);
        binding.darkmodeSwitch.setChecked(prefs.isNightMode());

        View.OnClickListener toggleNightMode = v -> {
            boolean newMode = !prefs.isNightMode();
            prefs.setNightMode(newMode);
            binding.darkmodeSwitch.setChecked(newMode);
            AppCompatDelegate.setDefaultNightMode(newMode ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        };

        binding.darkmodeCard.setOnClickListener(toggleNightMode);

        binding.facebookc.setOnClickListener(v -> CommonUtils.openUrl(this, "https://www.facebook.com/Waleed.Fikri"));
        binding.twiterc.setOnClickListener(v -> CommonUtils.openUrl(this, "https://twitter.com/ProWalidFekry"));
        binding.gmmailc.setOnClickListener(v -> CommonUtils.sendEmail(this, "prowalidkfekry@gmail.com", "رسالة إلى مطور تطبيق ثواب 📲", "اكتب رسالتك هنا"));
        binding.shearc.setOnClickListener(v -> CommonUtils.shareText(this,
                " تطبيق ثواب (Thawap) ",
                "\nقمنا بتصميم البرنامج ليكون بسيط و مجاني ليضم أذكار الصباح و المساء مكتوبة و أذكار المسلم بدون إنترنت و ليساعدك على أن لا تنسى ذكر الله ابداً .\n \nتفضل رابط تطبيق ثواب  https://play.google.com/store/apps/details?id=com.App.Thwaap \n",
                "مشاركه تطبيق ثواب  مع الاصدقاء:"));
        binding.rratec.setOnClickListener(v -> CommonUtils.openPlayStore(this));
        binding.googleplayc.setOnClickListener(v -> CommonUtils.openUrl(this, "https://t.co/US34fsUZeW"));
        binding.pric.setOnClickListener(v -> CommonUtils.openUrl(this, "https://sites.google.com/view/appthawap/home?fbclid=IwAR1Zlt7zvBwb1j1iTKSj75nG4xnj7e3SdS0djhhzHFJDvnnFaW0YTGPdjgE"));
    }
}
