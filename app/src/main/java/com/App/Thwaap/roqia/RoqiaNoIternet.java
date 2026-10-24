package com.App.Thwaap.roqia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.App.Thwaap.R;
import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityRoqiaNoIternetBinding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;

public class RoqiaNoIternet extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRoqiaNoIternetBinding binding = ActivityRoqiaNoIternetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonUtils.setupEdgeToEdge(this, binding.getRoot());
        binding.backButton.setOnClickListener(v -> finish());
        AdManager.getInstance().loadInterstitial(this, getString(R.string.Biny2));
        getHandler().postDelayed(() -> AdManager.getInstance().showInterstitial(this), 4000);
    }
}
