package com.App.Thwaap;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.App.Thwaap.databinding.ActivityMaintitle2Binding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;
import com.r0adkll.slidr.Slidr;
import com.romainpiel.shimmer.Shimmer;

public class Maintitle2 extends AppCompatActivity {

    private ActivityMaintitle2Binding binding;
    private int clickCount = 0;
    private int textSize = 18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        CommonUtils.setupFullscreen(this);

        binding = ActivityMaintitle2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AdManager.getInstance().loadBanner(binding.title2);

        Slidr.attach(this);

        try {
            Typeface typeface = Typeface.createFromAsset(getAssets(), "6.otf");
            binding.textcnter.setTypeface(typeface);
            binding.textcnter1.setTypeface(typeface);
            binding.textcnter2.setTypeface(typeface);
            binding.textcnter3.setTypeface(typeface);
            binding.textcnter4.setTypeface(typeface);
            binding.textcnter5.setTypeface(typeface);
            binding.textcnter6.setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Shimmer ss = new Shimmer();
        ss.start(binding.textnumber);
        ss.start(binding.texthhh);

        binding.reloddd.setOnClickListener(v -> {
            clickCount = 0;
            binding.textnumber.setText(String.valueOf(clickCount));
        });

        binding.click.setOnClickListener(v -> {
            clickCount++;
            binding.textnumber.setText(String.valueOf(clickCount));
        });

        binding.plus.setOnClickListener(v -> {
            if (textSize < 50) {
                textSize++;
            } else {
                Toast.makeText(this, "لايمكن تكبير الخط اكبر من ذلك", Toast.LENGTH_SHORT).show();
            }
            updateTextSize();
        });

        binding.minus.setOnClickListener(v -> {
            if (textSize > 13) {
                textSize--;
            } else {
                Toast.makeText(this, "لايمكن تصغير الخط اصغر من ذلك", Toast.LENGTH_SHORT).show();
            }
            updateTextSize();
        });

        Intent intent = getIntent();
        String title = intent != null ? intent.getStringExtra("title") : "";
        if (title == null) title = "";

        setupContent(title);
    }

    private void updateTextSize() {
        binding.textcnter.setTextSize(textSize);
        binding.textcnter1.setTextSize(textSize);
        binding.textcnter2.setTextSize(textSize);
        binding.textcnter3.setTextSize(textSize);
        binding.textcnter4.setTextSize(textSize);
        binding.textcnter5.setTextSize(textSize);
        binding.textcnter6.setTextSize(textSize);
    }

    private void setupContent(String title) {
        int blueColor = ContextCompat.getColor(this, R.color.blue_inactive);

        switch (title) {
            case "اذكار الصباح":
                binding.texthhh.setText(title);
                binding.textcnter.setText(R.string.azkars1);
                binding.imgIcon.setImageResource(R.drawable.icon_a);
                break;
            case "اذكار السفر":
                binding.texthhh.setText(title);
                binding.textcnter.setText(R.string.sfarazkar);
                binding.imgIcon.setImageResource(R.drawable.icon_d);
                break;
            case "اذكار المسجد":
                binding.texthhh.setText(title);
                binding.textcnter.setText(R.string.masgedazkar);
                binding.textcnter1.setText(R.string.masgesazkar1);
                binding.textcnter2.setText(R.string.masgedazkar2);
                binding.textcnter3.setText(R.string.msgedazkar3);
                binding.textcnter4.setText(R.string.msgedazkar4);
                binding.textcnter5.setText(R.string.msgedazkar5);
                binding.textcnter.setTextSize(20);
                binding.textcnter2.setTextSize(20);
                binding.textcnter4.setTextSize(20);
                binding.textcnter.setTextColor(blueColor);
                binding.textcnter2.setTextColor(blueColor);
                binding.textcnter4.setTextColor(blueColor);
                binding.imgIcon.setImageResource(R.drawable.icon_e);
                break;
            case "اذكار النوم":
                binding.texthhh.setText(title);
                binding.textcnter.setText(R.string.noom);
                binding.textcnter1.setText(R.string.noom1);
                binding.textcnter2.setText(R.string.noom2);
                binding.textcnter3.setText(R.string.noom3);
                binding.textcnter4.setText(R.string.noom4);
                binding.textcnter5.setText(R.string.noom5);
                binding.textcnter.setTextSize(20);
                binding.textcnter2.setTextSize(20);
                binding.textcnter4.setTextSize(20);
                binding.textcnter.setTextColor(blueColor);
                binding.textcnter2.setTextColor(blueColor);
                binding.textcnter4.setTextColor(blueColor);
                binding.imgIcon.setImageResource(R.drawable.icon_f);
                break;
            case "اذكارالمنزل":
                binding.texthhh.setText(title);
                binding.textcnter.setText(R.string.home);
                binding.textcnter1.setText(R.string.home1);
                binding.textcnter2.setText(R.string.home2);
                binding.textcnter3.setText(R.string.home3);
                binding.textcnter.setTextSize(20);
                binding.textcnter2.setTextSize(20);
                binding.textcnter.setTextColor(blueColor);
                binding.textcnter2.setTextColor(blueColor);
                binding.imgIcon.setImageResource(R.drawable.icon_g);
                break;
            case "الاسماء الحسني":
                binding.textcnter.setText(R.string.hosna);
                binding.textcnter1.setText(R.string.hosna1);
                binding.textcnter2.setText(R.string.hosna2);
                binding.textcnter3.setText(R.string.hosna3);
                binding.textcnter4.setText(R.string.hosna4);
                binding.textcnter1.setTextSize(20);
                binding.textcnter3.setTextSize(20);
                binding.textcnter1.setTextColor(blueColor);
                binding.textcnter3.setTextColor(blueColor);
                binding.imgIcon.setImageResource(R.drawable.icon_i);
                break;
            default:
                break;
        }
    }
}
