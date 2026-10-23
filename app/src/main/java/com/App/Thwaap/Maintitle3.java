package com.App.Thwaap;

import android.os.Bundle;
import android.view.Window;

import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityMaintitle3Binding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

public class Maintitle3 extends BaseActivity {

    private ActivityMaintitle3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        CommonUtils.setupFullscreen(this);

        binding = ActivityMaintitle3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AdManager.getInstance().loadBanner(binding.pagerspah);

        List<item> lista = new ArrayList<>();
        lista.add(new item(getString(R.string.spage1), getString(R.string.spage2), getString(R.string.spage3), "1-20"));
        lista.add(new item(getString(R.string.spagea1), getString(R.string.spagea2), getString(R.string.spagea3), "2-20"));
        lista.add(new item(getString(R.string.spageb1), getString(R.string.spageb2), getString(R.string.spageb3), "3-20"));
        lista.add(new item(getString(R.string.spagec1), getString(R.string.spagec2), getString(R.string.spagec3), "4-20"));
        lista.add(new item(getString(R.string.spaged1), getString(R.string.spaged2), getString(R.string.spaged3), "5-20"));
        lista.add(new item(getString(R.string.spagee1), getString(R.string.spagee2), getString(R.string.spagee3), "6-20"));
        lista.add(new item(getString(R.string.spageh1), getString(R.string.spageh2), getString(R.string.spageh3), "7-20"));
        lista.add(new item(getString(R.string.spagei1), getString(R.string.spagei2), getString(R.string.spagei3), "8-20"));
        lista.add(new item(getString(R.string.spagej1), getString(R.string.spagej2), getString(R.string.spagej3), "9-20"));
        lista.add(new item(getString(R.string.spagek1), getString(R.string.spagek2), getString(R.string.spagek3), "10-20"));
        lista.add(new item(getString(R.string.spagel1), getString(R.string.spagel2), getString(R.string.spagel3), "11-20"));
        lista.add(new item(getString(R.string.spagem1), getString(R.string.spagem2), getString(R.string.spagem3), "12-20"));
        lista.add(new item(getString(R.string.spagen1), getString(R.string.spagen2), getString(R.string.spagen3), "13-20"));
        lista.add(new item(getString(R.string.spagep1), getString(R.string.spagep2), getString(R.string.spagep3), "14-20"));
        lista.add(new item(getString(R.string.spageq1), getString(R.string.spageq2), getString(R.string.spageq3), "15-20"));
        lista.add(new item(getString(R.string.spagew1), getString(R.string.spagew2), getString(R.string.spagew3), "16-20"));
        lista.add(new item(getString(R.string.spageww1), getString(R.string.spageww2), getString(R.string.spageww3), "17-20"));
        lista.add(new item(getString(R.string.spagwww1), getString(R.string.spagwww2), getString(R.string.spagwww3), "18-20"));
        lista.add(new item(getString(R.string.spagewwww1), getString(R.string.spagewwww2), getString(R.string.spagewwww3), "19-20"));
        lista.add(new item(getString(R.string.spagez1), getString(R.string.spagez2), getString(R.string.spagez3), "20-20"));

        Adapterpager1 adapterpager1 = new Adapterpager1(this, lista);
        binding.pager1.setAdapter(adapterpager1);

        AdManager.getInstance().loadInterstitial(this, getString(R.string.Biny2));
        getHandler().postDelayed(() -> AdManager.getInstance().showInterstitial(this), 4000);
    }
}
