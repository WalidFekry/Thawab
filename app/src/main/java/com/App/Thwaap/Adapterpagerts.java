package com.App.Thwaap;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.App.Thwaap.databinding.DesigntsbehBinding;
import com.App.Thwaap.utils.CommonUtils;
import com.romainpiel.shimmer.Shimmer;

import java.util.List;

public class Adapterpagerts extends PagerAdapter {
    private final Context context;
    private final List<itempagerms> lis;
    private static Typeface cachedTypeface;
    public int counter = 0;

    public Adapterpagerts(Context context, List<itempagerms> lis) {
        this.context = context;
        this.lis = lis;
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
        return lis != null ? lis.size() : 0;
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
        DesigntsbehBinding binding = DesigntsbehBinding.inflate(LayoutInflater.from(context), container, false);

        Shimmer s = new Shimmer();
        s.start(binding.tsb);

        binding.carttt.setOnClickListener(v -> {
            counter++;
            binding.tsb.setText(String.valueOf(counter));
        });

        binding.relodts.setOnClickListener(v -> {
            counter = 0;
            binding.tsb.setText(String.valueOf(counter));
        });

        if (cachedTypeface != null) {
            binding.tsbeh.setTypeface(cachedTypeface);
        }

        itempagerms item = lis.get(position);
        binding.tsbeh.setText(item.getTextpager1());
        binding.tsbehcount.setText(item.getTsbehcount1());

        container.addView(binding.getRoot());

        binding.shmspha.setOnClickListener(v -> {
            String textToShare = item.getTextpager1() + "\nمشاركه نصوص من تطبيق ثواب  \n\n https://play.google.com/store/apps/details?id=com.App.Thwaap\n";
            CommonUtils.shareText(context, " تطبيق ثواب (Thawap) ", textToShare, "مشاركه تطبيق ثواب  مع الاصدقاء:");
            Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();
        });

        binding.copyms.setOnClickListener(v -> {
            String textToCopy = item.getTextpager1() + "\nنصوص من تطبيق ثواب \n\n https://play.google.com/store/apps/details?id=com.App.Thwaap\n";
            CommonUtils.copyToClipboard(context, "", textToCopy, "تم نسخ النصوص ");
        });

        return binding.getRoot();
    }
}
