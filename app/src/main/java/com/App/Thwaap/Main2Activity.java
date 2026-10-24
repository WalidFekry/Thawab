package com.App.Thwaap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityMain2Binding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends BaseActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonUtils.setupEdgeToEdge(this, binding.getRoot());

        if (binding.backButton != null) {
            binding.backButton.setOnClickListener(v -> finish());
        }

        String title = getIntent().getStringExtra("title");
        if (title != null && binding.toolbarTitle != null) {
            binding.toolbarTitle.setText(title);
        }

        binding.rec1.setLayoutManager(new LinearLayoutManager(this));

        List<rec_item> listt = getRecItems();
        Adapters adapters = new Adapters(this, listt);
        binding.rec1.setAdapter(adapters);

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
}