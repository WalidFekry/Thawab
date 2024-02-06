package com.App.Thwaap;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class about extends AppCompatActivity {
    ShimmerTextView textthaeap;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,txtapp;
    Shimmer s;
    CardView facebookc,twiterc,gmmailc,shearc,massngerc,rratec,googleplayc,pric;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_about);
        textthaeap=(ShimmerTextView)findViewById(R.id.textthaeap);
        txtapp=(TextView)findViewById(R.id.txtapp);
         t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
        t5=(TextView)findViewById(R.id.t5);
        t6=(TextView)findViewById(R.id.t6);
        t7=(TextView)findViewById(R.id.t7);
        t8=(TextView)findViewById(R.id.t8);
        t9=(TextView)findViewById(R.id.t9);
        facebookc=(CardView)findViewById(R.id.facebookc);
        twiterc=(CardView)findViewById(R.id.twiterc);
        gmmailc=(CardView)findViewById(R.id.gmmailc);
        shearc=(CardView)findViewById(R.id.shearc);
        massngerc=(CardView)findViewById(R.id.massngerc);
        rratec=(CardView)findViewById(R.id.rratec);
        googleplayc=(CardView)findViewById(R.id.googleplayc);
        pric=(CardView)findViewById(R.id.pric);
        Typeface typeface=Typeface.createFromAsset(getAssets(),"6.otf");
        Typeface typeface1=Typeface.createFromAsset(getAssets(),"ggg.ttf");
         textthaeap.setTypeface(typeface1);
        txtapp.setTypeface(typeface);
        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        t4.setTypeface(typeface);
        t5.setTypeface(typeface);
        t6.setTypeface(typeface);
        t7.setTypeface(typeface);
        t8.setTypeface(typeface);
        t9.setTypeface(typeface);
        s=new Shimmer();
        s.start(textthaeap);
        facebookc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/Waleed.Fikri")));



            }
        });
        twiterc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/ProWalidFekry")));
            }
        });
        gmmailc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","prowalidkfekry@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "رسالة إلى مطور تطبيق ثواب 📲");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "اكتب رسالتك هنا");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            }
        });
        shearc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_SUBJECT," تطبيق ثواب (Thawap) ");
                sendIntent.putExtra(Intent.EXTRA_TEXT,"\n" +
                        "قمنا بتصميم البرنامج ليكون بسيط و مجاني ليضم أذكار الصباح و المساء مكتوبة و أذكار المسلم بدون إنترنت و ليساعدك على أن لا تنسى ذكر الله ابداً .\n \n" +
                        "تفضل رابط تطبيق ثواب  https://t.co/4VQlA6AZrH \n");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent,"مشاركه تطبيق ثواب  مع الاصدقاء:"));

            }
        });
        massngerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.me/App.Qurani")));
            }
        });
        rratec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/4VQlA6AZrH" )));

            }
        });

        googleplayc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/US34fsUZeW" )));
            }
        });

        pric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://sites.google.com/view/appthawap/home?fbclid=IwAR1Zlt7zvBwb1j1iTKSj75nG4xnj7e3SdS0djhhzHFJDvnnFaW0YTGPdjgE")));
            }
        });

    }
}
