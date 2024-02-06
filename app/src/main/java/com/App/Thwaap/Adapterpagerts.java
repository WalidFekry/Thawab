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
    Context context;
    List<itempagerms>lis;

    public Adapterpagerts(Context context, List<itempagerms> lis) {
        this.context = context;
        this.lis = lis;
    }

    public int n=0;
    Typeface typeface;

    LayoutInflater inflater;




    @Override
    public int getCount() {
       return lis.size();



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
        final ShimmerTextView tsb;
        MaterialIconView relodts,copyms,shmspha;
        Shimmer s=new Shimmer();

           inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.designtsbeh,container,false);
            CardView carttt=(CardView)view.findViewById(R.id.carttt) ;
            tsb =(ShimmerTextView)view.findViewById(R.id.tsb);
            s.start(tsb);


        carttt.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                n++;
                tsb.setText(String.valueOf(n));


            }
        });

        relodts=(MaterialIconView)view.findViewById(R.id.relodts);
        relodts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                           n=0;

                tsb.setText(String.valueOf(n));
            }
        });
        copyms=(MaterialIconView)view.findViewById(R.id.copyms);
        shmspha=(MaterialIconView)view.findViewById(R.id.shmspha);

           TextView tsbeh=(TextView)view.findViewById(R.id.tsbeh);
           TextView tsbehcount=(TextView)view.findViewById(R.id.tsbehcount) ;
           typeface=Typeface.createFromAsset(view.getContext().getAssets(),"6.otf");
           tsbeh.setTypeface(typeface);
           tsbeh.setText(lis.get(position).getTextpager1());
           tsbehcount.setText(lis.get(position).getTsbehcount1());
           container.addView(view);
        shmspha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT," تطبيق ثواب (Thawap) ");
                sendIntent.putExtra(Intent.EXTRA_TEXT,lis.get(position).getTextpager1()+"\n"+ "مشاركه نصوص من تطبيق ثواب  \n" +"\n"+ "\n"+" https://t.co/4VQlA6AZrH\n");
                sendIntent.setType("text/plain");
                context.startActivity(Intent.createChooser(sendIntent,"مشاركه تطبيق ثواب  مع الاصدقاء:"));
                Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();

            }
        });
        copyms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager)context. getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("",lis.get(position).getTextpager1()+"\n"+""+ "نصوص من تطبيق ثواب \n" +"\n"+
                        "\n"+   " https://t.co/4VQlA6AZrH\n");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "تم نسخ النصوص ", Toast.LENGTH_SHORT).show();



            }
        });
             return view;
    }
}


