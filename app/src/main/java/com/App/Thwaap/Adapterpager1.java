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

    Context context;
  List<item>lista;

    public Adapterpager1(Context context, List<item> lista) {
        this.context = context;
        this.lista = lista;
    }

    public int n=0;
   Typeface typeface;

    LayoutInflater inflater;
    TextView textpagera,textpagerb,textpagerc,textpagess;




    @Override
    public int getCount() {
      return   lista.size();



    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return   (view==o);

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((LinearLayout)object);


    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        final ShimmerTextView ccu;
        MaterialIconView relod,contentccc,sharetext;
        Shimmer s=new Shimmer();

        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view=inflater.inflate(R.layout.design_pager1,container,false);


        CardView car=(CardView)view.findViewById(R.id.car);
        ccu =(ShimmerTextView)view.findViewById(R.id.ccu);
        s.start(ccu);


        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n++;
            ccu.setText(String.valueOf(n));


            }
        });

       relod=(MaterialIconView)view.findViewById(R.id.relod);
       relod.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
           n=0;
            ccu.setText(String.valueOf(n));
           }
       });
        contentccc=(MaterialIconView)view.findViewById(R.id.contentccc);
        sharetext=(MaterialIconView)view.findViewById(R.id.sharetext);



         textpagera =(TextView)view.findViewById(R.id.te);
         textpagerb=(TextView)view.findViewById(R.id.tee);
         textpagerc=(TextView)view.findViewById(R.id.teee);
         textpagess=(TextView)view.findViewById(R.id.teeee);
        typeface=Typeface.createFromAsset(view.getContext().getAssets(),"6.otf");
          textpagera.setTypeface(typeface);
          textpagerb.setTypeface(typeface);
          textpagerc.setTypeface(typeface);
          textpagera.setText(lista.get(position).getTe());
          textpagerb.setText((lista.get(position).getTee()));
          textpagerc.setText((lista.get(position).getTeee()));
          textpagess.setText((lista.get(position).getTeeee()));
          container.addView(view);

        contentccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager)context. getSystemService(Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("",lista.get(position).getTe()+"\n"+lista.get(position).getTee()+"\n"+lista.get(position).getTeee()+"\n"+""+ "نصوص من تطبيق ثواب \n" +"\n"+
                        "\n"+   " https://t.co/4VQlA6AZrH\n");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(context, "تم نسخ النصوص ", Toast.LENGTH_SHORT).show();



            }


        });
        sharetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT," تطبيق ثواب (Thawap) ");
                sendIntent.putExtra(Intent.EXTRA_TEXT,lista.get(position).getTe()+"\n"+lista.get(position).getTee()+"\n"+lista.get(position).getTeee()+"\n"+ "مشاركه نصوص من تطبيق ثواب  \n" +"\n"+ "\n"+" https://t.co/4VQlA6AZrH\n");
                sendIntent.setType("text/plain");
              context.startActivity(Intent.createChooser(sendIntent,"مشاركه تطبيق ثواب  مع الاصدقاء:"));
                Toast.makeText(context, "جزاك الله خيرا لمشاركه التطبيق", Toast.LENGTH_SHORT).show();
            }
        });




        return view;
    }






}
