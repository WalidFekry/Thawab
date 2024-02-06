package com.App.Thwaap.roqia;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.App.Thwaap.R;
import com.App.Thwaap.base.BaseActivity;

public class RoqiaNoIternet extends BaseActivity {

    private final String TAG = "TAG";

    public static Intent newIntent(Context context) {
        return new Intent(context, RoqiaNoIternet.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roqia_no_iternet);
    }


    public void onBackClicked(View view) {
        onBackPressed();
    }
}