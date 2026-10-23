package com.App.Thwaap;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.App.Thwaap.masbaha.MasbahaActivity;
import com.App.Thwaap.qoutes.QoutesActivity;
import com.App.Thwaap.roqia.RoqiaNoIternet;
import com.cleveroad.androidmanimation.LoadingAnimationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import net.steamcrafted.materialiconlib.MaterialIconView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView texta, textb, textc, textd, textg, texth, texti, texte, textf, roqia2, masbaha2, kenz2, qoutes;
    Typeface typeface;
    ShimmerTextView tface;
    TextView textcon;
    Shimmer shimmer;
    ImageView imga, imgb, imgc, imgd, imge, imgf, imgg, imgh, imgi, roqia, masbaha, kenz, qoutes2;
    String[] permission = new String[]{
            Manifest.permission.POST_NOTIFICATIONS
    };
    boolean isPermission = false;
    private final ActivityResultLauncher<String> requestPermissionLauncherNotification =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                isPermission = isGranted;
                if (!isGranted && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS)) {
                        showPermissionDialog();
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        textcon = findViewById(R.id.textcon);


        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        tface = findViewById(R.id.tface);
        shimmer = new Shimmer();
        shimmer.start(tface);
        typeface = Typeface.createFromAsset(getAssets(), "6.otf");

        tface.setTypeface(typeface);
        MaterialIconView abouut = findViewById(R.id.abouut);
        abouut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), about.class));

            }
        });

        texta = findViewById(R.id.texta);
        textb = findViewById(R.id.textb);
        textc = findViewById(R.id.textc);
        textd = findViewById(R.id.textd);
        textg = findViewById(R.id.textg);
        texth = findViewById(R.id.texth);
        texti = findViewById(R.id.texti);
        texte = findViewById(R.id.texte);
        textf = findViewById(R.id.textf);
        imga = findViewById(R.id.imga);
        imgb = findViewById(R.id.imgb);
        imgc = findViewById(R.id.imgc);
        imgd = findViewById(R.id.imgd);
        imge = findViewById(R.id.imge);
        imgf = findViewById(R.id.imgf);
        imgg = findViewById(R.id.imgg);
        imgh = findViewById(R.id.imgh);
        imgi = findViewById(R.id.imgi);
        roqia = findViewById(R.id.roqia);
        roqia2 = findViewById(R.id.roqia2);
        masbaha2 = findViewById(R.id.masbaha2);
        masbaha = findViewById(R.id.masbaha);
        qoutes = findViewById(R.id.qoutes);
        qoutes2 = findViewById(R.id.qoutes2);
        kenz2 = findViewById(R.id.kenz2);
        kenz = findViewById(R.id.kenz);


        texta.setTypeface(typeface);
        textb.setTypeface(typeface);
        textc.setTypeface(typeface);
        textd.setTypeface(typeface);
        texte.setTypeface(typeface);
        textf.setTypeface(typeface);
        textg.setTypeface(typeface);
        texti.setTypeface(typeface);
        texth.setTypeface(typeface);


        LoadingAnimationView loadingAnimationView = findViewById(R.id.anima);
        loadingAnimationView.startAnimation();


        imga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spa = new Intent(MainActivity.this, Maintitle3.class);
                spa.putExtra("title", "اذكار الصباح");
                startActivity(spa);
            }
        });

        imgb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainMSa.class);
                startActivity(intent);
            }
        });
        imgc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Maintspea.class);
                intent.putExtra("title", "تسآبيح");
                startActivity(intent);
            }
        });
        imgd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Maintitle2.class);
                intent.putExtra("title", "اذكار السفر");
                startActivity(intent);
            }
        });
        imge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Maintitle2.class);
                intent.putExtra("title", "اذكار المسجد");
                startActivity(intent);
            }
        });
        masbaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MasbahaActivity.class);
                intent.putExtra("title", "المسبحة");
                startActivity(intent);
            }
        });
        qoutes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QoutesActivity.class);
                intent.putExtra("title", "اقتباسات عشوائية");
                startActivity(intent);
            }
        });
        qoutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QoutesActivity.class);
                intent.putExtra("title", "اقتباسات عشوائية");
                startActivity(intent);
            }
        });
        imgf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Maintitle2.class);
                intent.putExtra("title", "اذكار النوم");
                startActivity(intent);
            }
        });
        imgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Maintitle2.class);
                intent.putExtra("title", "اذكارالمنزل");

                startActivity(intent);
            }
        });
        roqia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoqiaNoIternet.class);
                intent.putExtra("title", "الرقية الشرعية");

                startActivity(intent);
            }
        });
        imgh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        imgi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adeia = new Intent(MainActivity.this, Maintitle2.class);
                adeia.putExtra("title", "الاسماء الحسني");
                startActivity(adeia);
            }
        });

        kenz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.co/US34fsUZeW")));

            }
        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FirebaseMessaging.getInstance().subscribeToTopic("all");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            checkNotificationPermission();
        }
    }

    private void checkNotificationPermission() {
        if (!isPermission) {
            requestPermissionsNotification();
        }
    }

    private void requestPermissionsNotification() {
        if (ContextCompat.checkSelfPermission(this, permission[0]) == PackageManager.PERMISSION_GRANTED) {
            isPermission = true;
        } else {
            requestPermissionLauncherNotification.launch(permission[0]);
        }
    }

    private void showPermissionDialog() {
        new AlertDialog.Builder(this)
                .setMessage("من فضلك قم بالموافقة على الاشعارات لكي تصلك رسائل التفاؤل والإقتباسات من التطبيق ..")
                .setPositiveButton("الاعدادات", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package", getPackageName(), null);
                        intent.setData(uri);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("إلغاء", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.webside) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://application-muslim.blogspot.com/?m=1&fbclid=IwAR2JSI7LF7kK9hVfmyu50eoYLq_-dXmJlkWovnMRoGTxgXm_S7FFewa1PdI")));
        } else if (id == R.id.facegroub) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/groups/440403217380641")));
        } else if (id == R.id.ratee) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.App.Thwaap")));
        } else if (id == R.id.maktbtiplus) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://walid-fekry.com/maktbti-plus/"));
            startActivity(i);
        } else if (id == R.id.tele) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/App_Maktbti")));
        } else if (id == R.id.shareee) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, " تطبيق ثواب (Thawap) ");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "\n" +
                    "قمنا بتصميم البرنامج ليكون بسيط و مجاني ليضم أذكار الصباح و المساء مكتوبة و أذكار المسلم بدون إنترنت و ليساعدك على أن لا تنسى ذكر الله ابداً .\n \n" +
                    "تفضل رابط تطبيق ثواب  https://play.google.com/store/apps/details?id=com.App.Thwaap \n");
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "مشاركه تطبيق ثواب  مع الاصدقاء:"));

        } else if (id == R.id.appshare2) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/sharer.php?u=https%3A%2F%2Fplay.google.com%2Fstore%2Fapps%2Fdetails%3Fid%3Dcom.App.Thwaap")));


        } else if (id == R.id.about) {
            Intent intent = new Intent(MainActivity.this, about.class);
            startActivity(intent);

        } else if (id == R.id.mass) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto", "prowalidfekry@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "رسالة إلى مبرمج تطبيق ثواب 📲");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));


        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }


}
