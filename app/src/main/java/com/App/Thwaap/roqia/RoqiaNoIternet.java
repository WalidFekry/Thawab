package com.App.Thwaap.roqia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityRoqiaNoIternetBinding;
import com.App.Thwaap.utils.CommonUtils;

public class RoqiaNoIternet extends BaseActivity {

    private ActivityRoqiaNoIternetBinding binding;

    public static Intent newIntent(Context context) {
        return new Intent(context, RoqiaNoIternet.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRoqiaNoIternetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonUtils.setupEdgeToEdge(this, binding.getRoot());
    }

    public void onBackClicked(View view) {
        onBackPressed();
    }
}
