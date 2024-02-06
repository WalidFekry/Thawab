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

public class Adapterpage2 extends PagerAdapter {
    public int n=0;

    List<item_pager2>list2;
    Context context;

    public Adapterpage2(List<item_pager2> list2, Context context) {
        this.list2 = list2;
        this.context = context;
    }

    LayoutInflater inflater;

    Typeface typeface;

    public Adapterpage2(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return list2.size();



    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return  (view==o);

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final ShimmerTextView cccu;
        MaterialIconView relodmm,share2,copt2;
        Shimmer s=new Shimmer();


        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.design_pager2,container,false);
        LinearLayout linearLayout=(LinearLayout)view.findViewById(R.id.linearrr2);
        CardView car=(CardView)view.findViewById(R.id.car2);
        cccu =(ShimmerTextView)view.findViewById(R.id.cccu);
        share2=(MaterialIconView)view.findViewById(R.id.share2);
        copt2=(MaterialIconView)view.findViewById(R.id.copt2);
        s.start(cccu);


        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
                cccu.setText(String.valueOf(n));


            }
        });

        relodmm=(MaterialIconView)view.findViewById(R.id.relodmm);
        relodmm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=0;
                cccu.setText(String.valueOf(n));
            }
        });

        TextView textpagera=(TextView)view.findViewById(R.id.textpagerm1);
        TextView textpagerb=(TextView)view.findViewById(R.id.textpagerm2);
        TextView textpagerc=(TextView)view.findViewById(R.id.textpagerm3);
        TextView textpagess=(TextView)view.findViewById(R.id.textpage2);
        typeface= Typeface.createFromAsset(view.getContext().getAssets(),"6.otf");
        textpagera.setTypeface(typeface);
        textpagerb.setTypeface(typeface);
        textpagerc.setTypeface(typeface);
        textpagera.setText(list2.get(position).getTextpagerm1());
        textpagerb.setText(list2.get(position).getTextpagerm2());
        textpagerc.setText(list2.get(position).getTextpagerm3());
        textpagess.setText(list2.get(position).getTextpage2());
        container.addView(view);

        copt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager)context. getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("",list2.get(position).getTextpagerm1()+"\n"+list2.get(position).getTextpagerm2()+"\n"+list2.get(position).getTextpagerm3()+"\n"+""+ "اذكار المساء من تطبيق ثواب \n" +"\n"+
                        "\n"+   " https://t.co/4VQlA6AZrH\n");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "تم نسخ النصوص ", Toast.LENGTH_SHORT).show();

            }
        });
        share2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT," تطبيق ثواب (Thawap) ");
                sendIntent.putExtra(Intent.EXTRA_TEXT,list2.get(position).getTextpagerm1()+"\n"+list2.get(position).getTextpagerm2()+"\n"+list2.get(position).getTextpagerm3()+"\n"+ "مشاركه نصوص من تطبيق ثواب  \n" +"\n"+ "\n"+" https://t.co/4VQlA6AZrH\n");
                sendIntent.setType("text/plain");
                context.startActivity(Intent.createChooser(sendIntent,"مشاركه تطبيق ثواب  مع الاصدقاء:"));
                Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}

