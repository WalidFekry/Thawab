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

public class Adapterpager1 extends PagerAdapter {

    private final Context context;
    private final List<item> lista;
    private static Typeface cachedTypeface;
    public int n = 0;

    public Adapterpager1(Context context, List<item> lista) {
        this.context = context;
        this.lista = lista;
        if (cachedTypeface == null && context != null) {
            cachedTypeface = Typeface.createFromAsset(context.getAssets(), "6.otf");
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
        container.removeView((LinearLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        final ShimmerTextView ccu;
        MaterialIconView relod, contentccc, sharetext;
        Shimmer s = new Shimmer();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.design_pager1, container, false);

        CardView car = view.findViewById(R.id.car);
        ccu = view.findViewById(R.id.ccu);
        s.start(ccu);

        car.setOnClickListener(v -> {
            n++;
            ccu.setText(String.valueOf(n));
        });

        relod = view.findViewById(R.id.relod);
        relod.setOnClickListener(v -> {
            n = 0;
            ccu.setText(String.valueOf(n));
        });

        contentccc = view.findViewById(R.id.contentccc);
        sharetext = view.findViewById(R.id.sharetext);

        TextView textpagera = view.findViewById(R.id.te);
        TextView textpagerb = view.findViewById(R.id.tee);
        TextView textpagerc = view.findViewById(R.id.teee);
        TextView textpagess = view.findViewById(R.id.teeee);

        if (cachedTypeface != null) {
            textpagera.setTypeface(cachedTypeface);
            textpagerb.setTypeface(cachedTypeface);
            textpagerc.setTypeface(cachedTypeface);
        }

        textpagera.setText(lista.get(position).getTe());
        textpagerb.setText((lista.get(position).getTee()));
        textpagerc.setText((lista.get(position).getTeee()));
        textpagess.setText((lista.get(position).getTeeee()));
        container.addView(view);

        contentccc.setOnClickListener(v -> {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("", lista.get(position).getTe() + "\n" + lista.get(position).getTee() + "\n" + lista.get(position).getTeee() + "\n" + "نصوص من تطبيق ثواب \n\n" + " https://play.google.com/store/apps/details?id=com.App.Thwaap\n");
            if (clipboard != null) {
                clipboard.setPrimaryClip(clip);
            }
            Toast.makeText(context, "تم نسخ النصوص ", Toast.LENGTH_SHORT).show();
        });

        sharetext.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, " تطبيق ثواب (Thawap) ");
            sendIntent.putExtra(Intent.EXTRA_TEXT, lista.get(position).getTe() + "\n" + lista.get(position).getTee() + "\n" + lista.get(position).getTeee() + "\n" + "مشاركه نصوص من تطبيق ثواب  \n\n" + " https://play.google.com/store/apps/details?id=com.App.Thwaap\n");
            sendIntent.setType("text/plain");
            context.startActivity(Intent.createChooser(sendIntent, "مشاركه تطبيق ثواب  مع الاصدقاء:"));
            Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
