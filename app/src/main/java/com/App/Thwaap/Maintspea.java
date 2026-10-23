package com.App.Thwaap;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.App.Thwaap.databinding.ActivityMaintspeaBinding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class Maintspea extends AppCompatActivity {

    private ActivityMaintspeaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        CommonUtils.setupFullscreen(this);

        binding = ActivityMaintspeaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AdManager.getInstance().loadBanner(binding.adsspha);

        List<itempagerms> lis = new ArrayList<>();
        lis.add(new itempagerms(getString(R.string.tst2), "1-5"));
        lis.add(new itempagerms(getString(R.string.tst3), "2-5"));
        lis.add(new itempagerms(getString(R.string.tst4), "3-5"));
        lis.add(new itempagerms(getString(R.string.tst6), "4-5"));
        lis.add(new itempagerms(getString(R.string.tst7), "5-5"));

        Adapterpagerts adapterpager1 = new Adapterpagerts(this, lis);
        binding.tsbeh.setAdapter(adapterpager1);
    }
}
