package com.App.Thwaap.qoutes;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.App.Thwaap.R;
import com.App.Thwaap.base.BaseActivity;
import com.App.Thwaap.databinding.ActivityQoutesBinding;
import com.App.Thwaap.utils.AdManager;
import com.App.Thwaap.utils.CommonUtils;
import com.App.Thwaap.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QoutesActivity extends BaseActivity implements Adaptersada.OnMessengerClick {
    private static final String TAG = "QoutesActivity";
    private static final String API_URL = "https://post.walid-fekry.com/auto_notification/auto_notification_apps/api_post_apps.php";

    private ActivityQoutesBinding binding;
    private List<new_item_post> list2;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        CommonUtils.setupFullscreen(this);

        binding = ActivityQoutesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (binding.backButton != null) {
            binding.backButton.setOnClickListener(v -> finish());
        }

        if (binding.adsContainer != null) {
            binding.adsContainer.setVisibility(View.VISIBLE);
        }

        AdManager.getInstance().loadBanner(binding.rsttfal);
        AdManager.getInstance().loadInterstitial(this, getString(R.string.Biny1));
        getHandler().postDelayed(() -> AdManager.getInstance().showInterstitial(this), 4000);

        if (!NetworkUtils.isConnected(this)) {
            Toast.makeText(this, "لمزيد من الرسائل المتجدده يوميا تاكد انك متصل بالانترنت", Toast.LENGTH_LONG).show();
        }

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        binding.rec2.setLayoutManager(mLayoutManager);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), R.anim.layout_anmation);
        binding.rec2.setLayoutAnimation(animation);

        fetchQuotesData();
    }

    private void fetchQuotesData() {
        executorService.execute(() -> {
            boolean success = false;
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL(API_URL);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(10000);
                urlConnection.setReadTimeout(10000);
                int statusCode = urlConnection.getResponseCode();
                if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
                    parseResult(response.toString());
                    success = true;
                }
            } catch (Exception e) {
                Log.e(TAG, "Error fetching data: " + e.getMessage());
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            final boolean isSuccess = success;
            mainHandler.post(() -> {
                if (isFinishing() || isDestroyed()) return;
                onDataFetched(isSuccess);
            });
        });
    }

    private void parseResult(String result) {
        try {
            JSONObject response = new JSONObject(result);
            JSONArray post = response.optJSONArray("post");
            list2 = new ArrayList<>();
            if (post != null) {
                for (int i = 0; i < post.length(); i++) {
                    JSONObject posts = post.optJSONObject(i);
                    if (posts != null) {
                        String title = posts.optString("title");
                        String imageurl = posts.optString("imageurl");
                        int id = posts.optInt("id");
                        String createdAt = posts.optString("created_at");
                        list2.add(new new_item_post(title, imageurl, id, createdAt));
                    }
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "JSON parsing error: " + e.getMessage());
        }
    }

    private void onDataFetched(boolean success) {
        if (success && list2 != null && !list2.isEmpty()) {
            Adaptersada adaptersada = new Adaptersada(list2, this);
            binding.rec2.setAdapter(adaptersada);
        } else {
            loadStaticFallbackQuotes();
        }
    }

    private void loadStaticFallbackQuotes() {
        list2 = new ArrayList<>();
        list2.add(new new_item_post(getString(R.string.my42)));
        list2.add(new new_item_post(getString(R.string.my1)));
        list2.add(new new_item_post(getString(R.string.my2)));
        list2.add(new new_item_post(getString(R.string.my3)));
        list2.add(new new_item_post(getString(R.string.my4)));
        list2.add(new new_item_post(getString(R.string.my5)));
        list2.add(new new_item_post(getString(R.string.my6)));
        list2.add(new new_item_post(getString(R.string.my7)));
        list2.add(new new_item_post(getString(R.string.my8)));
        list2.add(new new_item_post(getString(R.string.my9)));
        list2.add(new new_item_post(getString(R.string.my10)));
        list2.add(new new_item_post(getString(R.string.my11)));
        list2.add(new new_item_post(getString(R.string.my12)));
        list2.add(new new_item_post(getString(R.string.my13)));
        list2.add(new new_item_post(getString(R.string.my14)));
        list2.add(new new_item_post(getString(R.string.my15)));
        list2.add(new new_item_post(getString(R.string.my16)));
        list2.add(new new_item_post(getString(R.string.my17)));
        list2.add(new new_item_post(getString(R.string.my18)));
        list2.add(new new_item_post(getString(R.string.my19)));
        list2.add(new new_item_post(getString(R.string.my21)));
        list2.add(new new_item_post(getString(R.string.my22)));
        list2.add(new new_item_post(getString(R.string.my23)));
        list2.add(new new_item_post(getString(R.string.my26)));
        list2.add(new new_item_post(getString(R.string.my27)));
        list2.add(new new_item_post(getString(R.string.my28)));
        list2.add(new new_item_post(getString(R.string.my29)));
        list2.add(new new_item_post(getString(R.string.my30)));
        list2.add(new new_item_post(getString(R.string.my31)));
        list2.add(new new_item_post(getString(R.string.my32)));
        list2.add(new new_item_post(getString(R.string.my33)));
        list2.add(new new_item_post(getString(R.string.my34)));
        list2.add(new new_item_post(getString(R.string.my35)));
        list2.add(new new_item_post(getString(R.string.my36)));
        list2.add(new new_item_post(getString(R.string.my37)));
        list2.add(new new_item_post(getString(R.string.my38)));
        list2.add(new new_item_post(getString(R.string.my39)));
        list2.add(new new_item_post(getString(R.string.my40)));
        list2.add(new new_item_post(getString(R.string.my41)));
        list2.add(new new_item_post(getString(R.string.staticvalue)));

        Adaptersada adapter2 = new Adaptersada(list2, this);
        binding.rec2.setAdapter(adapter2);
    }

    @Override
    public void onMessengerItemClick(new_item_post item) {
    }

    @Override
    protected void onDestroy() {
        executorService.shutdown();
        super.onDestroy();
    }
}
