package com.App.Thwaap;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.App.Thwaap.databinding.ActivityMaintitle1Binding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;

public class Maintitle1 extends AppCompatActivity {

    private ActivityMaintitle1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaintitle1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonUtils.setupEdgeToEdge(this, binding.getRoot());

        AdManager.getInstance().loadBanner(binding.adstitle1);

        try {
            Typeface typeface = Typeface.createFromAsset(getAssets(), "6.otf");
            binding.t1.setTypeface(typeface);
            binding.t2.setTypeface(typeface);
            binding.t3.setTypeface(typeface);
            binding.t4.setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        String title = intent != null ? intent.getStringExtra("title") : "";
        if (title == null) title = "";

        switch (title) {
            case "أذكار الاستيقاظ من النوم":
                binding.t1.setText(R.string.azkarestkas1);
                binding.t2.setText(R.string.azkarestkas2);
                binding.t3.setText(R.string.azkarestkas3);
                binding.t4.setText(R.string.azkarestkas4);
                binding.iconnn.setImageResource(R.drawable.icon_f);
                break;
            case "دعاء الوضوء":
                binding.t1.setText(R.string.wdo1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.wdo2);
                binding.t3.setText(R.string.wdo3);
                binding.iconnn.setImageResource(R.drawable.img_m9);
                break;
            case "الدعاء عند سماع الآذان":
                binding.t1.setText(R.string.azan1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.azan2);
                binding.iconnn.setImageResource(R.drawable.img_m5);
                break;
            case "أدعية استفتاح الصلاة":
            case "أدعية الركوع في الصلاة":
            case "أدعية الرفع من الركوع":
            case "أدعية السجود":
            case "أدعية الجلوس بين السجدتين ":
            case "دعاء سجود التلاوة":
            case "أدعية بعد التشهد الأخير وقبل السلام":
                setPrayersContent(title);
                break;
            case "أدعية للوالدين":
                binding.t1.setText(R.string.wlden1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.wlden2);
                binding.t3.setText(R.string.wlden3);
                binding.iconnn.setImageResource(R.drawable.img_m2);
                break;
            case "أدعية للمتوفى (ذكور)":
                binding.t1.setText(R.string.mtwaf1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.mtwaf2);
                binding.iconnn.setImageResource(R.drawable.img_m3);
                break;
            case "أدعية للمتوفية (إناث)":
                binding.t1.setText(R.string.mtwen1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.mtwen2);
                binding.iconnn.setImageResource(R.drawable.img_m3);
                break;
            case "أدعية للميّت الطفل الصغير (ذكر أو أنثى)":
                binding.t1.setText(R.string.mt1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.mt2);
                binding.iconnn.setImageResource(R.drawable.img_m3);
                break;
            case "أالدّعاء للميّت في  صّلاة الجنازة":
                binding.t1.setText(R.string.jnaja1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.jnaja2);
                binding.iconnn.setImageResource(R.drawable.img_m3);
                break;
            case "دعاء يوم الجمعه":
                binding.t1.setText(R.string.jma1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.jma2);
                binding.iconnn.setImageResource(R.drawable.img_m10);
                break;
            case "دعاء الرزق":
                binding.t1.setText(R.string.rzq1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.rzq2);
                binding.iconnn.setImageResource(R.drawable.img_m7);
                break;
            case "الدعاء للمريض بالشفاء":
                binding.t1.setText(R.string.mar1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.mar2);
                binding.iconnn.setImageResource(R.drawable.img_m8);
                break;
            case "ماهي الاستخارة و حكمها":
                binding.t1.setText(R.string.is1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.is2);
                binding.iconnn.setImageResource(R.drawable.img_m6);
                break;
            case "متى يحتاج العبد إلى صلاة الاستخارة":
                binding.t1.setText(R.string.is1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.is2);
                binding.t3.setText(R.string.is3);
                binding.t4.setText(R.string.is4);
                binding.iconnn.setImageResource(R.drawable.img_m6);
                break;
            case "دعاء صلاة الإستخارة":
                binding.t1.setText(R.string.sk1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.sk2);
                binding.iconnn.setImageResource(R.drawable.img_m6);
                break;
            case "دعاء السفر":
                binding.t1.setText(R.string.msm1);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.t2.setText(R.string.msm2);
                binding.iconnn.setImageResource(R.drawable.icon_d);
                break;
            case "أدعية مأثورة في شهر رمضان":
                binding.t1.setText(R.string.ss1);
                binding.t2.setText(R.string.ss2);
                binding.t3.setText(R.string.ss3);
                binding.t4.setText(R.string.ss4);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(23);
                binding.iconnn.setImageResource(R.drawable.img_m4);
                break;
            case "نصائح رمضانية":
                binding.t1.setText(R.string.nsea1);
                binding.t2.setText(R.string.nsea2);
                binding.t2.setTextSize(25);
                binding.t1.setTextSize(23);
                binding.iconnn.setImageResource(R.drawable.img_m4);
                break;
            case "دعاء العشر الأواخر من رمضان":
                binding.t1.setText(R.string.fdl1);
                binding.t2.setText(R.string.fdl2);
                binding.t3.setText(R.string.fdl3);
                binding.t4.setText(R.string.fdl4);
                binding.t2.setTextSize(25);
                binding.t1.setTextSize(23);
                binding.iconnn.setImageResource(R.drawable.img_m4);
                break;
            case "دعاء ليلة القدر":
                binding.t1.setText(R.string.qdr1);
                binding.t2.setText(R.string.qdr2);
                binding.t3.setText(R.string.qdr3);
                binding.t4.setText(R.string.qdr4);
                binding.t1.setTextSize(24);
                binding.t2.setTextSize(24);
                binding.iconnn.setImageResource(R.drawable.img_m4);
                break;
            case "الرُّقية الشرعية من القرآن والسنة":
                binding.t1.setText(R.string.r1);
                binding.t2.setText(R.string.r2);
                binding.t1.setTextSize(24);
                binding.t2.setTextSize(25);
                binding.iconnn.setImageResource(R.drawable.img_m4);
                break;
            case "الرُّقية الشرعية من القرآن الكريم":
                binding.t1.setText(R.string.rr1);
                binding.t2.setText(R.string.rr2);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(24);
                binding.iconnn.setImageResource(R.drawable.img_m4);
                break;
            case "الرُّقية الشرعية من السنة النبوية":
                binding.t1.setText(R.string.rrr1);
                binding.t2.setText(R.string.rrr2);
                binding.t1.setTextSize(25);
                binding.t2.setTextSize(24);
                binding.iconnn.setImageResource(R.drawable.img_m4);
                break;
            default:
                break;
        }
    }

    private void setPrayersContent(String title) {
        binding.t1.setTextSize(25);
        binding.t2.setTextSize(23);
        binding.iconnn.setImageResource(R.drawable.img_m6);

        if ("أدعية استفتاح الصلاة".equals(title)) {
            binding.t1.setText(R.string.sla1);
            binding.t2.setText(R.string.sla2);
        } else if ("أدعية الركوع في الصلاة".equals(title)) {
            binding.t1.setText(R.string.sll1);
            binding.t2.setText(R.string.sll2);
        } else if ("أدعية الرفع من الركوع".equals(title)) {
            binding.t1.setText(R.string.slll1);
            binding.t2.setText(R.string.slll2);
        } else if ("أدعية السجود".equals(title)) {
            binding.t1.setText(R.string.saal1);
            binding.t2.setText(R.string.saal2);
        } else if ("أدعية الجلوس بين السجدتين ".equals(title)) {
            binding.t1.setText(R.string.sgda1);
            binding.t2.setText(R.string.sgda2);
        } else if ("دعاء سجود التلاوة".equals(title)) {
            binding.t1.setText(R.string.tlwa1);
            binding.t2.setText(R.string.tlwa2);
        } else if ("أدعية بعد التشهد الأخير وقبل السلام".equals(title)) {
            binding.t1.setText(R.string.tsh1);
            binding.t2.setText(R.string.tsh2);
        }
    }
}
