package com.App.Thwaap;

import android.content.Intent;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import net.steamcrafted.materialiconlib.MaterialIconView;

public class Maintitle2 extends AppCompatActivity {
ShimmerTextView texthhh,textnumber;
MaterialIconView plus,minus,reloddd;
Shimmer ss;
TextView textcnter,textcnter1,textcnter2,textcnter3,textcnter4,textcnter5,textcnter6;
ImageView img_icon;
ImageView click;
private SlidrInterface slidr;
int a=0;
int c=18;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
         WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maintitle2);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.title2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

      slidr=Slidr.attach(this);
        texthhh=(ShimmerTextView)findViewById(R.id.texthhh);
        textnumber=(ShimmerTextView)findViewById(R.id.textnumber);
        textcnter=(TextView)findViewById(R.id.textcnter);
        textcnter1=(TextView)findViewById(R.id.textcnter1);
        textcnter2=(TextView)findViewById(R.id.textcnter2);
        textcnter3=(TextView)findViewById(R.id.textcnter3);
        textcnter4=(TextView)findViewById(R.id.textcnter4);
        textcnter5=(TextView)findViewById(R.id.textcnter5);
        textcnter6=(TextView)findViewById(R.id.textcnter6);
Typeface typeface=Typeface.createFromAsset(getAssets(),"6.otf");
        textcnter.setTypeface(typeface);
        textcnter1.setTypeface(typeface);
        textcnter2.setTypeface(typeface);
        textcnter3.setTypeface(typeface);
        textcnter4.setTypeface(typeface);
        textcnter5.setTypeface(typeface);
        textcnter6.setTypeface(typeface);
        click=(ImageView)findViewById(R.id.click);
        plus=(MaterialIconView)findViewById(R.id.plus);
        minus=(MaterialIconView)findViewById(R.id.minus);
        reloddd=(MaterialIconView)findViewById(R.id.reloddd);
        img_icon=(ImageView)findViewById(R.id.img_icon);
Intent intent=getIntent();
String title=intent.getStringExtra("title");
        ss=new Shimmer();
        ss.start(textnumber);
        ss.start(texthhh);
        reloddd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        a=0;
               textnumber.setText(String.valueOf(a));
            }
        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a++;
                textnumber.setText(String.valueOf(a));

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             if (c<50){
                 c++;}
            else Toast.makeText(Maintitle2.this, "لايمكن تكبير الخط اكبر من ذلك", Toast.LENGTH_SHORT).show();
                textcnter.setTextSize(c);
                textcnter1.setTextSize(c);
                textcnter2.setTextSize(c);
                textcnter3.setTextSize(c);
                textcnter4.setTextSize(c);
                textcnter5.setTextSize(c);
                textcnter6.setTextSize(c);

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c>13){
                    c--;}
                else Toast.makeText(Maintitle2.this, "لايمكن تصغير الخط اصغر من ذلك", Toast.LENGTH_SHORT).show();
                textcnter.setTextSize(c);
                textcnter1.setTextSize(c);
                textcnter2.setTextSize(c);
                textcnter3.setTextSize(c);
                textcnter4.setTextSize(c);
                textcnter5.setTextSize(c);
                textcnter6.setTextSize(c);

            }
        });


        switch (title){
            case "اذكار الصباح":
                texthhh.setText(title);
                textcnter.setText(R.string.azkars1);
                img_icon.setImageResource(R.drawable.icon_a);
                break;
            case "اذكار السفر":
                texthhh.setText(title);
                textcnter.setText(R.string.sfarazkar);
                img_icon.setImageResource(R.drawable.icon_d);
                break;
            case "اذكار المسجد":
                texthhh.setText(title);
                textcnter.setText(R.string.masgedazkar);
                textcnter1.setText(R.string.masgesazkar1);
                textcnter2.setText(R.string.masgedazkar2);
                textcnter3.setText(R.string.msgedazkar3);
                textcnter4.setText(R.string.msgedazkar4);
                textcnter5.setText(R.string.msgedazkar5);
                textcnter.setTextSize(20);
                textcnter2.setTextSize(20);
                textcnter4.setTextSize(20);
                textcnter.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                textcnter2.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                textcnter4.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                img_icon.setImageResource(R.drawable.icon_e);
                break;
            case "اذكار النوم":
                texthhh.setText(title);
                textcnter.setText(R.string.noom);
                textcnter1.setText(R.string.noom1);
                textcnter2.setText(R.string.noom2);
                textcnter3.setText(R.string.noom3);
                textcnter4.setText(R.string.noom4);
                textcnter5.setText(R.string.noom5);
                textcnter.setTextSize(20);
                textcnter2.setTextSize(20);
                textcnter4.setTextSize(20);
                textcnter.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                textcnter2.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                textcnter4.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                img_icon.setImageResource(R.drawable.icon_f);
                break;
            case "اذكارالمنزل":
                texthhh.setText(title);
                textcnter.setText(R.string.home);
                textcnter1.setText(R.string.home1);
                textcnter2.setText(R.string.home2);
                textcnter3.setText(R.string.home3);
                 textcnter.setTextSize(20);
                textcnter2.setTextSize(20);
                textcnter.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                textcnter2.setTextColor(this.getResources().getColor(R.color.blue_inactive));

                img_icon.setImageResource(R.drawable.icon_g);
                break;
            case "الاسماء الحسني":
                 textcnter.setText(R.string.hosna);
                 textcnter1.setText(R.string.hosna1);
                 textcnter2.setText(R.string.hosna2);
                 textcnter3.setText(R.string.hosna3);
                 textcnter4.setText(R.string.hosna4);
                 textcnter1.setTextSize(20);
                 textcnter3.setTextSize(20);
                 textcnter1.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                 textcnter3.setTextColor(this.getResources().getColor(R.color.blue_inactive));
                 img_icon.setImageResource(R.drawable.icon_i);
                  break;




        }
    }
}
