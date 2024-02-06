package com.App.Thwaap;

import android.content.Intent;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Maintitle1 extends AppCompatActivity {

TextView t1,t2,t3,t4;
ImageView iconnn;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_maintitle1);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adstitle1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        iconnn=(ImageView)findViewById(R.id.iconnn);
        t1=(TextView)findViewById(R.id.t1);
        t2=(TextView)findViewById(R.id.t2);
        t3=(TextView)findViewById(R.id.t3);
        t4=(TextView)findViewById(R.id.t4);
Typeface typeface=Typeface.createFromAsset(getAssets(),"6.otf");
        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        t4.setTypeface(typeface);
        Intent intent=getIntent();
        String tittle=intent.getStringExtra("title");
      switch (tittle){
          case "أذكار الاستيقاظ من النوم":
              t1.setText(R.string.azkarestkas1);
              t2.setText(R.string.azkarestkas2);
              t3.setText(R.string.azkarestkas3);
              t4.setText(R.string.azkarestkas4);

              iconnn.setImageResource(R.drawable.icon_f);
              break;
          case "دعاء الوضوء":
              t1.setText(R.string.wdo1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.wdo2);
              t3.setText(R.string.wdo3);

              iconnn.setImageResource(R.drawable.img_m9);
              break;
          case "الدعاء عند سماع الآذان":
              t1.setText(R.string.azan1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.azan2);
              iconnn.setImageResource(R.drawable.img_m5);
              break;
          case "أدعية استفتاح الصلاة":
              t1.setText(R.string.sla1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.sla2);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case "أدعية الركوع في الصلاة":
              t1.setText(R.string.sll1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.sll2);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case"أدعية الرفع من الركوع":
              t1.setText(R.string.slll1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.slll2);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case "أدعية السجود":
              t1.setText(R.string.saal1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.saal2);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case "أدعية الجلوس بين السجدتين ":
              t1.setText(R.string.sgda1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.sgda2);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case "دعاء سجود التلاوة":
              t1.setText(R.string.tlwa1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.tlwa2);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case "أدعية بعد التشهد الأخير وقبل السلام":
              t1.setText(R.string.tsh1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.tsh2);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case "أدعية للوالدين":
              t1.setText(R.string.wlden1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.wlden2);
              t3.setText(R.string.wlden3);
              iconnn.setImageResource(R.drawable.img_m2);
              break;
          case"أدعية للمتوفى (ذكور)":
              t1.setText(R.string.mtwaf1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.mtwaf2);
              iconnn.setImageResource(R.drawable.img_m3);
              break;
          case"أدعية للمتوفية (إناث)":
              t1.setText(R.string.mtwen1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.mtwen2);
              iconnn.setImageResource(R.drawable.img_m3);
              break;
          case"أدعية للميّت الطفل الصغير (ذكر أو أنثى)":
              t1.setText(R.string.mt1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.mt2);
              iconnn.setImageResource(R.drawable.img_m3);
              break;
          case "أالدّعاء للميّت في  صّلاة الجنازة":
              t1.setText(R.string.jnaja1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.jnaja2);
              iconnn.setImageResource(R.drawable.img_m3);
              break;
          case "دعاء يوم الجمعه":
              t1.setText(R.string.jma1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.jma2);
              iconnn.setImageResource(R.drawable.img_m10);
              break;

          case"دعاء الرزق":
              t1.setText(R.string.rzq1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.rzq2);
              iconnn.setImageResource(R.drawable.img_m7);
              break;
          case"الدعاء للمريض بالشفاء":
              t1.setText(R.string.mar1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.mar2);
              iconnn.setImageResource(R.drawable.img_m8);
              break;
          case "ماهي الاستخارة و حكمها":
              t1.setText(R.string.is1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.is2);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case "متى يحتاج العبد إلى صلاة الاستخارة":
              t1.setText(R.string.is1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.is2);
              t3.setText(R.string.is3);
              t4.setText(R.string.is4);
              iconnn.setImageResource(R.drawable.img_m6);
              break;
          case "دعاء صلاة الإستخارة":
                t1.setText(R.string.sk1);
                t1.setTextSize(25);
                t2.setTextSize(23);
                t2.setText(R.string.sk2);
               iconnn.setImageResource(R.drawable.img_m6);
              break;
            case "دعاء السفر":
              t1.setText(R.string.msm1);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.msm2);
              iconnn.setImageResource(R.drawable.icon_d);
              break;

          case"أدعية مأثورة في شهر رمضان" :
              t1.setText(R.string.ss1);
              t2.setText(R.string.ss2);
              t3.setText(R.string.ss3);
              t4.setText(R.string.ss4);
              t1.setTextSize(25);
              t2.setTextSize(23);
              t2.setText(R.string.msm2);
              iconnn.setImageResource(R.drawable.img_m4);
              break;
          case"نصائح رمضانية" :
              t1.setText(R.string.nsea1);
              t2.setText(R.string.nsea2);
              t2.setTextSize(25);
              t1.setTextSize(23);
              iconnn.setImageResource(R.drawable.img_m4);
              break;
          case "دعاء العشر الأواخر من رمضان":
              t1.setText(R.string.fdl1);
              t2.setText(R.string.fdl2);
              t3.setText(R.string.fdl3);
              t4.setText(R.string.fdl4);
              t2.setTextSize(25);
              t1.setTextSize(23);
              iconnn.setImageResource(R.drawable.img_m4);
              break;

          case "دعاء ليلة القدر":
              t1.setText(R.string.qdr1);
              t2.setText(R.string.qdr2);
              t3.setText(R.string.qdr3);
              t4.setText(R.string.qdr4);
              t2.setTextSize(25);
              t1.setTextSize(24);
              t2.setTextSize(24);
              t1.setTextSize(24);
              iconnn.setImageResource(R.drawable.img_m4);
              break;
          case "الرُّقية الشرعية من القرآن والسنة":
              t1.setText(R.string.r1);
              t2.setText(R.string.r2);
              t1.setTextSize(24);
              t2.setTextSize(25);
              iconnn.setImageResource(R.drawable.img_m4);
              break;
          case "الرُّقية الشرعية من القرآن الكريم":
              t1.setText(R.string.rr1);
              t2.setText(R.string.rr2);
              t1.setTextSize(25);
              t2.setTextSize(24);
              iconnn.setImageResource(R.drawable.img_m4);
              break;
          case "الرُّقية الشرعية من السنة النبوية":
              t1.setText(R.string.rrr1);
              t2.setText(R.string.rrr2);
              t1.setTextSize(25);
              t2.setTextSize(24);
              iconnn.setImageResource(R.drawable.img_m4);
              break;












      }



    }
}
