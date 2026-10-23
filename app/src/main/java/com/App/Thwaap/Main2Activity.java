package com.App.Thwaap;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityMain2Binding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        CommonUtils.setupFullscreen(this);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain2.toolbar);

        binding.appBarMain2.contentMain2.rec1.setLayoutManager(new LinearLayoutManager(this));

        List<rec_item> listt = getRecItems();
        Adapters adapters = new Adapters(this, listt);
        binding.appBarMain2.contentMain2.rec1.setAdapter(adapters);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.appBarMain2.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navView.setNavigationItemSelectedListener(this);

        AdManager.getInstance().loadInterstitial(this, getString(R.string.Biny2));
        getHandler().postDelayed(() -> AdManager.getInstance().showInterstitial(this), 4000);
    }

    @NonNull
    private static List<rec_item> getRecItems() {
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
        return listt;
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
        } else if (id == R.id.shareee) {
            CommonUtils.shareText(this,
                    " تطبيق ثواب (Thawap) ",
                    "\nقمنا بتصميم البرنامج ليكون بسيط و مجاني ليضم أذكار الصباح و المساء مكتوبة و أذكار المسلم بدون إنترنت و ليساعدك على أن لا تستنى ذكر الله ابداً .\n \nتفضل رابط تطبيق ثواب  https://play.google.com/store/apps/details?id=com.App.Thwaap \n",
                    "مشاركه تطبيق ثواب  مع الاصدقاء:");
        } else if (id == R.id.mass) {
            CommonUtils.sendEmail(this, "walid_fekry@hotmail.com", "اكتب آقتراحك", "");
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
