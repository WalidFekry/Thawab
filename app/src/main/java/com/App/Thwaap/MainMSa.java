package com.App.Thwaap;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.App.Thwaap.databinding.ActivityMainMsaBinding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class MainMSa extends AppCompatActivity {

    private ActivityMainMsaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainMsaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        CommonUtils.setupEdgeToEdge(this, binding.getRoot());

        AdManager.getInstance().loadBanner(binding.adsmsa);

        List<item_pager2> list2 = new ArrayList<>();
        list2.add(new item_pager2(getString(R.string.azm1), getString(R.string.azm2), getString(R.string.azm3), "1-13"));
        list2.add(new item_pager2(getString(R.string.azm4), getString(R.string.azm5), getString(R.string.azm6), "2-13"));
        list2.add(new item_pager2(getString(R.string.azm7), getString(R.string.azm8), getString(R.string.azm9), "3-13"));
        list2.add(new item_pager2(getString(R.string.azm10), getString(R.string.azm11), getString(R.string.azm12), "4-13"));
        list2.add(new item_pager2(getString(R.string.azm13), getString(R.string.azm14), getString(R.string.azm15), "5-13"));
        list2.add(new item_pager2(getString(R.string.azm16), getString(R.string.azm17), getString(R.string.azm18), "6-13"));
        list2.add(new item_pager2(getString(R.string.azm19), getString(R.string.azm20), getString(R.string.azm21), "7-13"));
        list2.add(new item_pager2(getString(R.string.azm22), getString(R.string.azm23), getString(R.string.azm24), "8-13"));
        list2.add(new item_pager2(getString(R.string.azm25), getString(R.string.azm26), getString(R.string.azm27), "9-13"));
        list2.add(new item_pager2(getString(R.string.azm28), getString(R.string.azm29), getString(R.string.azm30), "10-13"));
        list2.add(new item_pager2(getString(R.string.azm31), getString(R.string.azm32), getString(R.string.azm33), "11-13"));
        list2.add(new item_pager2(getString(R.string.azm34), getString(R.string.azm35), getString(R.string.azm36), "12-13"));
        list2.add(new item_pager2(getString(R.string.azm37), getString(R.string.azm38), getString(R.string.azm39), "13-13"));

        Adapterpage2 adapterpager2 = new Adapterpage2(list2, this);
        binding.pager2.setAdapter(adapterpager2);
    }
}
