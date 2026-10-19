package com.App.Thwaap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.List;

public class Adapterpagerts extends PagerAdapter {
    private final Context context;
    private final List<itempagerms> lis;
    private static Typeface cachedTypeface;
    public int n = 0;

    public Adapterpagerts(Context context, List<itempagerms> lis) {
        this.context = context;
        this.lis = lis;
        if (cachedTypeface == null && context != null) {
            cachedTypeface = Typeface.createFromAsset(context.getAssets(), "6.otf");
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
        container.removeView((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final ShimmerTextView tsb;
        MaterialIconView relodts, copyms, shmspha;
        Shimmer s = new Shimmer();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.designtsbeh, container, false);
        CardView carttt = view.findViewById(R.id.carttt);
        tsb = view.findViewById(R.id.tsb);
        s.start(tsb);

        carttt.setOnClickListener(v -> {
            n++;
            tsb.setText(String.valueOf(n));
        });

        relodts = view.findViewById(R.id.relodts);
        relodts.setOnClickListener(v -> {
            n = 0;
            tsb.setText(String.valueOf(n));
        });

        copyms = view.findViewById(R.id.copyms);
        shmspha = view.findViewById(R.id.shmspha);

        TextView tsbeh = view.findViewById(R.id.tsbeh);
        TextView tsbehcount = view.findViewById(R.id.tsbehcount);

        if (cachedTypeface != null) {
            tsbeh.setTypeface(cachedTypeface);
        }

        tsbeh.setText(lis.get(position).getTextpager1());
        tsbehcount.setText(lis.get(position).getTsbehcount1());
        container.addView(view);

        shmspha.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, " تطبيق ثواب (Thawap) ");
            sendIntent.putExtra(Intent.EXTRA_TEXT, lis.get(position).getTextpager1() + "\n" + "مشاركه نصوص من تطبيق ثواب  \n\n" + " https://play.google.com/store/apps/details?id=com.App.Thwaap\n");
            sendIntent.setType("text/plain");
            context.startActivity(Intent.createChooser(sendIntent, "مشاركه تطبيق ثواب  مع الاصدقاء:"));
            Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();
        });

        copyms.setOnClickListener(v -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("", lis.get(position).getTextpager1() + "\n" + "نصوص من تطبيق ثواب \n\n" + " https://play.google.com/store/apps/details?id=com.App.Thwaap\n");
            if (clipboard != null) {
                clipboard.setPrimaryClip(clip);
            }
            Toast.makeText(context, "تم نسخ النصوص ", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
