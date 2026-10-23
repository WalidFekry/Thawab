package com.App.Thwaap;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.App.Thwaap.databinding.DesignPager1Binding;
import com.App.Thwaap.utils.CommonUtils;
import com.romainpiel.shimmer.Shimmer;

import java.util.List;

public class Adapterpager1 extends PagerAdapter {

    private final Context context;
    private final List<item> lista;
    private static Typeface cachedTypeface;
    public int counter = 0;

    public Adapterpager1(Context context, List<item> lista) {
        this.context = context;
        this.lista = lista;
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
        return lista != null ? lista.size() : 0;
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
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        DesignPager1Binding binding = DesignPager1Binding.inflate(LayoutInflater.from(context), container, false);

        Shimmer s = new Shimmer();
        s.start(binding.ccu);

        binding.car.setOnClickListener(v -> {
            counter++;
            binding.ccu.setText(String.valueOf(counter));
        });

        binding.relod.setOnClickListener(v -> {
            counter = 0;
            binding.ccu.setText(String.valueOf(counter));
        });

        if (cachedTypeface != null) {
            binding.te.setTypeface(cachedTypeface);
            binding.tee.setTypeface(cachedTypeface);
            binding.teee.setTypeface(cachedTypeface);
        }

        item currentItem = lista.get(position);
        binding.te.setText(currentItem.getTe());
        binding.tee.setText(currentItem.getTee());
        binding.teee.setText(currentItem.getTeee());
        binding.teeee.setText(currentItem.getTeeee());

        container.addView(binding.getRoot());

        binding.contentccc.setOnClickListener(v -> {
            String textToCopy = currentItem.getTe() + "\n" + currentItem.getTee() + "\n" + currentItem.getTeee() +
                    "\nنصوص من تطبيق ثواب \n\n https://play.google.com/store/apps/details?id=com.App.Thwaap\n";
            CommonUtils.copyToClipboard(context, "", textToCopy, "تم نسخ النصوص ");
        });

        binding.sharetext.setOnClickListener(v -> {
            String textToShare = currentItem.getTe() + "\n" + currentItem.getTee() + "\n" + currentItem.getTeee() +
                    "\nمشاركه نصوص من تطبيق ثواب  \n\n https://play.google.com/store/apps/details?id=com.App.Thwaap\n";
            CommonUtils.shareText(context, " تطبيق ثواب (Thawap) ", textToShare, "مشاركه تطبيق ثواب  مع الاصدقاء:");
            Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();
        });

        return binding.getRoot();
    }
}
