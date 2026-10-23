package com.App.Thwaap;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.App.Thwaap.databinding.DesignPager2Binding;
import com.App.Thwaap.utils.CommonUtils;
import com.romainpiel.shimmer.Shimmer;

import java.util.List;

public class Adapterpage2 extends PagerAdapter {
    public int counter = 0;
    private List<item_pager2> list2;
    private final Context context;
    private static Typeface cachedTypeface;

    public Adapterpage2(List<item_pager2> list2, Context context) {
        this.list2 = list2;
        this.context = context;
        if (cachedTypeface == null && context != null) {
            try {
                cachedTypeface = Typeface.createFromAsset(context.getAssets(), "6.otf");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Adapterpage2(Context context) {
        this.context = context;
        if (cachedTypeface == null && context != null) {
            try {
                cachedTypeface = Typeface.createFromAsset(context.getAssets(), "6.otf");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getCount() {
        return list2 != null ? list2.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        DesignPager2Binding binding = DesignPager2Binding.inflate(LayoutInflater.from(context), container, false);

        Shimmer s = new Shimmer();
        s.start(binding.cccu);

        binding.car2.setOnClickListener(v -> {
            counter++;
            binding.cccu.setText(String.valueOf(counter));
        });

        binding.relodmm.setOnClickListener(v -> {
            counter = 0;
            binding.cccu.setText(String.valueOf(counter));
        });

        if (cachedTypeface != null) {
            binding.textpagerm1.setTypeface(cachedTypeface);
            binding.textpagerm2.setTypeface(cachedTypeface);
            binding.textpagerm3.setTypeface(cachedTypeface);
        }

        item_pager2 item = list2.get(position);
        binding.textpagerm1.setText(item.getTextpagerm1());
        binding.textpagerm2.setText(item.getTextpagerm2());
        binding.textpagerm3.setText(item.getTextpagerm3());
        binding.textpage2.setText(item.getTextpage2());

        container.addView(binding.getRoot());

        binding.copt2.setOnClickListener(v -> {
            String textToCopy = item.getTextpagerm1() + "\n" + item.getTextpagerm2() + "\n" + item.getTextpagerm3() +
                    "\nاذكار المساء من تطبيق ثواب \n\n https://play.google.com/store/apps/details?id=com.App.Thwaap\n";
            CommonUtils.copyToClipboard(context, "", textToCopy, "تم نسخ النصوص ");
        });

        binding.share2.setOnClickListener(v -> {
            String textToShare = item.getTextpagerm1() + "\n" + item.getTextpagerm2() + "\n" + item.getTextpagerm3() +
                    "\nمشاركه نصوص من تطبيق ثواب  \n\n https://play.google.com/store/apps/details?id=com.App.Thwaap\n";
            CommonUtils.shareText(context, " تطبيق ثواب (Thawap) ", textToShare, "مشاركه تطبيق ثواب  مع الاصدقاء:");
            Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();
        });

        return binding.getRoot();
    }
}
